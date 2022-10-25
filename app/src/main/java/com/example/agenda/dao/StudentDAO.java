package com.example.agenda.dao;

import com.example.agenda.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final static List<Student> students = new ArrayList<>();

    public void save(Student newStudent) {
        students.add(newStudent);
    }

    public List<Student> all() {
        return new ArrayList<>(this.students);
    }
}
