package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.Professor;
import com.nasi.portal.data.model.ProfessorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProfessorMapper {
    int countByExample(ProfessorExample example);

    int deleteByExample(ProfessorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Professor record);

    int insertSelective(Professor record);

    List<Professor> selectByExample(ProfessorExample example);

    Professor selectByPrimaryKey(Long id);
    Professor selectByName(String name);
    int updateByExampleSelective(@Param("record") Professor record, @Param("example") ProfessorExample example);

    int updateByExample(@Param("record") Professor record, @Param("example") ProfessorExample example);

    int updateByPrimaryKeySelective(Professor record);

    int updateByPrimaryKey(Professor record);

    List<Map<String,Object>> getProfessorListAll(Integer schoolId);

}