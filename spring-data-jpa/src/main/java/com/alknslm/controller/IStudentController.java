package com.alknslm.controller;

import com.alknslm.dto.DtoStudent;
import com.alknslm.dto.DtoStudentIU;
import com.alknslm.entities.Student;

import java.util.List;

public interface IStudentController {

    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
