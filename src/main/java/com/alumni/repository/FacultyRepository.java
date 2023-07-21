package com.alumni.repository;

import com.alumni.entity.Faculty;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Long> {


//    List<Faculty> findAllByNameContainsIgnoreCaseOrderByIdDesc(String name, Pageable of);
//    List<Faculty> findAllOrderByIdDesc(Pageable of);

//    @Query("SELECT u FROM User u WHERE u.status = 1")
    @Query(value = "SELECT faculty.*, base_user.* FROM faculty INNER JOIN base_user on faculty.user_id = base_user.id where stateId = ?1", nativeQuery = true)
    List<Faculty> findFacultyByStateId(Long stateId);
}
