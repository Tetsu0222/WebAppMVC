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

		String receivePrmSatLv     = request.getParameter("SATISFACTION_LEVEL");

		List<ShinrinDto> surveyDtoList = new ArrayList<ShinrinDto>();                      
		BusinessLogic   logic         = new BusinessLogic();
		surveyDtoList = logic.executeSelectSurveyBySatisfactionLevel( receivePrmSatLv );

		//アンケートリストをリクエストスコープに保存
		request.setAttribute( "SURVEY_LIST_BY_SATISFACTION_LEVEL" , surveyDtoList );

		//Viewにフォワード（フォワード先：show_survey_by_satisfaction_level.jsp）
		RequestDispatcher dispatch = request.getRequestDispatcher("view/show_survey_by_satisfaction_level.jsp");
		dispatch.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
