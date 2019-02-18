package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.ClassContact;
import com.nasi.portal.data.model.ClassContactCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassContactMapper {
    int countByExample(ClassContactCriteria example);

    int deleteByExample(ClassContactCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(ClassContact record);

    int insertSelective(ClassContact record);

    List<ClassContact> selectByExample(ClassContactCriteria example);

    ClassContact selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ClassContact record, @Param("example") ClassContactCriteria example);

    int updateByExample(@Param("record") ClassContact record, @Param("example") ClassContactCriteria example);

    int updateByPrimaryKeySelective(ClassContact record);

    int updateByPrimaryKey(ClassContact record);
}