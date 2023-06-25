package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private Map<Long, Student> studentMap = new HashMap<>();
    private Long lastStudentId = 0L;
    public Student createStudent(Student student){
        student.setId(++lastStudentId);
        studentMap.put(lastStudentId, student);
        return student;
    }
    public Student getStudentById(Long id){
        return studentMap.get(id);
    }
    public Student updateStudent(Long id, Student student){
        studentMap.put(id, student);
        return student;
    }
    public Student deleteStudent(Long id){
        return studentMap.remove(id);
    }
}
