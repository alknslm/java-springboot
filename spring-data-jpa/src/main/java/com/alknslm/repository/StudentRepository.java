package com.alknslm.repository;

import com.alknslm.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    /** JPARepository veritabanı işlemlerini kapsam hazır methodlar kullanılacak.
     * <,> içerisne ilk kısmı dataclass için 2.kısmı primarykey için*/

    //Hibernate Query Language(HQL) sorgusu yazarken class ismi ve class içerisindeki fieldlar yazılır tablodaki fieldlar üzerinden değil
    @Query(value="from Student", nativeQuery = false)
    List<Student> findAllStudentsHQL();

    //SQL : tablo ismi ve tablodaki fieldlar üzerinden sorgu yazılır. classlar üzerinden değil. schema ile beraber yazılır.
    @Query(value = "select * from student.student", nativeQuery = true)
    List<Student> findAllStudentsSQL();

    @Query(value = "from Student s WHERE s.id = :studentId")
    Optional<Student> findStudentById(Integer studentId);
}
