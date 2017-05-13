package com.example.vidu_listview_arraylist_object;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {

	EditText editId, editName;
	Button btnNhap;
	RadioGroup radgroup;
	ListView lvNhanvien;
	ArrayList<Employee> arrEmployee = new ArrayList<Employee>();
	ArrayAdapter<Employee> adapter = null;
	Employee emp = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editId=(EditText) findViewById(R.id.editMa);
        editName=(EditText) findViewById(R.id.editTen);
        btnNhap=(Button) findViewById(R.id.btnnhap);
        radgroup=(RadioGroup) findViewById(R.id.radiogroud1);
        lvNhanvien=(ListView) findViewById(R.id.lvnhanvien);
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1, arrEmployee);
        lvNhanvien.setAdapter(adapter);
        
        btnNhap.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				processNhap();
			}
        	
        });
    }
        public void processNhap()
        {
        	int radId=radgroup.getCheckedRadioButtonId();
        	String id=editId.getText()+"";
        	String name=editName.getText()+"";
        	if(radId==R.id.radChinhthuc)
        	{
        		emp=new EmployeeFullTime();
        	}
        	else
        	{
        		emp=new EmployeePartTime();
        	}
        	emp.setId(id);
        	emp.setName(name);
        	arrEmployee.add(emp);
        	adapter.notifyDataSetChanged();

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
