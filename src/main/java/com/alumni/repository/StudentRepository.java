package com.alumni.repository;

import com.alumni.dtos.response.StudentResponseDTO;
import com.alumni.entity.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
//    @Query(value = "SELECT * FROM student WHERE (1=1 or :cityID=stateID ) AND (1=1 ) AND ('' = :major OR major LIKE %:major%) AND ('' = :name OR name LIKE %:name%)", nativeQuery = true)
//    List<Student> getList(@Param("stateID") Long stateID, @Param("cityID") Long cityID, @Param("major") String major, @Param("name") String name, Pageable pageable);

    Student findByUserEmail(String s);

    Student findByUserId(long id);



    List<Student> findAllByUserStateNameContainsIgnoreCaseAndUserCityNameContainsIgnoreCaseAndUserFirstNameContainsIgnoreCaseAndMajorContainsIgnoreCase(String state, String city, String major, String name);
    
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
