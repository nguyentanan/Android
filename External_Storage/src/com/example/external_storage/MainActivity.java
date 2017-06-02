package com.example.external_storage;

import java.io.*;
import java.util.Scanner;

import android.os.*;
import android.app.Activity;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity implements OnClickListener{

	Button btnread,btnwrite;
	EditText editdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnread=(Button) findViewById(R.id.btnread);
        btnwrite=(Button) findViewById(R.id.btnwrite);
        editdata=(EditText) findViewById(R.id.editdata);
        btnread.setOnClickListener(this);
        btnwrite.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.btnread)
	 	{
			readData();
		}
		else if(v.getId()==R.id.btnwrite)
		{
			writeData();
		}
	}
	
	public void readData()
	{
		String sdcard=Environment.getExternalStorageDirectory().getAbsolutePath()+"/myfile.txt";
		try {
		Scanner scan=new Scanner(new File(sdcard));
		String data="";
		while(scan.hasNext())
		{
			data+=scan.nextLine()+"\n";
		}
		scan.close();
		editdata.setText(data+"");
	 } catch (FileNotFoundException e) {
		 e.printStackTrace();
	 }
	}

	public void writeData()
	{
		String sdcard=Environment.getExternalStorageDirectory().getAbsolutePath()+"/myfile.txt";
		try {
			OutputStreamWriter writer=new OutputStreamWriter(new FileOutputStream(sdcard));
			writer.write(editdata.getText()+"");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		 e.printStackTrace();
		}
	}
    
}
