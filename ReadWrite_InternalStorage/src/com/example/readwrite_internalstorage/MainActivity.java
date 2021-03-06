package com.example.readwrite_internalstorage;

import java.io.*;
import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{

	Button btnread, btnwrite;
	EditText editdata; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnread = (Button)findViewById(R.id.btnreaddata);
        btnwrite = (Button)findViewById(R.id.btnwritedata);
        editdata = (EditText)findViewById(R.id.editdata);
        btnread.setOnClickListener(this);
        btnwrite.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(arg0.getId() == R.id.btnreaddata)
			readData();
		else if (arg0.getId() == R.id.btnwritedata)
			writeData();
	}
	
	public void readData()
	{
		try
		{
			FileInputStream in = openFileInput("myfile.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String data = "";
			StringBuilder builder = new StringBuilder();
			while((data = reader.readLine()) != null)
			{
				builder.append(data);
				builder.append("\n");
			}
			in.close();
			editdata.setText(builder.toString());
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
    
	public void writeData()
	{
		try 
		{
			FileOutputStream out = openFileOutput("myfile.txt",0);
			OutputStreamWriter writer = new OutputStreamWriter(out);
			writer.write(editdata.getText().toString());
			writer.close();
	 	} catch (FileNotFoundException e) {
	 		e.printStackTrace();
	 	} catch (IOException e) {
	 		e.printStackTrace();
	 	}
	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
