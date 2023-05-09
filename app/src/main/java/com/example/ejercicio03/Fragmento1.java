package com.example.ejercicio03;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmento1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmento1 extends Fragment {

    private TextView nameTextView;
    private TextView ageTextView;

    public Fragmento1() {
        // Required empty public constructor
    }

    public static Fragmento1 newInstance(String name, int age) {
        Fragmento1 fragment = new Fragmento1();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putInt("age", age);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento1, container, false);

        nameTextView = view.findViewById(R.id.nameTextView);
        ageTextView = view.findViewById(R.id.ageTextView);

        if (getArguments() != null) {
            String name = getArguments().getString("name");
            int age = getArguments().getInt("age");

            nameTextView.setText("Nombre: " + name);
            ageTextView.setText("Edad: " + age);
        }

        return view;
    }
}