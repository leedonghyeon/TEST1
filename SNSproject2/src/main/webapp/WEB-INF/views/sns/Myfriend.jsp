<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>친구조회창</title>
<script>
function RemoveFriend(toFriend){
	alert(toFriend);
	document.form1.user2.value= toFriend;
	document.form1.submit();
}

</script>
</head>
<body>
<form name='form1' action="myfriend">
<input type="text" value="${sessionScope.userLoginInfo.member_no}" name="user1">
<h1>${sessionScope.userLoginInfo.member_no}의 친구 목록</h1>

<table border="1">
<tr>
    <th width="100">친구NAME</th>
	<th width="100">친구ID</th>
	<th width="100">친구BIRTH</th>
	<th width="100">친구SEX</th>
	<th width="100">끊기</th>
</tr>
<c:forEach var="A" items="${myfriend}">
<tr>
	<td align ="center">${A.member_name}</td>
	<td align ="center">${A.member_id}</td>
	<td align ="center">${A.member_birth}</td>
	<td align ="center">${A.member_sex}</td>
	<td align ="center"><input type="submit" value="친구 끊기" onclick="RemoveFriend(${A.member_no})"></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>