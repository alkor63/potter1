package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;
@Service
public class HouseService {
    private Map<Long, Faculty> facultyMap = new HashMap<>();
    private Long lastFacultyId = 0L;
    public Faculty createFaculty(Faculty faculty){
        faculty.setId(++lastFacultyId);
        facultyMap.put(lastFacultyId, faculty);
        return faculty;
    }
    public Faculty getFacultyById(Long id){
        return facultyMap.get(id);
    }
    public Faculty updateFaculty(Long id, Faculty faculty){
        facultyMap.put(id, faculty);
        return faculty;
    }
    public Faculty deleteFaculty(Long id){
        return facultyMap.remove(id);
    }
}
