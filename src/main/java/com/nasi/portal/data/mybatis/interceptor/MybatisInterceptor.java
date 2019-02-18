package com.nasi.portal.data.mybatis.interceptor;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据库拦截器
 * 
 **/
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
        @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class }) })
public class MybatisInterceptor implements Interceptor {

    private static final String DAO_STR = ".dao.";

    /**
     * sql retry count
     */
    private static final int SQL_RETRY_COUNT = 3;

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisInterceptor.class);

    public Object intercept(Invocation invocation) throws Throwable {
        StringBuffer buf = new StringBuffer("[SQL]");
        try {

            Object parameter = null;
            if (invocation.getArgs() != null && invocation.getArgs().length > 1) {
                parameter = invocation.getArgs()[1];
                MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
                BoundSql boundSql = mappedStatement.getBoundSql(parameter);

                Configuration configuration = mappedStatement.getConfiguration();

                String sqlId = mappedStatement.getId();

                String sql = getSql(configuration, boundSql, sqlId);
                buf.append(sql == null ? "" : sql);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e.fillInStackTrace());
        }
        Object returnValue = null;
        for (int i = 0; i < SQL_RETRY_COUNT; i++) {
            try {
                long start = System.currentTimeMillis();
                returnValue = invocation.proceed();
                long end = System.currentTimeMillis();
                long time = (end - start);
                buf.append(":").append(time).append("ms");
                break;
            } catch (Exception e) {
                LOGGER.error(e.getMessage(), e.fillInStackTrace());
                if (i == SQL_RETRY_COUNT - 1) {
                    buf.append(" return value[" + returnValue + "]");
                    LOGGER.info(buf.toString());
                    throw e;
                }
                Thread.sleep(500L);
            }
        }

        buf.append(" return value[" + returnValue + "]");
        LOGGER.info(buf.toString());
        return returnValue;
    }

    public static String getSql(Configuration configuration, BoundSql boundSql, String sqlId) {
        String sql = showSql(configuration, boundSql);
        StringBuilder str = new StringBuilder(100);
        // dao之前路径用*代替
        int indexOfDao = sqlId.indexOf(DAO_STR);
        if (indexOfDao > 0) {
            sqlId = "*." + sqlId.substring(indexOfDao + DAO_STR.length());
        }
        str.append(sqlId);
        str.append(":");
        str.append(sql);
        return str.toString();
    }

    private static String getParameterValue(Object obj) {
        String value = null;
        if (obj instanceof String) {
            value = "'" + obj.toString() + "'";
        } else if (obj instanceof Date) {
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
            value = "'" + formatter.format((Date) obj) + "'";
        } else {
            if (obj != null) {
                value = obj.toString();
            } else {
                value = "";
            }

        }
        return value;
    }

    public static String showSql(Configuration configuration, BoundSql boundSql) {
        Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");
        if (parameterMappings.size() > 0 && parameterObject != null) {
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                sql = sql.replaceFirst("\\?", getParameterValue(parameterObject));

            } else {
                MetaObject metaObject = configuration.newMetaObject(parameterObject);
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        sql = sql.replaceFirst("\\?", getParameterValue(obj));
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        Object obj = boundSql.getAdditionalParameter(propertyName);
                        sql = sql.replaceFirst("\\?", getParameterValue(obj));
                    }
                }
            }
        }
        return sql;
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
        // TODO Auto-generated method stub
    }
}
