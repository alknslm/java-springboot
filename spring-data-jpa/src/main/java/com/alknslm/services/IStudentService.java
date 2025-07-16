package com.alknslm.services;

import com.alknslm.dto.DtoStudent;
import com.alknslm.dto.DtoStudentIU;
import com.alknslm.entities.Student;

import java.util.List;

public interface IStudentService {

    public DtoStudent saveStudent(DtoStudentIU student);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(Integer id);

    public void deleteStudent(Integer id);

    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
