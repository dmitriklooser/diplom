package web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbPool;

public class AppController extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		req.getParameter("");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		req.getParameter("");
		DbPool pool = new DbPool();
		Connection conn = pool.getConnection();
	}

}// class AppController 
//@WebServlet(urlPatterns={"/main"})