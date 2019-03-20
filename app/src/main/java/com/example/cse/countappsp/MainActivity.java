package com.example.cse.countappsp;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button bl,b2,b3,b4;
    int c=0;
    private int colorCode;
    SharedPreferences sp;
    private String spFilename="com.example.cse.countappsp";
    private String countKey="countKey";
    private String colorKey="colorKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.txt);
        bl=findViewById(R.id.black);
        b2=findViewById(R.id.red);
        b3=findViewById(R.id.blue);
        b4=findViewById(R.id.green);

        sp=getSharedPreferences(spFilename,MODE_PRIVATE);
        /*if(sp!=null){
            c=sp.getInt(countKey,c);
            if(c!=0){
                textView.setText(String.valueOf(c));
            }
            colorCode=sp.getInt(colorKey,c);
            textView.setBackgroundColor(colorCode);*/
        //}
        c=sp.getInt(countKey,c);
        textView.setText(String.valueOf(c));
        colorCode=sp.getInt(colorKey,colorCode);
        textView.setBackgroundColor(colorCode);

    }

    /*public void black(View view) {
        int color=getResources().getColor(R.color.black);
        textView.setBackgroundColor(color);
        colorCode=color;
    }

    public void blue(View view) {
        int color=getResources().getColor(R.color.blue);
        textView.setBackgroundColor(color);
        colorCode=color;
    }

    public void red(View view) {
        int color=getResources().getColor(R.color.red);
        textView.setBackgroundColor(color);
        colorCode=color;
    }

    public void green(View view) {
        int color=getResources().getColor(R.color.green);
        textView.setBackgroundColor(color);
        colorCode=color;
    }*/



    public void count(View view) {
        c++;
        textView.setText(String.valueOf(c));
    }

    public void reset(View view) {
        c=0;
        textView.setText(""+c);
        int color=getResources().getColor(R.color.grey);
        textView.setBackgroundColor(color);
        colorCode=color;
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor=sp.edit();
        editor.putInt(countKey,c);
        editor.putInt(colorKey,colorCode);
        editor.apply();

    }

    public void black(View view) {
        int clr = ((ColorDrawable) view.getBackground()).getColor();
        textView.setBackgroundColor(clr);
        colorCode = clr;
    }
}
