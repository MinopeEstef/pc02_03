package com.example.ejercicio03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText name,birth;
    Button btnCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalculator = findViewById(R.id.btnCalculator);
        btnCalculator.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        name = findViewById(R.id.name);
        birth = findViewById(R.id.birth);

        String user = name.getText().toString();
        int age = getAge(birth.getText().toString());

        Bundle bundle = new Bundle();
        bundle.putString("name", user);
        bundle.putInt("age", age);

        Fragment fragmento = new Fragmento1();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, fragmento)
                .commit();
    }

    public static int getAge(String fechaNacimiento) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaNac = sdf.parse(fechaNacimiento);
            Calendar fechaNacCalendar = Calendar.getInstance();
            fechaNacCalendar.setTime(fechaNac);

            Calendar fechaActualCalendar = Calendar.getInstance();

            int edad = fechaActualCalendar.get(Calendar.YEAR) - fechaNacCalendar.get(Calendar.YEAR);
            if (fechaActualCalendar.get(Calendar.MONTH) < fechaNacCalendar.get(Calendar.MONTH) ||
                    (fechaActualCalendar.get(Calendar.MONTH) == fechaNacCalendar.get(Calendar.MONTH) &&
                            fechaActualCalendar.get(Calendar.DAY_OF_MONTH) < fechaNacCalendar.get(Calendar.DAY_OF_MONTH))) {
                edad--;
            }

            return edad;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }


}