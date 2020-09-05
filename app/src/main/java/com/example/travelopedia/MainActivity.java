package com.example.travelopedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView user_name,pass_word;
    private Button login,reg;
    private FirebaseAuth mAuth;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name = (EditText) findViewById(R.id.mail);
        pass_word = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login_button);
        reg = (Button) findViewById(R.id.register);
        pb=(ProgressBar)findViewById(R.id.progressbar) ;
        login.setOnClickListener(this);
        reg.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        pass_word.setTransformationMethod(new AsteriskPasswordTransformationMethod());
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.login_button) {
            //loginUser();
            Intent intent = new Intent(MainActivity.this,welcomepage.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.register){
            Intent intent=new Intent(MainActivity.this,Registration.class);
            startActivity(intent);
        }

    }

    private void loginUser() {

        String a=user_name.getText().toString().trim();
        String b=pass_word.getText().toString().trim();
        if(a.length()==0){
            user_name.setError("Enter an Email Address");
            user_name.requestFocus();
            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(a).matches()){
            user_name.setError("Enter a valid Email address");
            user_name.requestFocus();
            return;

        }
        if(b.length()<6){
            pass_word.setError("Password must have at least 6 characters");
            pass_word.requestFocus();
            return;
        }
        pb.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(a,b).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                pb.setVisibility(View.GONE);
                if (task.isSuccessful()) {

                    Intent intt = new Intent(MainActivity.this, Destinations.class);
                    intt.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intt);
                    Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}


