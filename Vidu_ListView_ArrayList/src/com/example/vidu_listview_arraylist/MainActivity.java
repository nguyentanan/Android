package com.example.vidu_listview_arraylist;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {

	EditText txtten;
	TextView txtchon;
	Button btn;
	ListView lv;
	ArrayList<String> arrList = null;
	ArrayAdapter<String> adapter = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtten = (EditText)findViewById(R.id.txtTen);
		txtchon = (TextView)findViewById(R.id.txtselection);
		lv = (ListView)findViewById(R.id.lvperson);
		arrList = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrList);
		lv.setAdapter(adapter);
		btn = (Button)findViewById(R.id.btnNhap);
		btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				arrList.add(txtten.getText()+"");
				adapter.notifyDataSetChanged();
			}
		});
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				txtchon.setText("position : "+ arg2 + "; value =" + arrList.get(arg2));

			}
		});
		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				arrList.remove(arg2);//xóa phần tử thứ arg2
				adapter.notifyDataSetChanged();
				return false;
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
