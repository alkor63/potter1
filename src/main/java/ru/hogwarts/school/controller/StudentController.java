package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

@RestController
@RequestMapping("student;")
public class StudentController {

        private final StudentService studentService;

        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }

        @PostMapping
        public ResponseEntity createStudent(@RequestBody Student student) {
            Student createdStudent = studentService.createStudent(student);
            return ResponseEntity.ok(createdStudent);
        }

        @GetMapping("{studentId}")
        public ResponseEntity getStudent(@PathVariable Long studentId) {
            Student student = studentService.getStudentById(studentId);
            if (student == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(student);
        }

        @PutMapping()
        public ResponseEntity updateStudent(@RequestBody Student student) {
            Student updatedStudent = studentService.updateStudent(student.getId(), student);
            return ResponseEntity.ok(updatedStudent);
        }

        @DeleteMapping("{id}")
        public Student deleteStudent(@PathVariable Long id) {
            return studentService.deleteStudent(id);
        }
}
