package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.CourseHomeWorkCommit;
import com.nasi.portal.data.model.CourseHomeWorkCommitCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseHomeWorkCommitMapper {
    int countByExample(CourseHomeWorkCommitCriteria example);

    int deleteByExample(CourseHomeWorkCommitCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseHomeWorkCommit record);

    int insertSelective(CourseHomeWorkCommit record);

    List<CourseHomeWorkCommit> selectByExample(CourseHomeWorkCommitCriteria example);

    CourseHomeWorkCommit selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CourseHomeWorkCommit record, @Param("example") CourseHomeWorkCommitCriteria example);

    int updateByExample(@Param("record") CourseHomeWorkCommit record, @Param("example") CourseHomeWorkCommitCriteria example);

    int updateByPrimaryKeySelective(CourseHomeWorkCommit record);

    int updateByPrimaryKey(CourseHomeWorkCommit record);
}