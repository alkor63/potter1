package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HouseService {
    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private Long lastFacultyId = 0L;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastFacultyId);
        facultyMap.put(lastFacultyId, faculty);
        return faculty;
    }
    public Faculty getFacultyById(Long id) {
        Faculty faculty;
        try {
            faculty = facultyMap.get(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return faculty;
    }
    public Faculty updateFaculty(Long id, Faculty faculty) {
        facultyMap.put(id, faculty);
        return faculty;
    }
    public Faculty deleteFaculty(Long id) {
        return facultyMap.remove(id);
    }
    public List<Faculty> getFacultiesByColor(String color) {
        List<Faculty> faculties = new ArrayList<>();
        for (Faculty faculty : facultyMap.values()) {
            if (faculty.getColor().contains(color)) faculties.add(faculty);
        }
        return faculties;
    }
    public List<Faculty> getAllFaculties() {
        List<Faculty> faculties = new ArrayList<>();
        for (Faculty faculty : facultyMap.values()) {
            faculties.add(faculty);
        }
        return faculties;
    }
}
