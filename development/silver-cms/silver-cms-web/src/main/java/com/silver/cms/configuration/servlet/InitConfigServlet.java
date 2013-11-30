package com.silver.cms.configuration.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitConfigServlet
 */
@WebServlet(
		urlPatterns = { "/InitConfigServlet" }, 
		initParams = { 
				@WebInitParam(name = "dojoPath", value = "localhost")
		},
		loadOnStartup = 1)
public class InitConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitConfigServlet() {
        super();        
    }

    public void init(ServletConfig config) {
    	System.out.println("dojo path:" + config.getInitParameter("dojoPath"));
    	config.getServletContext().setAttribute("dojoPath", config.getInitParameter("dojoPath"));
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
