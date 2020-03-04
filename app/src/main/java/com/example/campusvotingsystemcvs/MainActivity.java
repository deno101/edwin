package com.example.campusvotingsystemcvs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText emailid;
    private EditText pass;
    private Button buttonLogin;
    private ProgressBar progressBar1;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailid = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.btnlogin);
        progressBar1 = findViewById(R.id.progressBar1);

        mAuth = FirebaseAuth.getInstance();







        mAuthStateListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mfirebaseuser = mAuth.getCurrentUser();
                if (mfirebaseuser != null) {

                    Toast.makeText(MainActivity.this, "Your are now Logged In.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, clickhere.class);

                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Please Login.", Toast.LENGTH_SHORT).show();
                }
            }
        };

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailid.getText().toString();
                String password = pass.getText().toString();


                if (email.isEmpty()) {

                    emailid.setError("Email is Required");
                    emailid.requestFocus();
                } else if (password.isEmpty()) {

                    pass.setError("Password is Required");
                    pass.requestFocus();
                } else if ((email.isEmpty() && password.isEmpty())) {

                    Toast.makeText(MainActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();
                } else if (email != null && password != null) {

                    progressBar1.setVisibility(View.VISIBLE);

                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login Error,Please Login Again", Toast.LENGTH_SHORT).show();
                                progressBar1.setVisibility(View.GONE);
                            } else {
                                Intent intoclick = new Intent(MainActivity.this, clickhere.class);
                                startActivity(intoclick);
                            }
                        }
                    });

                } else {
                    Toast.makeText(MainActivity.this, "Error Occurred", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }

    @Override
    protected void onStart() {
        super.onStart();
//        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar1.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAuth.signOut();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}



