package com.example.resfile_internalstorage;

import java.io.*;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

	Button btnRead;
	EditText editData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRead = (Button)findViewById(R.id.btnreaddata);
        editData = (EditText)findViewById(R.id.editdata);
        btnRead.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				readData();
			}
		});
    }

    public void readData()
    {
	    String data;
	    InputStream in= getResources().openRawResource(R.drawable.myfile);
	    InputStreamReader inreader=new InputStreamReader(in);
	    BufferedReader bufreader=new BufferedReader(inreader);
	    StringBuilder builder=new StringBuilder();
	    if(in!=null)
	    {
    		try
    		{
    			while((data=bufreader.readLine())!=null)
    			{
    				builder.append(data);
    				builder.append("\n");
    			}
    			in.close();
    			editData.setText(builder.toString());
    		}
    		catch(IOException ex){
    			Log.e("ERROR", ex.getMessage());
    		}
	    }
   }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
