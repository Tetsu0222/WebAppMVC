package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ExecuteLoginBL;
import model.UserInfoDto;

public class ExecuteLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType( "text/html;charset=UTF-8" );
		request.setCharacterEncoding( "UTF-8" );

		HttpSession session           = request.getSession();
		UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute( "LOGIN_INFO" );

		if ( userInfoOnSession != null ) {
			response.sendRedirect( "InputSurvey" );
		} else {
			boolean succesFlg = true;
			//パラメータのバリデーションチェック
			if( !( validatePrmUserId(request.getParameter( "USER_ID" ) )        &&
					validatePrmPassword(request.getParameter( "PASSWORD") )     ) ) {
				//バリデーションNGの場合
				succesFlg = false ;
			}else {
				//バリデーションOKの場合
				//リクエストパラメータからユーザー入力値を取得
				String userId   = request.getParameter( "USER_ID"  );
				String passWord = request.getParameter( "PASSWORD" );
				
				ExecuteLoginBL logic = new ExecuteLoginBL();
				UserInfoDto    dto   = logic.executeSelectUserInfo(userId, passWord);
				if (dto.getUserId() == null) {
					succesFlg = false ;
				}else {
					session.setAttribute("LOGIN_INFO", dto);
				}
			}
			if (succesFlg) {
				response.sendRedirect("ShowSurveyByMessege");
			} else {
				response.sendRedirect( "view/Login.html" );
			}
		}
	}

	/**----------------------------------------------------------------------*
	 *■■■validatePrmUserIdクラス■■■
	 *概要：バリデーションチェック
	 *詳細：入力値（名前）の検証を行う
	 *----------------------------------------------------------------------**/
	private boolean validatePrmUserId( String pr) {

		boolean validateResult = true ;

		//入力値がnullまたは空白の場合はエラーとする
		if( pr == null || pr.equals("") ) {
			validateResult = false ;
		}

		return validateResult ;
	}

	/**----------------------------------------------------------------------*
	 *■■■validatePrmPasswordクラス■■■
	 *概要：バリデーションチェック
	 *詳細：入力値（年齢）の検証を行う
	 *----------------------------------------------------------------------**/
	private boolean validatePrmPassword( String pr) {

		boolean validateResult = true ;

		//入力値がnullまたは空白の場合はエラーとする
		if( pr == null || pr.equals("") ) {
			validateResult = false ;
		}

		return validateResult ;
	}

}