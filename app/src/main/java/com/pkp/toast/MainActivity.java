package com.pkp.toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;

import com.shashank.sony.fancytoastlib.FancyToast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        switch (view.getId()){
            case R.id.button_success:
                FancyToast.makeText(this,"This is button_success",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                break;
            case R.id.button_error:
                FancyToast.makeText(this,"This is button_error",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                break;
            case R.id.button_info:
                FancyToast.makeText(this,"This is button_info",FancyToast.LENGTH_LONG,FancyToast.INFO,true).show();
                break;
            case R.id.button_warning:
                FancyToast.makeText(this,"This is button_warning",FancyToast.LENGTH_LONG,FancyToast.WARNING,true).show();
                break;
            case R.id.button_normal:FancyToast.makeText(this, "Toast with no android icon",
                    FancyToast.LENGTH_LONG, FancyToast.ERROR, R.drawable.ic_android_black_24dp, false).show();
        }
    }
}