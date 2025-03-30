package com.example.appdev_act1_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText input_elementary,
            input_secondary,
            input_vocational,
            input_vocational_course,
            input_college,
            input_college_course,
            input_graduate_studies,
            input_graduate_studies_course;
    private Button button_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        input_elementary = findViewById(R.id.input_elementary);
        input_secondary = findViewById(R.id.input_secondary);
        input_vocational = findViewById(R.id.input_vocational);
        input_vocational_course = findViewById(R.id.input_vocational_course);
        input_college = findViewById(R.id.input_college);
        input_college_course = findViewById(R.id.input_college_course);
        input_graduate_studies = findViewById(R.id.input_graduate_studies);
        input_graduate_studies_course = findViewById(R.id.input_graduate_studies_course);

        button_submit = findViewById(R.id.button_submit);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void validateFields() {
        String elementary = input_elementary.getText().toString().trim();
        String secondary = input_secondary.getText().toString().trim();
        String vocational = input_vocational.getText().toString().trim();
        String vocationalCourse = input_vocational_course.getText().toString().trim();
        String college = input_college.getText().toString().trim();
        String collegeCourse = input_college_course.getText().toString().trim();
        String graduateStudies = input_graduate_studies.getText().toString().trim();
        String graduateStudiesCourse = input_graduate_studies_course.getText().toString().trim();

        boolean hasError = false;
        if (!elementary.matches("^[a-zA-Z /-]+$")) {
            input_elementary.setError("Must contain only letters, spaces, and valid characters");
            hasError = true;
        }
        if (!secondary.matches("^[a-zA-Z /-]+$")) {
            input_secondary.setError("Must contain only letters, spaces, and valid characters");
            hasError = true;
        }
        if (!vocational.matches("^[a-zA-Z /-]+$")) {
            input_vocational.setError("Must contain only letters, spaces, and valid characters");
            hasError = true;
        }
        if (!vocationalCourse.matches("^[a-zA-Z /-]+$")) {
            input_vocational_course.setError("Must contain only letters, spaces, and valid characters");
            hasError = true;
        }
        if (!college.matches("^[a-zA-Z /-]+$")) {
            input_college.setError("Must contain only letters, spaces, and valid characters");
            hasError = true;
        }
        if (!collegeCourse.matches("^[a-zA-Z /-]+$")) {
            input_college_course.setError("Must contain only letters, spaces, and valid characters");
            hasError = true;
        }
        if (!graduateStudies.matches("^[a-zA-Z /-]+$")) {
            input_graduate_studies.setError("Must contain only letters, spaces, and valid characters");
            hasError = true;
        }
        if (!graduateStudiesCourse.matches("^[a-zA-Z /-]+$")) {
            input_graduate_studies_course.setError("Must contain only letters, spaces, and valid characters");
            hasError = true;
        }

        if (elementary.isEmpty() || secondary.isEmpty() || vocational.isEmpty() ||
                vocationalCourse.isEmpty() || college.isEmpty() || collegeCourse.isEmpty() ||
                graduateStudies.isEmpty() || graduateStudiesCourse.isEmpty()) {

            // If any field is empty, show a Toast message
            Toast.makeText(this, "Please fill in all required fields.", Toast.LENGTH_SHORT).show();
            hasError = true; // make this true after testing
        }

        if (hasError) {
            return;
        }

        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

        intent.putExtra("key_elementary", elementary);
        intent.putExtra("key_secondary", secondary);
        intent.putExtra("key_vocational", vocational);
        intent.putExtra("key_vocational_course", vocationalCourse);
        intent.putExtra("key_college", college);
        intent.putExtra("key_college_course", collegeCourse);
        intent.putExtra("key_graduate_studies", graduateStudies);
        intent.putExtra("key_graduate_studies_course", graduateStudiesCourse);

        Intent previousIntent = getIntent();

        intent.putExtra("key_first_name", previousIntent.getStringExtra("key_first_name"));
        intent.putExtra("key_middle_name", previousIntent.getStringExtra("key_middle_name"));
        intent.putExtra("key_last_name", previousIntent.getStringExtra("key_last_name"));
        intent.putExtra("key_email", previousIntent.getStringExtra("key_email"));
        intent.putExtra("key_phone", previousIntent.getStringExtra("key_phone"));
        intent.putExtra("key_height", previousIntent.getStringExtra("key_height"));
        intent.putExtra("key_weight", previousIntent.getStringExtra("key_weight"));
        intent.putExtra("key_pagibig", previousIntent.getStringExtra("key_pagibig"));
        intent.putExtra("key_tin", previousIntent.getStringExtra("key_tin"));
        intent.putExtra("key_philhealth", previousIntent.getStringExtra("key_philhealth"));
        intent.putExtra("key_gsis", previousIntent.getStringExtra("key_gsis"));
        intent.putExtra("key_full_name", previousIntent.getStringExtra("key_full_name"));
        intent.putExtra("key_emergency_contact_number", previousIntent.getStringExtra("key_emergency_contact_number"));
        intent.putExtra("key_relationship", previousIntent.getStringExtra("key_relationship"));

        startActivity(intent);
    }

}