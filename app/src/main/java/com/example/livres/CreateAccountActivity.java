package com.example.livres;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Consumer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.livres.Model.User;

public class CreateAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        TextView tvAlreadyUser = findViewById(R.id.tvAlreadyUser);
        tvAlreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateAccountActivity.this, SignInActivity.class));
            }
        });

        Button btCreate = findViewById(R.id.btCreate);
        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etPseudo = findViewById(R.id.etPseudo);
                EditText etEmail = findViewById(R.id.etMail);
                EditText etPw = findViewById(R.id.etPw);
                String pseudo = etPseudo.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPw.getText().toString();
                if (pseudo.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    new AlertDialog.Builder(CreateAccountActivity.this)
                            .setTitle("Error")
                            .setMessage(R.string.veuillez_remplir_les_champs_pour_continuer)
                            .show();
                    return;
                }
                User user = new User();
                user.setName(pseudo);
                user.setEmail(email);
                user.setPassword(password);

                VolleySingleton.getInstance(CreateAccountActivity.this).createAccount(user, new Consumer<User>() {
                    @Override
                    public void accept(User user) {
                        UserSingleton.getInstance().setUser(user);
                        Intent intent = new Intent(CreateAccountActivity.this, SignInActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
