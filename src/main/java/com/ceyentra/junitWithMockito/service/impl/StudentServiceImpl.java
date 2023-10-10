package com.ceyentra.junitWithMockito.service.impl;

import com.ceyentra.junitWithMockito.dto.StudentDTO;
import com.ceyentra.junitWithMockito.entity.Student;
import com.ceyentra.junitWithMockito.entity.StudentSchool;
import com.ceyentra.junitWithMockito.repo.StudentRepo;
import com.ceyentra.junitWithMockito.repo.StudentSchoolRepo;
import com.ceyentra.junitWithMockito.service.StudentService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final StudentSchoolRepo studentSchoolRepo;

    public StudentServiceImpl(StudentRepo studentRepo, StudentSchoolRepo studentSchoolRepo) {
        this.studentRepo = studentRepo;
        this.studentSchoolRepo = studentSchoolRepo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED , rollbackFor = Exception.class)
    public StudentDTO addStudent(StudentDTO studentDTO) {
        log.info("Execute method addStudent");
        try{
//            Student student = new Student();
//            student.setStudentName(studentDTO.getStudentName());
//            student.setContact(studentDTO.getContact());
//            student.setAddress(studentDTO.getAddress());
//
//            Student saveStudent = studentRepo.save(student);
            return new StudentDTO(Long.parseLong("1"),"Yasiru","Panadura","0710821117");
        }catch (Exception e){
            log.error("Method addStudent: "+e);
            throw e;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED , rollbackFor = Exception.class)
    public void updateStudent(StudentDTO studentDTO) {
        log.info("Execute method updateStudent");
        try{
            Optional<Student> optionalStudent = studentRepo.findById(studentDTO.getStudentId());
            if(optionalStudent.isEmpty())
                throw new RuntimeException("Student not found.");

            Student student = optionalStudent.get();
            student.setStudentName(studentDTO.getStudentName());
            student.setContact(studentDTO.getContact());
            student.setAddress(studentDTO.getAddress());

            studentRepo.save(student);

        }catch (Exception e){
            log.error("Method updateStudent: "+e);
            throw e;
        }
    }

    @Override
    public List<StudentDTO> getStudents(long studentId, String studentName) {
        log.info("Execute method getStudents");
        try{
            return studentRepo.getFilterStudent(studentId, studentName);
        }catch (Exception e){
            log.error("Method getStudents: "+e);
            throw e;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED , rollbackFor = Exception.class)
    public void deleteStudent(long studentId) {
        log.info("Execute method deleteStudent");
        try{
            Optional<Student> optionalStudent = studentRepo.findById(studentId);
            if(optionalStudent.isEmpty())
                throw new RuntimeException("Student is not found");

            Student student = optionalStudent.get();
            List<StudentSchool> studentSchoolList = student.getStudentSchoolList();
            if(!studentSchoolList.isEmpty())
                studentSchoolRepo.deleteAll(studentSchoolList);

            studentRepo.delete(student);
        }catch (Exception e){
            log.error("Method deleteStudent: "+e);
            throw e;
        }
    }
}
