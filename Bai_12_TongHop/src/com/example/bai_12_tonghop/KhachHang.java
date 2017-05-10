package com.example.bai_12_tonghop;

public class KhachHang {
	private String tenKH;
	private int slmua;
	private boolean isVip;
	public static final int GIA = 20000;
	
	public KhachHang(){
		
	}
	
	public KhachHang(String tenKH, int slmua, boolean isVip)
	{
		this.tenKH = tenKH;
		this.slmua = slmua;
		this.isVip = isVip;
	}
	
	public String getTenKH()
	{
		return tenKH;
	}
	public void setTenKH(String tenKH)
	{
		this.tenKH = tenKH;
	}
	public int getslmua()
	{
		return slmua;
	}
	public void setslmua(int slmua)
	{
		this.slmua = slmua;
	}
	public boolean getisVip()
	{
		return isVip;
	}
	public void setisVip(boolean isVip)
	{
		this.isVip = isVip;
	}
	public double tinhThanhTien()
	{
		return (!isVip?slmua*GIA:slmua*GIA*0.9);
	}
}
