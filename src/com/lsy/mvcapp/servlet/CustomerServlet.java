package com.lsy.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsy.mvcapp.dao.CriteriaCustomer;
import com.lsy.mvcapp.dao.CustomerDAO;
import com.lsy.mvcapp.dao.impl.CustomerDAOJdbcImpl;
import com.lsy.mvcapp.domain.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("*.do")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerDAO customerDAO=new CustomerDAOJdbcImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String servletPath = request.getServletPath();
		String methodName=servletPath.substring(1);
		methodName=methodName.substring(0, methodName.length()-3);
		
		Method method;
		try {
			method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.sendRedirect("error.jsp");
		}
		
		//System.out.println(method);
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取表单参数：name,address,phone
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		//2.检验name是否被占用
		//2.1调用CustomerDAO的getCount(String name)获取name在数据库中是否存在
		long count=customerDAO.getCount(name);
		if (count>0) {
			request.setAttribute("message","用户名"+name+"已经被占用，请重新选择");
			request.getRequestDispatcher("/addCustomer.jsp").forward(request, response);
			return;
		}
		
		Customer customer=new Customer(name,address,phone);
		customerDAO.save(customer);
		response.sendRedirect("success.jsp");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr=request.getParameter("id");
		int id=0;
		try {
			id = Integer.parseInt(idStr);
			customerDAO.delete(id);
			
		} catch (Exception e) {
		}
		response.sendRedirect("queryCustomer.do");
		
		
		
	}
	private void queryCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		//System.out.println(name);
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		
		CriteriaCustomer cc=new CriteriaCustomer(name, phone, address);
		//System.out.println(cc.getName()+cc.getAddress()+cc.getPhone());
		//1.调用CustomerDAO的getAll()得到Customer的集合
		List<Customer> cust=customerDAO.getForListWithCriteriaCustomer(cc);
		//System.out.println(cust);
		//2.把Customer的集合放入request中
		request.setAttribute("customers", cust);
		
		//3.转发页面到index.jsp
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forwardPath = "/error.jsp";
		//1.获取请求参数
		String idStr=request.getParameter("id");
		//System.out.println(idStr);
		//2.调用CustoemrDAO的customerDAO.get(id)的方法
		try {
			//3.将customer放入request中	
			Customer customer = customerDAO.get(Integer.parseInt(idStr));
			//System.out.println(customer);
			if(customer !=null){
				forwardPath="/updateCustomer.jsp";
				request.setAttribute("customer", customer);
			}
		} catch (NumberFormatException e) {}
			request.getRequestDispatcher(forwardPath).forward(request, response);
	}
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		//System.out.println(name);
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String oldName=request.getParameter("oldName");
		//System.out.println(oldName);
		if(!oldName.equalsIgnoreCase(name)){
			long count = customerDAO.getCount(name);
			//System.out.println(count);
			if(count > 0){
				request.setAttribute("message", "用户名"+name+"已经被占用，请重新选择！");
				request.getRequestDispatcher("/updateCustomer.jsp").forward(request, response);
				return;
			}
		}
		Customer customer=new Customer(name,address,phone);
		customer.setId(Integer.parseInt(id));
		customerDAO.update(customer);
		response.sendRedirect("queryCustomer.do");
	}

}
