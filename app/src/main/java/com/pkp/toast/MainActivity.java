package com.pkp.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.shashank.sony.fancytoastlib.FancyToast;


public class MainActivity extends AppCompatActivity {
    //import necessary class
    Button btnSave,btnGetData;
    EditText txtName,txtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references
        btnSave = findViewById(R.id.btnSaveData);
        btnGetData = findViewById(R.id.btnGetData);

        txtName = findViewById(R.id.name);
        txtAge = findViewById(R.id.age);

        //save button action
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                int age = 0;
                try {Thread.sleep(1000);}catch (Exception e){}
                try {
                    age = Integer.parseInt(txtAge.getText().toString());
                }catch (NumberFormatException n){
                    FancyToast.makeText(getApplicationContext(),"age allow only number",FancyToast.LENGTH_LONG,FancyToast.WARNING,true).show();
                    return;
                }

                if (name.isEmpty() | age < 0 | age > 80){
                    FancyToast.makeText(getApplicationContext(),"check your Data",FancyToast.LENGTH_LONG,FancyToast.WARNING,true).show();
                    return;
                }

                SharedPreferences prf = getSharedPreferences("details", MODE_PRIVATE);
                SharedPreferences.Editor editor = prf.edit();
                editor.putString("name", name);
                editor.putInt("age", age);
                boolean commit = editor.commit();
                if (commit){
                    FancyToast.makeText(getApplicationContext(),"data saved success..",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                }else {
                    FancyToast.makeText(getApplicationContext(),"data saved fail",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }
            }
        });

        //load data button action
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prf = getSharedPreferences("details", MODE_PRIVATE);
                String name = prf.getString("name", "no name");
                int age = prf.getInt("age", 0);

                FancyToast.makeText(getApplicationContext(),"Your name : "+name+"\nYour age : "+age,FancyToast.LENGTH_LONG,FancyToast.INFO,true).show();
            }
        });
    }

}