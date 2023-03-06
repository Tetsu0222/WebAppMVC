package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BusinessLogic;
import model.ShinrinDto;


public class ShowSurveyByMessege extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowSurveyByMessege() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ShinrinDto> shinrinDtoList = new ArrayList<ShinrinDto>();                      
		BusinessLogic   logic           = new BusinessLogic();
		shinrinDtoList = logic.executeSelect();

		request.setAttribute( "shinrinDtoList" , shinrinDtoList );

		RequestDispatcher dispatch = request.getRequestDispatcher( "view/show_by_message.jsp" );
		dispatch.forward ( request , response );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet( request , response );
	}
}
