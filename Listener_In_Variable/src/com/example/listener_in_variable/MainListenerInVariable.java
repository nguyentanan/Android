package com.example.listener_in_variable;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainListenerInVariable extends Activity {

	private Button btnFar, btnCel, btnClear;
	private EditText txtFar, txtCel;
	
	private OnClickListener myVarListener = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			double F;
			double C;
			
			if(arg0.getId() == R.id.btnFar)
			{
				F = Double.parseDouble(txtFar.getText()+"");
				DecimalFormat dcf=new DecimalFormat("#.00");
				C = (F-32)*5/9;
				txtCel.setText(dcf.format(C));
			}
			else if(arg0.getId() == R.id.btnCel)
			{
				C = Double.parseDouble(txtCel.getText()+"");
				DecimalFormat dcf=new DecimalFormat("#.00");
				F = C*9/5+32;
				txtFar.setText(dcf.format(F));
			}
			else if(arg0.getId() == R.id.btnClear)
			{
				txtFar.setText("");
				txtCel.setText("");
				txtFar.requestFocus();
			}
		}
	};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_listener_in_variable);
        
		txtFar = (EditText)findViewById(R.id.txtFar);
		txtCel = (EditText)findViewById(R.id.txtCel);
		btnFar = (Button)findViewById(R.id.btnFar);
		btnCel = (Button)findViewById(R.id.btnCel);
		btnClear = (Button)findViewById(R.id.btnClear);
		
		btnFar.setOnClickListener(myVarListener);
		btnCel.setOnClickListener(myVarListener);
		btnClear.setOnClickListener(myVarListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_listener_in_variable, menu);
        return true;
    }
    
}
