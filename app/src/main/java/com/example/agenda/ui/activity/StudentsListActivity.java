package com.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.StudentDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StudentsListActivity extends AppCompatActivity {
    private static final String TITLE = "Lista de alunos";
    final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_list);
        setTitle(this.TITLE);
        fabInit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initList();
    }

    private void fabInit() {
        FloatingActionButton buttonNewStudent = findViewById(R.id.activity_students_list_fab_new_student);

        buttonNewStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openForm();
            }
        });
    }

    private void openForm() {
        startActivity(new Intent(StudentsListActivity.this, NewStudentFormActivity.class));
    }

    private void initList() {
        ListView studentsList = findViewById(R.id.activity_students_list_listview);
        studentsList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.dao.all()));
    }
}
