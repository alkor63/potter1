package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.HouseService;
import java.util.List;

@RestController
@RequestMapping("faculty")
public class HouseController {
    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @PostMapping
    public ResponseEntity createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = houseService.createFaculty(faculty);
        return ResponseEntity.ok(createdFaculty);
    }

    @GetMapping("{id}")
    public ResponseEntity getFaculty(@PathVariable Long id) {
        Faculty faculty = houseService.getFacultyById(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
    @GetMapping()
    public ResponseEntity getAllFaculties() {
        List<Faculty> facultyList = houseService.getAllFaculties();
        if (facultyList.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyList);
    }
    @PutMapping()
    public ResponseEntity updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = houseService.updateFaculty(faculty.getId(), faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("{id}")
    public Faculty deleteFaculty(@PathVariable Long id) {
        return houseService.deleteFaculty(id);
    }

    @GetMapping("house/{color}")
    public ResponseEntity getFacultyByColor(@PathVariable String color) {
        List<Faculty> facultyList = houseService.getFacultiesByColor(color);
        if (facultyList.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyList);
    }
}
