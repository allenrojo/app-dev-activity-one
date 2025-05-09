package com.example.appdev_act1_java;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class displayActivity extends AppCompatActivity {
    private TextView field_name, field_email, field_gender, field_phone, field_height, field_weight, field_status, field_pagibig, field_tin, field_philhealth, field_gsis,
            field_emergency_contact_name, field_emergency_contact_number, field_relationship,
            field_elementary, field_elementary_course, field_secondary, field_secondary_course, field_vocational, field_vocational_course, field_college, field_college_course, field_graduate_studies, field_graduate_studies_course,
            field_admin, field_criminal, field_convicted, field_indigenous, field_pwd, field_single ;

    private Button button_create_new;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.display_activity);

        Bundle bundle = getIntent().getBundleExtra("photoBundle");
        byte[] photoByteArray = bundle.getByteArray("photo");
        Bitmap photo = BitmapFactory.decodeByteArray(photoByteArray, 0, photoByteArray.length);
        ImageView imageView = findViewById(R.id.imageView2);
        imageView.setImageBitmap(photo);

        field_name = findViewById(R.id.field_name);
        field_email = findViewById(R.id.field_email);

        field_gender = findViewById(R.id.field_gender);

        field_phone = findViewById(R.id.field_phone);
        field_height = findViewById(R.id.field_height);
        field_weight = findViewById(R.id.field_weight);

        field_status = findViewById(R.id.field_status);

        field_pagibig = findViewById(R.id.field_pagibig);
        field_tin = findViewById(R.id.field_tin);
        field_philhealth = findViewById(R.id.field_philhealth);
        field_gsis = findViewById(R.id.field_gsis);

        field_emergency_contact_name = findViewById(R.id.field_emergency_contact_name);
        field_emergency_contact_number = findViewById(R.id.field_emergency_contact_number);
        field_relationship = findViewById(R.id.field_relationship);

        field_elementary = findViewById(R.id.field_elementary);
        field_elementary_course = findViewById(R.id.field_elementary_course);
        field_secondary = findViewById(R.id.field_secondary);
        field_secondary_course = findViewById(R.id.field_secondary_course);
        field_vocational = findViewById(R.id.field_vocational);
        field_vocational_course = findViewById(R.id.field_vocational_course);
        field_college = findViewById(R.id.field_college);
        field_college_course= findViewById(R.id.field_college_course);
        field_graduate_studies = findViewById(R.id.field_graduate_studies);
        field_graduate_studies_course = findViewById(R.id.field_graduate_studies_course);

        field_admin = findViewById(R.id.field_admin);
        field_criminal = findViewById(R.id.field_criminal);
        field_convicted = findViewById(R.id.field_convicted);
        field_indigenous = findViewById(R.id.field_indigenous);
        field_pwd = findViewById(R.id.field_pwd);
        field_single = findViewById(R.id.field_single);

        Intent intent = getIntent();
        
        String firstName = intent.getStringExtra("key_first_name");
        String middleName = intent.getStringExtra("key_middle_name");
        String lastName = intent.getStringExtra("key_last_name");
        String email = intent.getStringExtra("key_email");
        String gender = intent.getStringExtra("key_gender");

        String phone = intent.getStringExtra("key_phone");
        String height = intent.getStringExtra("key_height");
        String weight = intent.getStringExtra("key_weight");
        String status = intent.getStringExtra("key_status");

        String pagibig = intent.getStringExtra("key_pagibig");
        String tin = intent.getStringExtra("key_tin");
        String philhealth = intent.getStringExtra("key_philhealth");
        String gsis = intent.getStringExtra("key_gsis");
        String fullName = intent.getStringExtra("key_full_name");
        String emergencyContactNumber = intent.getStringExtra("key_emergency_contact_number");
        String relationship = intent.getStringExtra("key_relationship");

        String elementary = intent.getStringExtra("key_elementary");
        String elementaryCourse = intent.getStringExtra("key_elementary_course");
        String secondary = intent.getStringExtra("key_secondary");
        String secondaryCourse = intent.getStringExtra("key_secondary_course");
        String vocational = intent.getStringExtra("key_vocational");
        String vocationalCourse = intent.getStringExtra("key_vocational_course");
        String college = intent.getStringExtra("key_college");
        String collegeCourse = intent.getStringExtra("key_college_course");
        String graduateStudies = intent.getStringExtra("key_graduate_studies");
        String graduateStudiesCourse = intent.getStringExtra("key_graduate_studies_course");

        String answerOne = intent.getStringExtra("key_answer_one");
        String answerTwo = intent.getStringExtra("key_answer_two");
        String answerThree = intent.getStringExtra("key_answer_three");
        String answerFourA = intent.getStringExtra("key_answer_four_a");
        String answerFourB = intent.getStringExtra("key_answer_four_b");
        String answerFourC = intent.getStringExtra("key_answer_four_c");


        field_name.setText(firstName +" "+ middleName +" "+ lastName);
        field_email.setText(email);
        field_gender.setText(gender);
        field_phone.setText(phone);
        field_height.setText(height);
        field_weight.setText(weight);
        field_status.setText(status);
        field_pagibig.setText(pagibig);
        field_tin.setText(tin);
        field_philhealth.setText(philhealth);
        field_gsis.setText(gsis);
        field_emergency_contact_name.setText(fullName);
        field_emergency_contact_number.setText(emergencyContactNumber);
        field_relationship.setText(relationship);

        field_elementary.setText(elementary);
        field_elementary_course.setText(elementaryCourse);
        if (elementary.isBlank()) {
            field_elementary.setText("N/A");
            field_elementary_course.setText("N/A");

        }
        field_secondary.setText(secondary);
        field_secondary_course.setText(secondaryCourse);
        if (secondary.isBlank()) {
            field_secondary.setText("N/A");
            field_secondary_course.setText("N/A");

        }
        field_vocational.setText(vocational);
        field_vocational_course.setText(vocationalCourse);
        if (vocational.isBlank()) {
            field_vocational.setText("N/A");
            field_vocational_course.setText("N/A");

        }
        field_college.setText(college);
        field_college_course.setText(collegeCourse);
        if (college.isBlank()) {
            field_college.setText("N/A");
            field_college_course.setText("N/A");

        }
        field_graduate_studies.setText(graduateStudies);
        field_graduate_studies_course.setText(graduateStudiesCourse);
        if (graduateStudies.isBlank()) {
            field_graduate_studies.setText("N/A");
            field_graduate_studies_course.setText("N/A");

        }

        if (!answerOne.isBlank()) field_admin.setText(answerOne);
            else field_admin.setText("None");

        if (!answerTwo.isBlank()) field_criminal.setText(answerTwo);
            else field_criminal.setText("None");

        if (!answerThree.isBlank()) field_convicted.setText(answerThree);
            else field_convicted.setText("None");

        if (!answerFourA.isBlank()) field_indigenous.setText(answerFourA);
            else field_indigenous.setText("None");

        if (!answerFourB.isBlank()) field_pwd.setText(answerFourB);
            else field_pwd.setText("None");

        if (!answerFourC.isBlank()) field_single.setText(answerFourC);
            else field_single.setText("None");

        button_create_new = findViewById(R.id.button_create_new);
        button_create_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(displayActivity.this, personalActivity.class);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}