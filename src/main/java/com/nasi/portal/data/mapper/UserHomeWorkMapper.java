package com.nasi.portal.data.mapper;

import com.nasi.portal.data.model.UserHomeWork;
import com.nasi.portal.data.model.UserHomeWorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserHomeWorkMapper {
    int countByExample(UserHomeWorkExample example);

    int deleteByExample(UserHomeWorkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserHomeWork record);

    int insertSelective(UserHomeWork record);

    List<UserHomeWork> selectByExample(UserHomeWorkExample example);

    UserHomeWork selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserHomeWork record, @Param("example") UserHomeWorkExample example);

    int updateByExample(@Param("record") UserHomeWork record, @Param("example") UserHomeWorkExample example);

    int updateByPrimaryKeySelective(UserHomeWork record);

    int updateByPrimaryKey(UserHomeWork record);
}