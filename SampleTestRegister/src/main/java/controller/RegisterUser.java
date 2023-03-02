package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;


@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public RegisterUser() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//フォワード先
		String forwardPath = null;
		
		//サーブレットクラスの動作を決定する値を取得
		String action = request.getParameter( "action" );
		
		if( action == null ) {
			forwardPath = "WEB-INF/jsp/registerForm.jsp";
			
		}else if( action.equals( "done" ) ){
			HttpSession session = request.getSession();
			User registerUser   = ( User )session.getAttribute( "registerUser" );
		
			//登録処理の呼び出し
			RegisterUserLogic logic = new RegisterUserLogic();
			logic.execute( registerUser );
			
			//不要となったセッションスコープ内のインスタンスを消去
			session.removeAttribute( "registerUser" );
			
			//登録後のフォワード先を設定
			forwardPath = "WEB-INF/jsp/registerDone.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher( forwardPath );
		dispatcher.forward( request , response );
		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//リクエストパラメータの取得
		request.setCharacterEncoding( "UTF-8" );
		String id   = request.getParameter( "id"   );
		String name = request.getParameter( "name" );
		String pass = request.getParameter( "pass" );
		
		//登録するユーザーの情報を設定
		User registerUser = new User( id , name , pass );
		
		//セッションスコープに登録ユーザーを保存
		HttpSession session = request.getSession();
		session.setAttribute( "registerUser" , registerUser );
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher( "WEB-INF/jsp/registerConfirm.jsp" );
		dispatcher.forward( request , response );
		
	}
	
	
}