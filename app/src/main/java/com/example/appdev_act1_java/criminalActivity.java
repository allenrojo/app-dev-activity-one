package com.example.appdev_act1_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class criminalActivity extends AppCompatActivity {
    private TextView label_question_one,label_question_two,label_question_three,label_question_four, label_question_four_a, label_question_four_b, label_question_four_c;
    private CheckBox admin_offense_yes, admin_offense_no, criminal_offense_yes, criminal_offense_no, convicted_yes, convicted_no, four_a_yes, four_a_no, four_b_yes, four_b_no, four_c_yes, four_c_no;
    private Button button_submit;
    private EditText details, details_two, details_three, details_four_a, details_four_b, details_four_c;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.criminal_activity);

        details = findViewById(R.id.details);
        details_two = findViewById(R.id.details_two);
        details_three = findViewById(R.id.details_three);
        details_four_a = findViewById(R.id.details_four_a);
        details_four_b = findViewById(R.id.details_four_b);
        details_four_c = findViewById(R.id.details_four_c);

        admin_offense_yes = findViewById(R.id.admin_offense_yes);

        admin_offense_yes.setOnCheckedChangeListener((buttonView, isChecked) -> {
            details.setEnabled(isChecked);
            admin_offense_no.setChecked(false);
        });
        admin_offense_no = findViewById(R.id.admin_offense_no);
        admin_offense_no = findViewById(R.id.admin_offense_no);
        admin_offense_no.setOnCheckedChangeListener((buttonView, isChecked) -> {
            details.setEnabled(!isChecked);
            details.setText("");
            admin_offense_yes.setChecked(false);

        });

        criminal_offense_yes = findViewById(R.id.criminal_offense_yes);
        criminal_offense_yes.setOnCheckedChangeListener((buttonView, isChecked) -> {
            details_two.setEnabled(isChecked);
            criminal_offense_no.setChecked(false);
        });
        criminal_offense_no = findViewById(R.id.criminal_offense_no);
        criminal_offense_no.setOnCheckedChangeListener((buttonView, isChecked) -> {
            details_two.setEnabled(isChecked);
            details_two.setText("");
            criminal_offense_yes.setChecked(false);
        });

        convicted_yes = findViewById(R.id.convicted_yes);
        convicted_yes.setOnCheckedChangeListener((buttonView, isChecked) -> {
            details_three.setEnabled(isChecked);
            convicted_no.setChecked(false);
        });
        convicted_no = findViewById(R.id.convicted_no);
        convicted_no.setOnCheckedChangeListener((buttonView, isChecked) -> {
            details_three.setEnabled(isChecked);
            details_three.setText("");
            convicted_yes.setChecked(false);
        });

        four_a_yes = findViewById(R.id.four_a_yes);
        four_a_yes.setOnCheckedChangeListener((buttonView, isChecked) -> {
            details_four_a.setEnabled(isChecked);
            four_a_no.setChecked(false);
        });
        four_a_no = findViewById(R.id.four_a_no);
        four_a_no.setOnCheckedChangeListener((buttonView, isChecked) -> {
            details_four_a.setEnabled(isChecked);
            details_four_a.setText("");
            four_a_yes.setChecked(false);
        });

        four_b_yes = findViewById(R.id.four_b_yes);
        four_b_yes.setOnCheckedChangeListener((buttonView, isChecked) -> {
            details_four_b.setEnabled(isChecked);
            four_b_no.setChecked(false);
        });
        four_b_no = findViewById(R.id.four_b_no);
        four_b_no.setOnCheckedChangeListener((buttonView, isChecked) -> {
                details_four_b.setEnabled(isChecked);
                details_four_b.setText("");
                four_b_yes.setChecked(false);
        });

        four_c_yes = findViewById(R.id.four_c_yes);
        four_c_yes.setOnCheckedChangeListener((buttonView, isChecked) -> {
            details_four_c.setEnabled(isChecked);
            four_c_no.setChecked(false);
        });
        four_c_no = findViewById(R.id.four_c_no);
        four_c_no.setOnCheckedChangeListener((buttonView, isChecked) -> {
            details_four_c.setEnabled(isChecked);
            details_four_c.setText("");
            four_c_yes.setChecked(false);
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

        Intent intent = new Intent(this, displayActivity.class);


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

        intent.putExtra("key_elementary", previousIntent.getStringExtra("key_elementary"));
        intent.putExtra("key_secondary", previousIntent.getStringExtra("key_secondary"));
        intent.putExtra("key_vocational", previousIntent.getStringExtra("key_vocational"));
        intent.putExtra("key_vocational_course", previousIntent.getStringExtra("key_vocationalCourse"));
        intent.putExtra("key_college", previousIntent.getStringExtra("key_college"));
        intent.putExtra("key_college_course", previousIntent.getStringExtra("key_collegeCourse"));
        intent.putExtra("key_graduate_studies", previousIntent.getStringExtra("key_graduateStudies"));
        intent.putExtra("key_graduate_studies_course", previousIntent.getStringExtra("key_graduateStudiesCourse"));
        startActivity(intent);

    }
}