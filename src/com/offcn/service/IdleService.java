package com.offcn.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.dao.BaseDao;
import javax.servlet.http.Part;

public class IdleService {
	BaseDao dao=new BaseDao();
	public int addIdle(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String name = request.getParameter("name");
		String presentation = request.getParameter("presentation");
		String unit = request.getParameter("unit");
		String amount = request.getParameter("amount");
		String location = request.getParameter("location");
		String purchasing_date = request.getParameter("purchasing_date");
		String original_price = request.getParameter("original_price");
		String transfer_price = request.getParameter("transfer_price");
		String transfer_mode = request.getParameter("transfer_mode");
		String percentage = request.getParameter("percentage");
		String fk_idletype = request.getParameter("fk_idletype");

		String idleimg = saveImg(request, response);
		
		String sql = " INSERT INTO u_idle_info "
				+ "(name,idleimg,presentation,unit,amount,location,purchasing_date,original_price,transfer_price,transfer_mode,transfer_state,percentage,fk_idletype,uidle_state,create_date)  "
				+ " VALUES " + " ('" + name + "', '"+idleimg+"' , '" + presentation + "','" + unit + "'," + amount + ",'" + location
				+ "','" + purchasing_date + "'," + original_price + "," + transfer_price + ",'" + transfer_mode
				+ "','未交易','" + percentage + "'," + fk_idletype + ",'正常',CURRENT_DATE()) ";

		int n = new BaseDao().executeUpdate(sql);

		return n;
	}
	
	public List<Map<String,Object>> Selectidle(){
		String sql="select * from u_idle_info";
		
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		return list;
	}
	public int DeleteSerlet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		
		String id=request.getParameter("id");
		String sql = "DELETE FROM u_idle_info WHERE id="+id+"";
		int n = dao.executeUpdate(sql);
		return n;
	}
	
	public List<Map<String,Object>> CheckServlet(HttpServletRequest request, HttpServletResponse response){
		String name=request.getParameter("name");
		String sql="SELECT *FROM u_idle_info WHERE NAME LIKE '%"+name+"%'";
		List<Map<String,Object>> list=new BaseDao().executeQuery(sql);
		return list;
		
	}
	public List<Map<String,Object>> SelectYongHu(){
		String sql="SELECT * FROM u_idle_user";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		
		return list;
	}
	public int SwitchServlet(HttpServletRequest request, HttpServletResponse response)
	{
		String id=request.getParameter("id");
		String sql="UPDATE u_idle_user SET u_state=IF(u_state='正常','锁定','正常') WHERE u_id="+id+" ";
		int n=dao.executeUpdate(sql);
		return n;
	}
	public List<Map<String,Object>> ChaXunServlet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("UTF-8");
		String sql="SELECT u_province,COUNT(u_province) AS amount FROM u_idle_user GROUP BY u_province";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		return list;
	}
	public List<Map<String,Object>> MoHuSelect(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("UTF-8");
		String keyword=request.getParameter("keyword");
		String sql="SELECT * FROM u_idle_user WHERE u_id LIKE '%"+keyword+"%' OR u_nickname LIKE '%"+keyword+"%' OR u_phonenum LIKE '%"+keyword+"%' OR u_password LIKE '%"+keyword+"%' OR u_account LIKE '%"+keyword+"%' OR u_birthday LIKE '%"+keyword+"%' OR u_reg_datetime LIKE '%"+keyword+"%' OR u_state LIKE '%"+keyword+"%' OR u_province LIKE '%"+keyword+"%' OR u_city LIKE '%"+keyword+"%' OR u_district LIKE '%"+keyword+"%' OR u_headimg LIKE '%"+keyword+"%'";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		return list;
	}
	public String saveImg(HttpServletRequest request, HttpServletResponse response){
		Part part = null;
		try {
			//1.获取用户上传图片对应的part对象
			part = request.getPart("idleimg");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		
		//2.获取当前时间
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
		String str = sf.format(date);
		
		//3.获取用户上传的图片的后缀
		String cd = part.getHeader("Content-Disposition");
		//form-data; name="idleimg"; filename="20171108083623.jpg"
		String houzui = cd.substring(cd.lastIndexOf("."), cd.length()-1);
		String fileName = str+houzui;
		
		//4.将图片保存,利用生成的文件名
		try {
			//D:\apache-tomcat-9.0.0.M21\webapps\offcn_idle_sys\idleimg
			String realPath = request.getServletContext().getRealPath("/idleimg")+"\\"+fileName;
			part.write(realPath);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return fileName;
	}
	
}