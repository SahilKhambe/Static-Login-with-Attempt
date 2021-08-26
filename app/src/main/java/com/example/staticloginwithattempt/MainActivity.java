package com.example.staticloginwithattempt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button btnlogin;
    TextView textView1;
    int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.text_name);
        editText2 = findViewById(R.id.text_pass);
        btnlogin = findViewById(R.id.btn_login);
        textView1 = findViewById(R.id.text_View);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String USERNAME = editText1.getText().toString();
                String PASSWORD = editText2.getText().toString();

                if(USERNAME.equals("admin") && PASSWORD.equals("1234")){
                    Intent intent = new Intent(MainActivity.this, UserActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Please Enter Correct Username Or Password", Toast.LENGTH_SHORT).show();
                    count--;
                    textView1.setText(Integer.toString(count));

                    if(count==0){
                        btnlogin.setVisibility(View.GONE);
                    }
                }

            }
        });
    }
}