package com.example.appdev_act1_java;

import android.content.Intent;
import android.graphics.Bitmap;

import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.regex.Pattern;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Spinner;
import java.util.List;
import java.util.ArrayList;
public class personalActivity extends AppCompatActivity {
    private EditText input_first_name, input_middle_name, input_last_name, input_email, input_phone, input_height, input_weight,
            input_pagibig, input_tin, input_philhealth, input_gsis,
            input_full_name, input_emergency_contact_number, input_relationship;
    private RadioGroup radio_group_gender, radio_group_civil_status;
    private RadioButton radio_male, radio_female, radio_lgbtq,
            radio_single, radio_married, radio_separated, radio_widowed, radio_others;
    private ImageView imageView;
    private String selectedSpinnerItem = "";
    Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.personal_activity);

        input_first_name = findViewById(R.id.input_first_name);
        input_middle_name = findViewById(R.id.input_middle_name);
        input_last_name = findViewById(R.id.input_last_name);
        input_email = findViewById(R.id.input_email);
        input_phone = findViewById(R.id.input_phone);
        input_height = findViewById(R.id.input_height);
        input_weight = findViewById(R.id.input_weight);

        radio_group_gender = findViewById(R.id.radio_group_gender);
        radio_male = findViewById(R.id.radio_male);
        radio_female = findViewById(R.id.radio_female);
        radio_lgbtq = findViewById(R.id.radio_lgbtq);

        radio_group_civil_status = findViewById(R.id.radio_group_civil_status);
        radio_single = findViewById(R.id.radio_single);
        radio_married = findViewById(R.id.radio_married);
        radio_separated = findViewById(R.id.radio_separated);
        radio_widowed = findViewById(R.id.radio_widowed);
        radio_others = findViewById(R.id.radio_others);

        input_pagibig =findViewById(R.id.input_pagibig);
        input_philhealth = findViewById(R.id.input_philhealth);
        input_tin = findViewById(R.id.input_tin);
        input_gsis = findViewById(R.id.input_gsis);

        input_full_name = findViewById(R.id.input_full_name);
        input_emergency_contact_number = findViewById(R.id.input_emergency_contact_number);

        Spinner spinner_relationship = findViewById(R.id.spinner_relationship);
        List<String> spinnerItems = new ArrayList<>();
        spinnerItems.add("Select relationship: ");
        spinnerItems.add("Father");
        spinnerItems.add("Mother");
        spinnerItems.add("Sister");
        spinnerItems.add("Brother");
        spinnerItems.add("Husband");
        spinnerItems.add("Wife");
        spinnerItems.add("Other");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                spinnerItems
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_relationship.setAdapter(adapter);
        spinner_relationship.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedSpinnerItem = (String) parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedSpinnerItem = null;
            }
        });
        imageView = findViewById(R.id.imageView);
        Button button_photo = findViewById(R.id.button_photo);
        button_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });
        Button button_submit = findViewById(R.id.button_submit);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();
            }
        });
    }
    public void openCamera(){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 69);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 69 && data != null){
            photo = (Bitmap)data.getExtras().get("data");
            ImageView image = findViewById(R.id.imageView);
            image.setImageBitmap(photo);
        }
    }
    private void validateFields() {
        String relationship = selectedSpinnerItem;
        Bundle bundle = new Bundle();

        // Get the text from all EditText fields, trimming whitespace
        String firstName = input_first_name.getText().toString().trim();
        String middleName = input_middle_name.getText().toString().trim();
        String lastName = input_last_name.getText().toString().trim();
        String email = input_email.getText().toString().trim();
        String phone = input_phone.getText().toString().trim();
        String height = input_height.getText().toString().trim();
        String weight = input_weight.getText().toString().trim();

        int selectedGender =  radio_group_gender.getCheckedRadioButtonId();
        String gender = "";
            if (selectedGender != -1) {
                RadioButton selectedRadioButton = findViewById(selectedGender);
                gender = selectedRadioButton.getText().toString();
            }
        int selectedStatus = radio_group_civil_status.getCheckedRadioButtonId();
        String status = "";
            if (selectedStatus != -1) {
                RadioButton selectedRadioButton = findViewById(selectedStatus);
                status = selectedRadioButton.getText().toString();
            }
        String pagibig = input_pagibig.getText().toString().trim();
        String tin = input_tin.getText().toString().trim();
        String philhealth = input_philhealth.getText().toString().trim();
        String gsis = input_gsis.getText().toString().trim();

        String fullName = input_full_name.getText().toString().trim();
        String emergencyContactNumber = input_emergency_contact_number.getText().toString().trim();

        boolean hasError = false;
        if (!firstName.matches("^[a-zA-Z ]+$")) {
            input_first_name.setError("Name must contain only letters and spaces");
            hasError = true;
        }
        if (!middleName.matches("^[a-zA-Z ]+$")) {
            input_middle_name.setError("Name must contain only letters and spaces");
            hasError = true;
        }
        if (!lastName.matches("^[a-zA-Z ]+$")) {
            input_last_name.setError("Name must contain only letters and spaces");
            hasError = true;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            input_email.setError("Invalid email address");
            hasError = true;
        }
        if (!Pattern.matches("\\d{11}", phone)) {
            input_phone.setError("Phone number must be 11 digits");
            hasError = true;
        }
        if (height.isEmpty()) {
            input_height.setError("Enter your height in meters");
            hasError = true;
        }
        if (weight.isEmpty()) {
            input_weight.setError("Enter your weight in kilograms");
            hasError = true;
        }
        if (!fullName.matches("^[a-zA-Z ]+$")) {
            input_full_name.setError("Name must contain only letters and spaces");
            hasError = true;
        }
        if (!Pattern.matches("\\d{11}", emergencyContactNumber)) {
            input_emergency_contact_number.setError("Emergency contact number must be 11 digits");
            hasError = true;
        }
        if (selectedSpinnerItem.equals("Select relationship: ")) {
            Toast.makeText(personalActivity.this, "Choose a relationship.", Toast.LENGTH_SHORT).show();
        }
        if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() ||
                email.isEmpty() || phone.isEmpty() || height.isEmpty() ||
                weight.isEmpty() || fullName.isEmpty() || emergencyContactNumber.isEmpty() || relationship.equals("Select relationship: ")
                 || gender.isEmpty() || status.isEmpty()) {

            Toast.makeText(this, "Please fill in all required fields.", Toast.LENGTH_SHORT).show();
            hasError = true; //make this true after testing
        }

        if (photo != null){
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG,100,stream);
            byte[]photoByteArray = stream.toByteArray();
            bundle.putByteArray("photo", photoByteArray);
        }else {
            Toast.makeText(this, "Take a photo first", Toast.LENGTH_SHORT).show();
            hasError = true;
        }

        //hasError = false; //remove after testing

        if (hasError) {
            return;
        }
        // All fields are filled in and valid, do something here (e.g., submit the form)
        Toast.makeText(this, "Processing...", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, educationActivity.class);

        intent.putExtra("photoBundle", bundle);

        intent.putExtra("key_first_name", firstName);
        intent.putExtra("key_middle_name", middleName);
        intent.putExtra("key_last_name", lastName);
        intent.putExtra("key_email", email);
        intent.putExtra("key_gender", gender);
        intent.putExtra("key_phone", phone);
        intent.putExtra("key_height", height);
        intent.putExtra("key_weight", weight);
        intent.putExtra("key_status", status);
        intent.putExtra("key_pagibig", pagibig);
        intent.putExtra("key_tin", tin);
        intent.putExtra("key_philhealth", philhealth);
        intent.putExtra("key_gsis", gsis);
        intent.putExtra("key_full_name", fullName);
        intent.putExtra("key_emergency_contact_number", emergencyContactNumber);
        intent.putExtra("key_relationship", relationship );

        startActivity(intent);
    }
}