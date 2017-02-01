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
function cancel(can){
	alert(can);
	document.form1.user2.value= can;
	document.form1.submit();
}


</script>
<body>
<h1>친구 신청한 목록</h1>
<form name='form1' action="cancelfriends">
<input type="text" value="${sessionScope.userLoginInfo.member_no}" name="user1">
<input type="text" name="user2">
<table border="1">
<tr>
	<th width="100">상대</th>
	<th width="100">상태</th>
	<th width="100">타입</th>
	<th width="100">취소</th>
</tr>
<c:forEach var="A" items="${friends}">
<tr>
	<td align ="center">${A.user2}</td>
	<td align ="center">${A.friend_status}</td>
	<td align ="center">${A.friend_type}</td>
	<td align ="center"><input type="button" value="취소" onclick="cancel(${A.user2})"></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>