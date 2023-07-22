package com.alumni.repository;

import com.alumni.dtos.response.StudentResponseDTO;
import com.alumni.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
//    @Query(value = "SELECT * FROM student WHERE (1=1 or :cityID=stateID ) AND (1=1 ) AND ('' = :major OR major LIKE %:major%) AND ('' = :name OR name LIKE %:name%)", nativeQuery = true)
//    List<Student> getList(@Param("stateID") Long stateID, @Param("cityID") Long cityID, @Param("major") String major, @Param("name") String name, Pageable pageable);

    Student findByUserEmail(String s);

    Student findByUserId(long id);



    List<Student> findAllByUserStateNameContainsIgnoreCaseAndUserCityNameContainsIgnoreCaseAndUserFirstNameContainsIgnoreCaseAndMajorContainsIgnoreCase(String state, String city, String major, String name);
}
