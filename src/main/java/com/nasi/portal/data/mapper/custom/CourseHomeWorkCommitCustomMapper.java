package com.nasi.portal.data.mapper.custom;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.nasi.portal.data.mapper.BaseMapper;
import com.nasi.portal.data.model.CourseHomeWorkCommit;

public interface CourseHomeWorkCommitCustomMapper extends BaseMapper<CourseHomeWorkCommit> {

    final static String COLUMN = " id,assign_id as assignId,assign_name as assignName,arrange_id as arrangeId,student_id as studentId,student_name_cn as studentNameCn,student_name_en as studentNameEn,commit_status as commitStatus,commit_type as commitType,course_code as courseCode,course_name_cn as courseNameCn,course_name_en as courseNameEn,work_path as workPath,commit_path as commitPath,commit_total_score as commitTotalScore,commit_this_score as commitThisScore,commit_desc as commitDesc,commit_time as commitTime,create_time as createTime,update_time as updateTime,create_user as createUser,update_user as updateUser ";
    final static String TABLE = " course_home_work_commit ";

    @Select("<script>" + SELECT + " COUNT(1) " + FROM + TABLE + WHERE + " 1 = 1 "
            + "<if test='assignId != null'> and assign_id = #{assignId} </if>"
            + "<if test='name != null'> and (student_name_cn = #{name} or student_name_en = #{name}) </if></script>")
    @ResultType(Integer.class)
    public int count(@Param("assignId") Long assignId, @Param("name") String name);

    @Select("<script>" + SELECT + COLUMN + FROM + TABLE + WHERE + " commit_status in (1,3) "
            + "<if test='assignId != null'> and assign_id = #{assignId} </if>"
            + "<if test='name != null'> and (student_name_cn = #{name} or student_name_en = #{name}) </if>"
            + " limit #{start}, #{size} </script>")
    @ResultType(CourseHomeWorkCommit.class)
    public List<CourseHomeWorkCommit> search(@Param("assignId") Long assignId, @Param("name") String name,
            @Param("start") int start, @Param("size") int size);
    
    @Update(UPDATE + TABLE + SET + " commit_status = 3 ,commit_this_score = #{score} where id = #{id}")
    public int updateScoreByPrimaryKey(@Param("id") Integer id, @Param("score") Integer score);

}
