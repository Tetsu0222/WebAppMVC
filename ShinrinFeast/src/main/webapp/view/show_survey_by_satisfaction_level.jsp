<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List"      %>
<%@ page import="model.ShinrinDto"    %>

<%
List<ShinrinDto> surveyDtoList = (List<ShinrinDto>)request.getAttribute("SURVEY_LIST_BY_SATISFACTION_LEVEL");
%>

<html>
  <head>
    <title>メッセージ一覧</title>
  </head>
  <body>
    <h2>メッセージ一覧</h2>
    <table class="surbey_list" border=1>
      <tr bgcolor="#c0c0c0">
        <th>名前</th>
        <th>Email</th>
        <th>ご意見・ご感想</th>
        <th>回答時間</th>
      </tr>

<%
for (int i = 0; i < surveyDtoList.size(); i++) {
	ShinrinDto dto = surveyDtoList.get( i );
%>
      <tr>
        <td><%= dto.getName() %></td>
        <td><%= dto.getMail() %></td>
        <td><%= dto.getMessage() %></td>
        <td><%= dto.getTime() %></td>
      </tr>
<%
}
%>
    </table>
    <br>
    <form action="<%=request.getContextPath()%>/ExecuteLogout" method="post">
    <input type="submit" class="button" value="ログアウト" id="ID_SUBMIT">
    </form>
  </body>
</html>
