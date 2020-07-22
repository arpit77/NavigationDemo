package com.example.navigationdemo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {

    private EditText mobile, password;
    NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mobile = view.findViewById(R.id.mobile);
        password = view.findViewById(R.id.password);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().equals("1234") && mobile.getText().toString().equals("7023875303")){
                    navController.navigate(R.id.homeFragment);
                }

                else{
                    Toast.makeText(getActivity(), "Authentication failed!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}