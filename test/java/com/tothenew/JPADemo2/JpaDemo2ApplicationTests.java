package com.tothenew.JPADemo2;

import com.tothenew.JPADemo2.Entities.*;
import com.tothenew.JPADemo2.Repositories.EmployeeRepository;
//import com.tothenew.JPADemo2.Repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class JpaDemo2ApplicationTests {

//    @Autowired
//    StudentRepository srepository;
//
//    @Test
//    public void contextLoads(){
//    }
//
//    @Test
//    void testStudentCreate() {
//        Student student = new Student();
//        student.setFirstName("Kandy");
//        student.setLastName("Arora");
//        student.setScore(88);
//
//        Student student2 = new Student();
//        student2.setFirstName("Ayush");
//        student2.setLastName("Agrawal");
//        student2.setScore(75);
//
//        srepository.save(student);
//        srepository.save(student2);
//    }
//
////    @Test
////    public void testFindAllStudents(){
////        System.out.println(repository.findAllStudents());
////    }
//
//    public void testFindPartial() {
//        List<Object[]> partialdata = srepository.findAllPartialData();
//        for (Object[] objects : partialdata) {
//            System.out.println(objects[0]);
//            System.out.println(objects[1]);
//        }
//    }
//
//    @Test
//    public void testFindByGivenScore() {
//        System.out.println(srepository.findStudentForGivenScore(88, 75));
//    }
//
//    @Test
//    public void testFindAllByFname() {
//        System.out.println(srepository.findAllStudentByFirstName("Kandy"));
//    }
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void testdeleteAllByFname() {
//        srepository.deleteAllStudentByFirstName("Kandy");
//    }
//
//    @Test
//    public void testFindAllStudents() {
//        System.out.println(srepository.findAllStudents(PageRequest.of(0, 5, Sort.Direction.DESC, "id")));
//    }
//
//    @Test
//    public void testStudentsNQ() {
//        System.out.println(srepository.findAllStudentNQ("Kandy"));
//    }

    //--------------------------------------------------------------------------------------------------------------


//    @Autowired
//    TransactionRepository tRepository;
//
//    @Test
//    void testTransactionCreate() {
//
//        CreditCard creditCard = new CreditCard();
//        creditCard.setAmount((double) 5000);
//        creditCard.setCardno("4404");
//        tRepository.save(creditCard);
//
//
//        Cheque cheque = new Cheque();
//        cheque.setChequeno("2397");
//        cheque.setAmount((double) 10000);
//        tRepository.save(cheque);
//    }
//
//    @Test
//    public void testCreditCard() {
//        CreditCard creditCard = new CreditCard();
//        creditCard.setAmount((double) 5000);
//        creditCard.setCardno("4404");
//        tRepository.save(creditCard);
//    }
//
//    @Test
//    public void testCheque() {
//        Cheque cheque = new Cheque();
//        cheque.setChequeno("2397");
//        cheque.setAmount((double) 10000);
//        tRepository.save(cheque);
//    }


//-------------------------------------------------------------------------------------------------------------

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testEmployeeCreate(){
        Employee employee = new Employee();
        employee.setId(123);
        employee.setName("Kandy");

        Address address = new Address();
        address.setCity("Noida");
        address.setStreetAddress("Logix Blossom Zest");
        address.setCountry("India");
        address.setState("Uttar Pradesh");
        address.setZipcode("231001");
        employee.setAddress(address);

        employeeRepository.save(employee);
    }
}