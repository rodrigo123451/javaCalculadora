package CalculadoraServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CalculadoraService.CalculadoraService;

/**
 * Servlet implementation class CalculadoraServlet
 */
@WebServlet("/CalculadoraServlet")
public class CalculadoraServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Double n1=Double.parseDouble(request.getParameter("Numero 1"));
		Double n2=Double.parseDouble(request.getParameter("Numero 2"));
		String operador=request.getParameter("operador");
		Double resultado=0.0;
		
		//proceso
		CalculadoraService service=new CalculadoraService();
		switch(operador) {
		case("+"):
			resultado=service.Suma(n1, n2);
			break;
		case("-"):
			resultado=service.Resta(n1, n2);
			break;
		case("*"):
			resultado=service.Multi(n1, n2);
			break;
		case("/"):
			resultado=service.Division(n1, n2);
			break;
		}
		//reporte
		response.setContentType("text/hyml;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>CALCULADORA</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>CALCULADORA</h1>");
		out.println("<p>numero 1:"+n1+"</p>");
		out.println("<p>numero 2:"+n2+"</p>");
		out.println("<p>resultado:"+resultado+"</p>");
		out.println("<p><a href='index.html'>nueva operacion</a></p>");
		out.println("</body>");
		out.println("</html>");
		out.flush();
	}

}
