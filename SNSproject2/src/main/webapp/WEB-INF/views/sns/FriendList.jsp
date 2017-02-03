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
	document.form1.user1.value= all;
	document.form1.submit();
}


</script>
<body>
<h1>친구 신청 목록</h1>
<form name='form1' action="allowfriends">
<input type="text" name="user1">
<input type="text" value="${sessionScope.userLoginInfo.member_no}" name="user2">
<table border="1">
<tr>
	<th width="100">신청한사람</th>
	<th width="100">상태</th>
	<th width="100">타입</th>
	<th width="100">수락</th>
</tr>
<c:forEach var="A" items="${friends}">
<tr>
	<td align ="center">${A.user1}</td>
	<td align ="center">${A.friend_status}</td>
	<td align ="center">${A.friend_type}</td>
	<td align ="center"><input type="button" value="수락" onclick="allow(${A.user1})"></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>