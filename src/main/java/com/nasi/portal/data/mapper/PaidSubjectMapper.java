package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.PaidSubject;
import com.nasi.portal.data.model.PaidSubjectCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaidSubjectMapper {
    int countByExample(PaidSubjectCriteria example);

    int deleteByExample(PaidSubjectCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(PaidSubject record);

    int insertSelective(PaidSubject record);

    List<PaidSubject> selectByExample(PaidSubjectCriteria example);

    PaidSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PaidSubject record, @Param("example") PaidSubjectCriteria example);

    int updateByExample(@Param("record") PaidSubject record, @Param("example") PaidSubjectCriteria example);

    int updateByPrimaryKeySelective(PaidSubject record);

    int updateByPrimaryKey(PaidSubject record);
}