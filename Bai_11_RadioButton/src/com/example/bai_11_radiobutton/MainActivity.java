package com.example.bai_11_radiobutton;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
	
	RadioGroup rg;
	RadioButton rb1, rb2, rb3, rb4, rb5;
	Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup)findViewById(R.id.radioGroup1);
        rb1 = (RadioButton)findViewById(R.id.radioButton1);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rb3 = (RadioButton)findViewById(R.id.radioButton3);
        rb4 = (RadioButton)findViewById(R.id.radioButton4);
        rb5 = (RadioButton)findViewById(R.id.radioButton5);
        btn1 = (Button)findViewById(R.id.button1);
        
        rb1.setChecked(true);
        
        btn1.setOnClickListener(new View.OnClickListener()
        {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				rg.clearCheck();
			}
        	
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
