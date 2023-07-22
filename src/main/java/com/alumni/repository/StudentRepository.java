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


    @Query(value = "select  count(student.id), state.name from student \n" +
            "inner join base_user on student.user_id = base_user.id \n" +
            "inner join state on state.id = base_user.state_id\n" +
            "group by state.id, state.name;",nativeQuery = true)
    List<Object[]> getStudentCountPerState();


    @Query(value = "select  count(student.id), city.name from student \n" +
            "inner join base_user on student.user_id = base_user.id \n" +
            "inner join city on city.id = base_user.city_id\n" +
            "group by city.id, city.name;",nativeQuery = true)
    List<Object[]> getStudentCountPerCity();
}
