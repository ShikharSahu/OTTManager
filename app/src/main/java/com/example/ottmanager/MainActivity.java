package com.example.ottmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout nameLogLy, emailLogLy, phoneNoLogLy, passwordLogLy;
    private MaterialButton loginButton;
    public static final String SP_KEY= "notesapp_Shared_preferences_access_key";
    public static final String SP_KEY_NAME= "notesapp_name";
    public static final String SP_KEY_EMAIL= "notesapp_email";
    public static final String SP_KEY_PHONE= "notesapp_phone";
    public static final String SP_KEY_PASSWORD= "notesapp_password";
    public static final String SP_KEY_IS_LOGGED_IN = "notesapp_login";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameLogLy = findViewById(R.id.nameLogLy);
        emailLogLy = findViewById(R.id.emailLogLy);
        phoneNoLogLy = findViewById(R.id.phoneLogLy);
        passwordLogLy = findViewById(R.id.passwordLogLy);
        loginButton = findViewById(R.id.LoginButton);

        preferences = getSharedPreferences(SP_KEY, Context.MODE_PRIVATE);
        editor = preferences.edit();
        if(preferences.getBoolean(SP_KEY_IS_LOGGED_IN,false)){
            User userAlreadyLoggedIn = getUserDetailsFromSP();

            Log.d("hehe","USer loged in\n" + userAlreadyLoggedIn);
            Toast.makeText(this, "already in", Toast.LENGTH_SHORT).show();
//            loginButton.setEnabled(false);
            startTheNextActivity(userAlreadyLoggedIn);
        }



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameLogLy.getEditText().getText().toString();
                String email = emailLogLy.getEditText().getText().toString();
                String phoneNo = phoneNoLogLy.getEditText().getText().toString();
                String password = passwordLogLy.getEditText().getText().toString();

                if(name.equals("") || email.equals("") || phoneNo.equals("") || password.equals("")){
                    Toast.makeText(MainActivity.this, "enter the details", Toast.LENGTH_SHORT).show();
                    return;
                }

                Log.d("hehe",name);
                Log.d("hehe",password);
                Toast.makeText(MainActivity.this, "LoggedIn", Toast.LENGTH_SHORT).show();

                editor.clear();
                editor.commit();
                editor.putString(SP_KEY_NAME, name);
                editor.putString(SP_KEY_EMAIL, email);
                editor.putString(SP_KEY_PHONE, password);
                editor.putString(SP_KEY_PASSWORD, password);
                editor.putBoolean(SP_KEY_IS_LOGGED_IN, true);;
                editor.commit();

                User userSignedUp = getUserDetailsFromSP();

                startTheNextActivity(userSignedUp);
            }
        });

//        Button bbb = findViewById(R.id.logout);
//        bbb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "logout!!", Toast.LENGTH_SHORT).show();
//                loginButton.setEnabled(true);
//                logOutUser();
//            }
//        });
    }

    private void startTheNextActivity(User userLoggedIn) {
        // TODO implement this
    }

    private User getUserDetailsFromSP(){
        String name = preferences.getString(SP_KEY_NAME,"");
        String email =  preferences.getString(SP_KEY_EMAIL,"");
        String phoneNo =  preferences.getString(SP_KEY_PHONE,"");
        String password =  preferences.getString(SP_KEY_PASSWORD,"");
        return new User(name, email, phoneNo, password);
    }

    public void logOutUser(){
        editor.clear();
        editor.putBoolean(SP_KEY_IS_LOGGED_IN,false);
        editor.commit();
    }
}