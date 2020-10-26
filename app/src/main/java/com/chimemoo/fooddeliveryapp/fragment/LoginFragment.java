package com.chimemoo.fooddeliveryapp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chimemoo.fooddeliveryapp.LoginScreen;
import com.chimemoo.fooddeliveryapp.MainActivity;
import com.chimemoo.fooddeliveryapp.R;

public class LoginFragment extends Fragment implements View.OnClickListener {

    Button btnLogin;
    private View mView;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_login, container, false);

        btnLogin = (Button)mView.findViewById(R.id.bt_login);
        btnLogin.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_login){
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
    }
}
