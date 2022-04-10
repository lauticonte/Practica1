package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText eRegName;
    private EditText eRegPassword;
    private EditText eRegPasswordRepeat;
    private EditText eRegEmail;
    private Button eRegister;

    public static Credentials credentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        eRegName = findViewById(R.id.etRegName);
        eRegPassword = findViewById(R.id.etRegPassword);
        eRegPasswordRepeat = findViewById(R.id.etRegPassword2);
        eRegEmail = findViewById(R.id.etRegEmail);
        eRegister = findViewById(R.id.btnReg);

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String regUsername = eRegName.getText().toString();
                String regPassword = eRegPassword.getText().toString();
                String regPasswordRep = eRegPasswordRepeat.getText().toString();
                String regEmail = eRegEmail.getText().toString();

                //Juan Torres hardcodeado para hacer mas rapido
                //String regUsername = "Juan Torres";
                //String regPassword = "1234utn";
                //String regPasswordRep = "1234utn";
                //String regEmail = "juan@gmail.com";

                if(validate(regUsername, regPassword, regPasswordRep, regEmail)){
                    credentials = new Credentials(regUsername, regPassword);
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(RegistrationActivity.this, "Registro completo", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean validate (String username, String password, String passwordRep, String email){
        if(username.isEmpty() || password.isEmpty() || passwordRep.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "Hay campos vacios", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            if (password.length()<6) {
            Toast.makeText(this, "La contraseña debe tener mas de 6 caracteres", Toast.LENGTH_SHORT).show();
            return false;
            } else {

                    if(password.equals(passwordRep)){
                    return true;
                } else {
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
        }
    }
}