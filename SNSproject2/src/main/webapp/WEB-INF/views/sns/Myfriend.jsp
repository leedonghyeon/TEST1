<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>친구조회창</title>
<script>
function RemoveFriend(toFriend){
	alert(toFriend);
	document.form1.user2.value= toFriend;
	document.form1.action="stopfriend";
	document.form1.submit();
}
window.onload = function(){
	   var msg = '${msg}';
	   
	       if ( msg != '')	{   
		   alert('${msg}');
	       }
}
</script>
</head>
<body>
<form name='form1'>
<input type="text" value="${sessionScope.userLoginInfo.member_no}" name="user1">
<input type="text" name="user2">
<h1>${sessionScope.userLoginInfo.member_no}의 친구 목록</h1>

<table border="1">
<tr>
    <th width="100">친구NO</th>
     <th width="100">친구name</th>
	<th width="100">친구TYPE</th>
	<th width="100">끊기</th>
</tr>
<c:forEach var="A" items="${myfriend}">
<tr>
	<td align ="center">${A.USER2}</td>
	<td align ="center">${A.MEMBER_NAME}</td>
	<td align ="center">${A.FRIEND_TYPE}</td>
	<td align ="center"><input type="button" value="친구 끊기" onclick="RemoveFriend(${A.USER2})"></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>