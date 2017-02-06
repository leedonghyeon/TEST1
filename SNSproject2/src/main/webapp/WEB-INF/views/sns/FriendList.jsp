<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
function allow(all){
	alert(all);
	document.form1.user2.value= all;
	document.form1.submit();
}
</script>
<body>
<h1>친구 신청 목록</h1>
<form name='form1' action="allowfriends">
<input type="text" value="${sessionScope.userLoginInfo.member_no}" name="user1">
<input type="text" name="user2">
<table border="1">
<tr>
	<th width="100">신청한사람</th>
	<th width="100">이름</th>
	<th width="100">상태</th>
	<th width="100">타입</th>
	<th width="100">수락</th>
</tr>
<c:forEach var="A" items="${friends}">
<tr>
	<td align ="center">${A.USER2}</td>
	<td align ="center">${A.MEMBER_NAME}</td>
	<td align ="center">${A.FRIEND_STATUS}</td>
	<td align ="center">${A.FRIEND_TYPE}</td>
	<td align ="center"><input type="button" value="수락" onclick="allow(${A.USER2})"></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>