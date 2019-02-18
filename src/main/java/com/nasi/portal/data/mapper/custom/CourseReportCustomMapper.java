/**
 * @author anliyong@baidu.com
 * 2015-7-28 下午11:20:51
 */
package com.nasi.portal.data.mapper.custom;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * @author anliyong@baidu.com
 * 2015-7-28下午11:20:51
 */
public interface CourseReportCustomMapper {

    @Update("update course_report set score = #{score} where id = #{id}")
    public int updateScoreByPrimaryKey(@Param("id") Integer id, @Param("score") String score);
    
}
