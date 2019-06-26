package com.battistradadeveloper.yasmotor;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView txtLogin, txtSignup;
    EditText edtEmail, edtPassword;
    CheckBox ShowPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtLogin = findViewById(R.id.txt_login);
        txtSignup = findViewById(R.id.txt_signup);

        ShowPass = findViewById(R.id.showPass);

        edtEmail = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);

        ShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ShowPass.isChecked()){
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else {
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey = edtEmail.getText().toString();
                String passwordKey = edtPassword.getText().toString();

                if (usernameKey.equals("admin@gmail.com") && passwordKey.equals("admin123")){
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(),"LOGIN SUKSES", Toast.LENGTH_LONG).show();
                    Intent login = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(login);
                    finish();
                }
                else{
                    //Jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Username atau Password Anda Salah!")
                            .setNegativeButton("Retry",null).create().show();
                }
            }
        });

        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("Untuk update terkait registrasi admin, silahkan email ke : agum@battistradadeveloper.com")
                        .setNegativeButton("Cheers!!!",null).create().show();
            }
        });
    }
}
