package com.alknslm.repository;

import com.alknslm.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    /** JPARepository veritabanı işlemlerini kapsam hazır methodlar kullanılacak.
     * <,> içerisne ilk kısmı dataclass için 2.kısmı primarykey için*/


}
