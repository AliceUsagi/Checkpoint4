package activity;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.livres.R;

public class signInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button btCreate = findViewById(R.id.btSendSignIn);
        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etEmailSignIn = findViewById(R.id.etMailSignIn);
                EditText etPwSignIn = findViewById(R.id.etPwSignIn);
                String email = etEmailSignIn.getText().toString();
                String password = etPwSignIn.getText().toString();
                if (email.isEmpty() || password.isEmpty()) {
                    new AlertDialog.Builder(signInActivity.this)
                            .setTitle("Error")
                            .setMessage(R.string.veuillez_remplir_les_champs_pour_continuer)
                            .show();
                    return;
                }
                //startActivity(new Intent(signInActivity.this, signInActivity.class));
            }
        });
    }
}
