package com.example.appdev_act1_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class educationActivity extends AppCompatActivity {

    private EditText input_elementary,input_elementary_course, input_secondary, input_secondary_course, input_vocational, input_vocational_course, input_college, input_college_course, input_graduate_studies, input_graduate_studies_course;
    private Button button_submit;
    private CheckBox checkBox, checkBox1, checkBox2, checkBox3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.education_activity);

        input_elementary = findViewById(R.id.input_elementary);
        input_elementary_course = findViewById(R.id.input_elementary_course);
        input_secondary = findViewById(R.id.input_secondary);
        input_secondary_course = findViewById(R.id.input_secondary_course);
        input_vocational = findViewById(R.id.input_vocational);
        input_vocational_course = findViewById(R.id.input_vocational_course);
        input_college = findViewById(R.id.input_college);
        input_college_course = findViewById(R.id.input_college_course);
        input_graduate_studies = findViewById(R.id.input_graduate_studies);
        input_graduate_studies_course = findViewById(R.id.input_graduate_studies_course);


        checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Disable EditText if CheckBox is checked, enable otherwise
            input_elementary.setEnabled(isChecked);
            input_elementary_course.setEnabled(isChecked);
        });
        checkBox1 = findViewById(R.id.checkBox2);
        checkBox1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Disable EditText if CheckBox is checked, enable otherwise
            input_secondary.setEnabled(isChecked);
            input_secondary_course.setEnabled(isChecked);
            checkBox.setChecked(true);
        });
        checkBox2 = findViewById(R.id.checkBox3);
        checkBox2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Disable EditText if CheckBox is checked, enable otherwise
            input_college.setEnabled(isChecked);
            input_college_course.setEnabled(isChecked);
            checkBox.setChecked(true);
            checkBox1.setChecked(true);
        });
        checkBox3 = findViewById(R.id.checkBox4);
        checkBox3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Disable EditText if CheckBox is checked, enable otherwise
            input_graduate_studies.setEnabled(isChecked);
            input_graduate_studies_course.setEnabled(isChecked);
            checkBox.setChecked(true);
            checkBox1.setChecked(true);
            checkBox2.setChecked(true);

        });

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
        String elementaryCourse = input_elementary_course.getText().toString().trim();
        String secondary = input_secondary.getText().toString().trim();
        String secondaryCourse = input_secondary_course.getText().toString().trim();
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
            hasError = false; // make this true after testing
        }

        if (hasError) {
            return;
        }

        Intent intent = new Intent(educationActivity.this, criminalActivity.class);

        intent.putExtra("key_elementary", elementary);
        intent.putExtra("key_elementary_course", elementaryCourse);
        intent.putExtra("key_secondary", secondary);
        intent.putExtra("key_secondary", secondaryCourse);
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
        intent.putExtra("key_gender", previousIntent.getStringExtra("key_gender"));
        intent.putExtra("key_status", previousIntent.getStringExtra("key_status"));
        startActivity(intent);
    }

}