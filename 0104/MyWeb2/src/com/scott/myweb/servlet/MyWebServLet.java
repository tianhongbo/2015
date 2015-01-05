package com.scott.myweb.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyWebServLet
 */
@WebServlet(description = "This is Scott's first Servlet Class.", urlPatterns = { "/MyWebServLet" })
public class MyWebServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyWebServLet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("image/jpeg");

		File f = new File("/Users/tianhongbo/Downloads/sophia.jpg");
		BufferedImage bi = ImageIO.read(f);
		OutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
