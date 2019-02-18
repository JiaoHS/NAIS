/**
 * @author anliyong@baidu.com
 * 2015-7-25 上午11:51:41
 */
package com.nasi.portal.data.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.nasi.portal.data.mapper.BaseMapper;
import com.nasi.portal.data.model.CourseArrange;

/**
 * @author anliyong@baidu.com
 * 2015-7-25上午11:51:41
 */
public interface CourseArrangeCustomMapper extends BaseMapper<CourseArrange> {

    @Select("select distinct professor_id from course_arrange where school_id = #{id} and status = #{status}")
    public List<Integer> getProfessorIdsBySchoolId(@Param ("id") Integer id, @Param ("status") Integer status);
    
}
