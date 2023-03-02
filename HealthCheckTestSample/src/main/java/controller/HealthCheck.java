package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HealthData;
import model.HelthCheckLogic;


@WebServlet("/HealthCheck")
public class HealthCheck extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public HealthCheck() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/healthCheck.jsp");
		dispatcher.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//パラメータリストを取得
		String weight = request.getParameter( "weight" );
		String height = request.getParameter( "height" );
		
		//入力値をプロパティに設定
		HealthData hd = new HealthData();
		hd.setHeight( Double.parseDouble( height ) );
		hd.setWeight( Double.parseDouble( weight ) );
		
		//健康診断の実行
		HelthCheckLogic helthCheckLogic = new HelthCheckLogic();
		helthCheckLogic.execute(hd);
		
		//リクエストスコープに保存
		request.setAttribute( "health" , hd );
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/healthCheckResult.jsp");
		dispatcher.forward(request, response);
	}

}
