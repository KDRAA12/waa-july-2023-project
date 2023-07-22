package com.alumni.repository;

import com.alumni.entity.Faculty;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {


//    List<Faculty> findAllByNameContainsIgnoreCaseOrderByIdDesc(String name, Pageable of);
//    List<Faculty> findAllOrderByIdDesc(Pageable of);

//    @Query("SELECT u FROM User u WHERE u.status = 1")
    @Query(value = "SELECT faculty.*, base_user.* FROM faculty INNER JOIN base_user on faculty.user_id = base_user.id where stateId = ?1", nativeQuery = true)
    List<Faculty> findFacultyByStateId(Long stateId);

    @Query(value = "select  count(faculty.id), state.name from faculty \n" +
            "inner join base_user on faculty.user_id = base_user.id \n" +
            "inner join state on state.id = base_user.state_id\n" +
            "group by state.id, state.name;",nativeQuery = true)
    List<Objects[]> getFacultyCountPerState();
}
