package com.alknslm.services.impl;

import com.alknslm.dto.DtoStudent;
import com.alknslm.dto.DtoStudentIU;
import com.alknslm.entities.Student;
import com.alknslm.repository.StudentRepository;
import com.alknslm.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        Student student = new Student();
        DtoStudent response = new DtoStudent();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent,response);
        return response;
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        /** Veritabanından dönen her data için cpoy işlemi yapıyoruz dto'lara çeviriyoruz*/
        List<DtoStudent> dtolist = new ArrayList<>();
        List<Student> studentlist = studentRepository.findAll(); // repositorynin kendi methodu
//        List<Student> studentlist = studentRepository.findAllStudentsHQL(); // kendi yazdığımız HQL
//        List<Student> studentlist = studentRepository.findAllStudentsSQL(); // kendi yazdığımız SQL

        for(Student student : studentlist){
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(student,dto);
            dtolist.add(dto);
        }
        return dtolist;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
//        Optional<Student> optional = studentRepository.findStudentById(id); // HQL srogusu ile yazılan
        DtoStudent dto = new DtoStudent();
        if (optional.isPresent()) {
            Student dbStudent = optional.get();
            BeanUtils.copyProperties(dbStudent,dto);
            return dto;
        }
        return null;
    }

    @Override
    public void deleteStudent(Integer id) {
//        DtoStudent dtoStudent = getStudentById(id); bu method dto'ya çeviriyor
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()) {
            studentRepository.delete(optional.get());
        }
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
        DtoStudent dto = new DtoStudent();
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            Student dbStudent = optional.get();

            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());

            Student updatedStudent = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent,dto);
            return dto;
        }
        return null;
    }
}
