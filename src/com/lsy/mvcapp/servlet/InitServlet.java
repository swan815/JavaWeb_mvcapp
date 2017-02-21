package com.lsy.mvcapp.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsy.mvcapp.dao.factory.CustomerDAOFactory;


/**
 * Servlet implementation class InitServlet
 */
@WebServlet(urlPatterns ="/InitServlet")

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	
	@Override
	public void init() throws ServletException {
		
		 CustomerDAOFactory.getInstance().setType("jdbc");
		
		InputStream in = getServletContext().getResourceAsStream("/build/classes/switch.propersities");
		
		Properties propersities = new Properties();
		
		try {
			propersities.load(in);
			String type = propersities.getProperty("type");
			 CustomerDAOFactory.getInstance().setType(type);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
