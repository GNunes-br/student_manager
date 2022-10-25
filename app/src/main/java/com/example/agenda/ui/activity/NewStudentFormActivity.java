package com.example.agenda.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.agenda.R;
import com.example.agenda.dao.StudentDAO;
import com.example.agenda.model.Student;

public class NewStudentFormActivity extends AppCompatActivity {
    private static final String TITLE = "Novo aluno";
    private EditText nameInput;
    private EditText phoneInput;
    private EditText emailInput;
    final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student_form);
        setTitle(this.TITLE);
        editTextInit();
        buttonInit();
    }

    private void buttonInit() {
        View registerButton = findViewById(R.id.activity_new_students_form_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student newStudent = createStudent();
                saveStudent(newStudent);
            }
        });
    }

    private void editTextInit() {
        this.nameInput = findViewById(R.id.activity_new_students_form_name);
        this.phoneInput = findViewById(R.id.activity_new_students_form_phone);
        this.emailInput = findViewById(R.id.activity_new_students_form_email);
    }

    private void saveStudent(Student student) {
        this.dao.save(student);
        finish();
    }

    @NonNull
    private Student createStudent() {
        String name = this.nameInput.getText().toString();
        String phone = this.phoneInput.getText().toString();
        String email = this.emailInput.getText().toString();
        Student newStudent = new Student(name, phone, email);
        return newStudent;
    }
}