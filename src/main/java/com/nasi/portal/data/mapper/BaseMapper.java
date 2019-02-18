/**
 * @author anliyong
 */
package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.BaseModel;

/**
 * 封装了简单的CRUD操作的mapper接口
 * 
 * @author anliyong
 * 
 */
public interface BaseMapper<T extends BaseModel> {

    public static final String SELECT = " SELECT ";
    
    public static final String UPDATE = " UPDATE ";
    
    public static final String DELETE = " DELETE ";
    
    public static final String WHERE = " WHERE ";
    
    public static final String AND = " AND ";
    
    public static final String OR = " OR ";
    
    public static final String JOIN = " JOIN ";
    
    public static final String ON = " ON ";
    
    public static final String LEFT = " LEFT ";
    
    public static final String COUNT_ALL = " COUNT(*) ";
    
    public static final String SET = " SET ";
    
    public static final String INSERT_INTO = " INSERT INTO ";
    
    public static final String FROM = " FROM ";
    
    public static final String ORDER_BY = " ORDER BY ";
    
    public static final String DESC = " DESC ";
    
    public static final String ASC = " ASC ";
    
    public static final String GROUP_BY = " GROUP BY ";
    
    public static final String HAVING = " HAVING ";
    
    public static final String LIMIT = " LIMIT ";
    
    public static final String UNION = " UNION ";
    
    public static final String UNION_ALL = " UNION ALL ";
    
    public static final String BETWEEN = " BETWEEN ";
    
    public static final String DISTINCT = " DISTINCT ";
    
    public static final String LIKE = " LIKE ";
    
    public static final String IN = " IN ";
    
    public static final String CASE = " CASE ";
    
    public static final String WHEN = " WHEN ";
    
    public static final String THEN = " THEN ";
    
    public static final String END = " END ";
    
    public static final String AS = " AS ";
    
    public static final String VALUES = " VALUES ";
    
}
