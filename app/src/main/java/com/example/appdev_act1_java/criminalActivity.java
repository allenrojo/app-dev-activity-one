package com.example.appdev_act1_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class criminalActivity extends AppCompatActivity {
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
            details_two.setEnabled(!isChecked);
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
            details_three.setEnabled(!isChecked);
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
            details_four_a.setEnabled(!isChecked);
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
                details_four_b.setEnabled(!isChecked);
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
            details_four_c.setEnabled(!isChecked);
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
        boolean hasError = false;

        String answerOne = details.getText().toString().trim();
        String answerTwo = details_two.getText().toString().trim();
        String answerThree = details_three.getText().toString().trim();
        String answerFourA = details_four_a.getText().toString().trim();
        String answerFourB = details_four_b.getText().toString().trim();
        String answerFourC = details_four_c.getText().toString().trim();

        boolean questionOneNo = admin_offense_no.isChecked();
        boolean questionTwoNo = criminal_offense_no.isChecked();
        boolean questionThreeNo = convicted_no.isChecked();
        boolean questionFourANo = four_a_no.isChecked();
        boolean questionFourBNo = four_b_no.isChecked();
        boolean questionFourCNo = four_c_no.isChecked();

        if (answerOne.isEmpty() && !questionOneNo){
            hasError = true;
        }
        if (answerTwo.isEmpty() && !questionTwoNo){
            hasError = true;
        }
        if (answerThree.isEmpty() && !questionThreeNo){
            hasError = true;
        }
        if (answerFourA.isEmpty() && !questionFourANo){
            hasError = true;
        }
        if (answerFourB.isEmpty() && !questionFourBNo){
            hasError = true;
        }
        if (answerFourC.isEmpty() && !questionFourCNo){
            hasError = true;
        }

        //hasError = false; //remove after testing
        if (hasError) {
            Toast.makeText(this, "Please fill in all required fields.", Toast.LENGTH_SHORT).show();
            return;
        }
        Bundle bundle = getIntent().getBundleExtra("photoBundle");

        Intent intent = new Intent(this, displayActivity.class);

        intent.putExtra("photoBundle", bundle);

        intent.putExtra("key_answer_one", answerOne);
        intent.putExtra("key_answer_two", answerTwo);
        intent.putExtra("key_answer_three", answerThree);
        intent.putExtra("key_answer_four_a", answerFourA);
        intent.putExtra("key_answer_four_b", answerFourB);
        intent.putExtra("key_answer_four_c", answerFourC);

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
        intent.putExtra("key_elementary_course", previousIntent.getStringExtra("key_elementary_course"));
        intent.putExtra("key_secondary", previousIntent.getStringExtra("key_secondary"));
        intent.putExtra("key_secondary_course", previousIntent.getStringExtra("key_secondary_course"));
        intent.putExtra("key_vocational", previousIntent.getStringExtra("key_vocational"));
        intent.putExtra("key_vocational_course", previousIntent.getStringExtra("key_vocational_course"));
        intent.putExtra("key_college", previousIntent.getStringExtra("key_college"));
        intent.putExtra("key_college_course", previousIntent.getStringExtra("key_college_course"));
        intent.putExtra("key_graduate_studies", previousIntent.getStringExtra("key_graduate_studies"));
        intent.putExtra("key_graduate_studies_course", previousIntent.getStringExtra("key_graduate_studies_course"));

        startActivity(intent);

    }
}