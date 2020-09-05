package com.example.travelopedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    private Button r;
    private EditText name,emm,pass,country;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    ProgressBar Pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setTitle("Registration");

        name= (EditText)findViewById(R.id.fullname);
        country=findViewById(R.id.from);
        emm=(EditText)findViewById(R.id.mail_button);
        pass=(EditText)findViewById(R.id.new_pass_button);
        r=(Button)findViewById(R.id.registration_button);
        Pb=(ProgressBar)findViewById(R.id.progressbar);
        r.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("user");
    }

    @Override
    public void onClick(View v){
        if(v.getId()==R.id.registration_button)
            //Toast.makeText(getApplicationContext(),"Here",Toast.LENGTH_SHORT).show();
            userRegister();
    }

    private void userRegister() {
        String a = name.getText().toString().trim();
        String b = country.getText().toString().trim();
        String c = emm.getText().toString().trim();
        String d = pass.getText().toString().trim();
        //user_profile n=new user_profile(a,b,c,d);

        if(c.length()==0){
            emm.setError("Enter an Email Address");
            emm.requestFocus();
            return;

        }
        if(!Patterns.EMAIL_ADDRESS.matcher(c).matches()){
            emm.setError("Enter a valid Email address");
            emm.requestFocus();
            return;

        }
        if(d.length()<6){
            pass.setError("Password must have at least 6 characters");
            pass.requestFocus();
            return;
        }

        Pb.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(c,d).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Pb.setVisibility(View.GONE);
                if (task.isSuccessful()) {

                    Toast.makeText(getApplicationContext(),"User Registered Successfully",Toast.LENGTH_SHORT).show();

                } else {
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"User Already Registered",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Cannot Register User",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}
