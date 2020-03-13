package com.tothenew.JPADemo2.Repositories;

import com.tothenew.JPADemo2.Entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {
//    @Query("from Student")
//    List<Student> findAllStudents();

    @Query("select st.fname,st.lname from Student st")
    List<Object[]> findAllPartialData();

    @Query("from Student where score>:min and score<:max")
    List<Student> findStudentForGivenScore(@Param("min") int min,@Param("max") int max);

    @Query("from Student where fname=:firstname")
    List<Student> findAllStudentByFirstName(@Param("firstname")String firstname);

    @Modifying
    @Query("delete from Student where fname=:firstname")
    void deleteAllStudentByFirstName(@Param("firstname")String firstname);

    @Query("from Student")
    List<Student> findAllStudents(Pageable pageable);

    @Query(value = "select * from student where fname=:firstName", nativeQuery = true)
    List<Student> findAllStudentNQ(String firstName);

}
