package com.example.mpakoappversion02.ui.dashboard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mpakoappversion02.AgentActivity;
import com.example.mpakoappversion02.ClientActivity;
import com.example.mpakoappversion02.R;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private Button idbuttonLogin;
    private EditText idEmail;
    private EditText idPassword;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        String msg ="User name ou mot de passe incorrect";
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = view.findViewById(R.id.idEmail);
         idbuttonLogin = (Button) view.findViewById(R.id.idbuttonLogin);
         idEmail = (EditText) view.findViewById(R.id.idEmail);
         idPassword = (EditText)  view.findViewById(R.id.idPassword);

        idbuttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idEmail.getText().toString().equals("Julie") && idPassword.getText().toString().equals("kabeya")){
                    Intent in = new Intent(getActivity(), ClientActivity.class);
                    in.putExtra("EmailClient",idEmail.getText().toString());
                    in.putExtra("PasswordClient",idPassword.getText().toString());
                    startActivity(in);
                }
                else if (idEmail.getText().toString().equals("Cedrick") && idPassword.getText().toString().equals("okonda")){
                    Intent in = new Intent(getActivity(), AgentActivity.class);
                    in.putExtra("EmailAgent",idEmail.getText().toString());
                    in.putExtra("PasswordAgent",idPassword.getText().toString());
                    startActivity(in);
                }
                else{
                    //Toast.makeText(DashboardFragment.this,"User name ou mot de passe incorrect!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(),msg, Toast.LENGTH_SHORT).show();
                }
            }
        });


        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return view;

    }

}