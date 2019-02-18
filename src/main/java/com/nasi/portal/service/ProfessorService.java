package com.nasi.portal.service;

import com.nasi.portal.data.model.Professor;
import com.nasi.portal.data.model.ProfessorMsg;
import com.nasi.portal.web.controller.caohao.DataGridResult;
import com.nasi.portal.web.model.JsonResult;

import java.util.List;
import java.util.Map;

/**
 *
 * created by River on 2018/4/18
 *
 */
public interface ProfessorService {
    List<Professor> getAll();

    void insertProfessor(Professor professor);

    void deleteBy(Long id);

    Professor showProfessor(Long id);

    DataGridResult getProfessorListByPage(Integer page, Integer rows);

    DataGridResult findProfessorListPageByName(String professorName, Integer page, Integer rows);

    DataGridResult findProfessorListPageBySchool(String fromSchool, Integer page, Integer rows);

    DataGridResult findProfessorListPageWithProfessorNameAndSchool(String professorName, String fromSchool, Integer page, Integer rows);

    void updateProfessor(Professor professor);

    JsonResult<?> getProfessorListAll(Integer schoolId,int page,int rows);


    Professor getProfessorById(Long professorId);
    Professor getProfessorByName(String name);
}
