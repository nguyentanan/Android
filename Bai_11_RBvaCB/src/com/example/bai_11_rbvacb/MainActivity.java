package com.example.bai_11_rbvacb;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {

	EditText editTen, editCMND, editBoSung;
	CheckBox chkDocBao, chkDocSach, chkDocCode;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTen = (EditText)findViewById(R.id.edHoten);
        editCMND = (EditText)findViewById(R.id.edCMND);
        editBoSung = (EditText)findViewById(R.id.edBosung);
        chkDocBao = (CheckBox)findViewById(R.id.cbDocBao);
        chkDocSach = (CheckBox)findViewById(R.id.cbDocSach);
        chkDocCode = (CheckBox)findViewById(R.id.cbDocCode);
        Button btn = (Button)findViewById(R.id.btnGui);
        btn.setOnClickListener(new View.OnClickListener()
        {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				doShowInformation();
			}
        	
        });
        
    }
    
    public void doShowInformation()
    {
    	String ten = editTen.getText()+ "";
    	ten = ten.trim();
    	if(ten.length()<3)
    	{
    		editTen.requestFocus();
    		editTen.selectAll();
    		Toast.makeText(this, "Tên phải >= 3 ký tự",Toast.LENGTH_LONG).show();
    		return;
    	}
    	
    	String cmnd = editCMND.getText()+ "";
    	cmnd = cmnd.trim();
    	if(cmnd.length()!=9)
    	{
    		editCMND.requestFocus();
    		editCMND.selectAll();
    		Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
    		return;
    	}
    	
    	String bang = "";
    	RadioGroup group = (RadioGroup)findViewById(R.id.RadioGroup1);
    	int id = group.getCheckedRadioButtonId();
    	if(id == -1)
    	{
    		Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
    		return;
    	}
    	RadioButton rad=(RadioButton)findViewById(id);
    	bang = rad.getText()+"";
    	
    	String sothich = "";
    	if(chkDocBao.isChecked())
    	sothich += chkDocBao.getText()+"\n";
    	if(chkDocSach.isChecked())
    	sothich += chkDocSach.getText()+"\n";
    	if(chkDocCode.isChecked())
    	sothich += chkDocCode.getText()+"\n";

    	String bosung = editBoSung.getText()+"";
    	
    	AlertDialog.Builder builder=new AlertDialog.Builder(this);
    	builder.setTitle("Thông tin cá nhân");
    	builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				arg0.cancel();
			}
    	});
    	String msg = ten + "\n";
    	msg += cmnd + "\n";
    	msg += bang + "\n";
    	msg += sothich;
    	msg += "——————————\n";
    	msg += "Thông tin bổ sung:\n";
    	msg += bosung + "\n";
    	msg += "——————————";
    	builder.setMessage(msg); //thiết lập nội dung
    	builder.create().show(); //hiển thị Dialog


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
