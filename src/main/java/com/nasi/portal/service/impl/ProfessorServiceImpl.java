package com.nasi.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nasi.portal.data.mapper.ProfessorMapper;
import com.nasi.portal.data.model.Professor;
import com.nasi.portal.data.model.ProfessorExample;
import com.nasi.portal.data.model.ProfessorMsg;
import com.nasi.portal.service.ProfessorService;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.model.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * created by River on 2018/4/18
 *
 */
@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorMapper professorMapper;

    @Override
    public List<Professor> getAll() {
        List<Professor> professorList = professorMapper.selectByExample(new ProfessorExample());
        return professorList;
    }

    @Override
    public void insertProfessor(Professor professor) {
        professorMapper.insertSelective(professor);
    }

    @Override
    @Transactional
    public void deleteBy(Long id) {
        professorMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Professor showProfessor(Long id) {
        Professor professor = professorMapper.selectByPrimaryKey(id);
        return professor;
    }

    @Override
    public DataGridResult getProfessorListByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows,true);
        ProfessorExample example=new ProfessorExample();
        example.setOrderByClause("create_time desc");
        List<Professor> professors=professorMapper.selectByExample(example);
        PageInfo<Professor> professorPageInfo=new PageInfo<Professor>(professors);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(professors);
        dataGridResult.setTotal(professorPageInfo.getTotal());
        return dataGridResult;
    }

    @Override
    public DataGridResult findProfessorListPageByName(String professorName, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        ProfessorExample example=new ProfessorExample();
        example.createCriteria().andProfessorNameEqualTo(professorName);
        example.setOrderByClause("create_time desc");
        List<Professor> professors=professorMapper.selectByExample(example);
        PageInfo<Professor> professorPageInfo=new PageInfo<Professor>(professors);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(professors);
        dataGridResult.setTotal(professorPageInfo.getTotal());
        return dataGridResult;
    }

    @Override
    public DataGridResult findProfessorListPageBySchool(String fromSchool, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        ProfessorExample example=new ProfessorExample();
        example.createCriteria().andFromSchoolLike(fromSchool+"%");
        example.setOrderByClause("create_time desc");
        List<Professor> professors=professorMapper.selectByExample(example);
        PageInfo<Professor> professorPageInfo=new PageInfo<Professor>(professors);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(professors);
        dataGridResult.setTotal(professorPageInfo.getTotal());
        return dataGridResult;
    }

    @Override
    public DataGridResult findProfessorListPageWithProfessorNameAndSchool(String professorName, String fromSchool, Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        ProfessorExample example=new ProfessorExample();
        example.createCriteria().andProfessorNameEqualTo(professorName).andFromSchoolLike(fromSchool+"%");
        example.setOrderByClause("create_time desc");
        List<Professor> professors=professorMapper.selectByExample(example);
        PageInfo<Professor> professorPageInfo=new PageInfo<Professor>(professors);

        DataGridResult dataGridResult=new DataGridResult();
        dataGridResult.setRows(professors);
        dataGridResult.setTotal(professorPageInfo.getTotal());
        return dataGridResult;
    }

    @Override
    public void updateProfessor(Professor professor) {
        professorMapper.updateByPrimaryKeySelective(professor);
    }

    @Override
    public  JsonResult<?> getProfessorListAll(Integer schoolId,int page,int rows) {
        PageHelper.startPage(page,rows);

        List<Map<String, Object>> professorListAll = professorMapper.getProfessorListAll(schoolId);
        if (professorListAll==null || professorListAll.size() ==0){
            return null;
        }
        List<ProfessorMsg> professorMsgList =new ArrayList<ProfessorMsg>();

        for(Map<String, Object> map:professorListAll){
            ProfessorMsg professorMsg = new ProfessorMsg();
            professorMsg.setId((Long) map.get("id"));
            professorMsg.setFromSchool(map.get("fromSchool").toString());
            professorMsg.setProfessorName(map.get("professorName").toString());
            professorMsg.setDescription(map.get("description").toString());
            professorMsg.setPhoto(map.get("photo").toString());
            List<String> schoolNameList= Arrays.asList(map.get("schoolNames").toString().split(","));
            List<String> courseNameList= Arrays.asList(map.get("courseNames").toString().split(","));
            professorMsg.setCourseNameList(courseNameList);
            professorMsg.setSchoolNameList(schoolNameList);
            professorMsgList.add(professorMsg);
        }
        PageInfo< ProfessorMsg> professorPageInfo=new PageInfo<ProfessorMsg>(professorMsgList);
        return JsonResult.success(professorPageInfo);
    }

    @Override
    public Professor getProfessorById(Long professorId) {
        Professor professor = professorMapper.selectByPrimaryKey(professorId);
        return professor;
    }

    @Override
    public Professor getProfessorByName(String name) {
        Professor professor = professorMapper.selectByName(name);
        return professor;
    }
}
