package com.alumni.repository;

import com.alumni.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query(value = "select * from student where ('' = :state or state like :state) and ('' = :city or  city like :city)  and ('' = :major or major like :major)  and ('' = :name or  name like :name ) ",nativeQuery = true)
    List<Student> getList(@Param("state") String state,@Param("city") String city,@Param("major") String major,@Param("name") String name,Pageable pageable);

    Student findByUserEmail(String s);


    @Query(value = "select count(id), student.state from student group by state;",nativeQuery = true)
    List<Object[]> getStudentCountPerState();

    @Query(value = "select count(id), student.city from student group by city;",nativeQuery = true)
    List<Object[]> getStudentCountPerCity();
}
