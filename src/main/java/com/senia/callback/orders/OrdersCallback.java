package com.senia.callback.orders;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flow.emag.api.client.EmagClient;
import com.flow.emag.api.config.Environment;

public class OrdersCallback extends HttpServlet {
		
	private static final long serialVersionUID = 3037054054736982695L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				
		this.handleCallback(req, resp);
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				
		this.handleCallback(req, resp);
	}
	
	private void handleCallback(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println( "host ma "+req.getRemoteHost());
		
		if( Environment.getProperty("emag_ip").equals(req.getRemoteHost())){
			System.out.println( "pare brici si ok");
			
			String id = req.getParameter(Environment.getProperty("emag_order_id_key"));
			
			if( id != null ){
				System.out.println( "avem si id");
				EmagClient.newOrder(id);
			}						
		}
	}
}
