package com.example.bai_12_tonghop;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {

	Button btnTT, btnTiep, btnTK;
	ImageButton btnThoat;
	EditText editTen, editSl, editTongKh, editTongKhVip, ediTongTT;
	TextView txtTT;
	CheckBox chkVip;	 
	DanhSachKH danhsach = new DanhSachKH();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControls();
        addEvents();
    }

    private void getControls()
    {
    	btnTT=(Button) findViewById(R.id.btntinhtt); 	 
    	btnTiep=(Button) findViewById(R.id.btntiep); 
    	btnTK=(Button) findViewById(R.id.btnthongke);  	 
    	btnThoat=(ImageButton) findViewById(R.id.imgbtnthoat);
	  	editTen=(EditText) findViewById(R.id.edtenkh);
    	editSl=(EditText) findViewById(R.id.edsoluongsach);
    	editTongKh=(EditText) findViewById(R.id.edtongsokh);
    	editTongKhVip=(EditText) findViewById(R.id.edtongsokhlavip);
    	ediTongTT=(EditText) findViewById(R.id.edtongdt); 
    	txtTT=(TextView) findViewById(R.id.txtthanhtien);
    	chkVip =(CheckBox) findViewById(R.id.chklavip);
    }
    
    private void addEvents()
    {
    	btnTT.setOnClickListener(new ProcessMyEvent());
    	btnTiep.setOnClickListener(new ProcessMyEvent());
    	btnTK.setOnClickListener(new ProcessMyEvent());    	 
    	btnThoat.setOnClickListener(new ProcessMyEvent());
    }
    
    private void doTinhTien()
    { 
	    KhachHang kh=new KhachHang(); 
	    kh.setTenKH(editTen.getText()+""); 
	    kh.setslmua(Integer.parseInt(editSl.getText()+""));   
	    kh.setisVip(chkVip.isChecked()); 
	    txtTT.setText(kh.tinhThanhTien()+"");
	    danhsach.addKhachHang(kh);     
    }

    private void doTiep()
    {
    	editTen.setText(""); 
    	editSl.setText("");	 
    	txtTT.setText("");
    	editTen.requestFocus();
    }
    
    private void doThongKe()    
    {
    	editTongKh.setText(danhsach.tongKhachHang()+"");
    	editTongKhVip.setText(danhsach.tongKhachHangVip()+"");
    	ediTongTT.setText(danhsach.tongDoanhThu()+"");
    }
    
    private void doThoat()
    {    
    	AlertDialog.Builder builder=new AlertDialog.Builder(this); 
    	builder.setTitle("Hỏi thoát chương trình");
    	builder.setMessage("Muốn thoát chương trình này hả?"); 
    	builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				arg0.cancel();
			}
    	});
    	
    	builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				finish();
			}
    	});
    	
    	builder.create().show();
	}
    
	private class ProcessMyEvent implements OnClickListener
    {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch(arg0.getId())	 
			{
				case R.id.btntinhtt:
					doTinhTien();
					break;
				case R.id.btntiep:
					doTiep();
					break;
				case R.id.btnthongke:
					doThongKe();
					break;
				case R.id.imgbtnthoat:
					doThoat();
					break;
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
