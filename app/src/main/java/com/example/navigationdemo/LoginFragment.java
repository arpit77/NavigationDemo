package com.example.navigationdemo;

import android.content.Context;
import android.content.SharedPreferences;
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
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedPreferences;

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
        sharedPreferences = getContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        view.findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getText().toString().equals("1234") && mobile.getText().toString().equals("1234567890")){
//                    navController.navigate(R.id.homeFragment);
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("login", "Yes");
                    editor.commit();

                    if (getActivity() instanceof MainActivity){
                        getActivity().onBackPressed();
                        ((MainActivity) getActivity()).recreate();
                    }
                }

                else{
                    Toast.makeText(getActivity(), "Authentication failed!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}