
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
function AddFriend(toFriend){

	alert(toFriend);
	document.form1.user2.value= toFriend;
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
<form name='form1' action="addfriend">

<input type="text" value="${sessionScope.userLoginInfo.member_no}" name="user1">
<input type="text" name="user2">
<input type="text" name="member_name" id="member_name" value="${member_name}">
<input type="text" name="member_no" id="member_no" value="${sessionScope.userLoginInfo.member_no}">

<h1>${sessionScope.userLoginInfo.member_name}의 검색 목록</h1>
<table border="1">
<tr>
    <th width="100">번호</th>
	<th width="100">이름</th>
	<th width="100">이메일</th>
	<th width="100">상태</th>
	<th width="100">친구신청</th>
</tr>
<c:forEach var="A" items="${joinmember}">
<tr>
	<td align ="center">${A.MEMBER_NO}</td>
	<td align ="center">${A.MEMBER_NAME}</td>
	<td align ="center">${A.MEMBER_BIRTH}</td>
	<td align ="center">${A.FRIEND_STATUS}</td>
	<c:if test="${A.FRIEND_STATUS == 0}">
	<td align ="center"><input type="button" value="친구" disabled='disabled'></td>
	</c:if>
	<c:if test="${A.FRIEND_STATUS eq 2}">
	<td align ="center"><input type="button" value="신청중" disabled='disabled'></td>
	</c:if>
	<c:if test="${A.FRIEND_STATUS eq 3}">
	<td align ="center"><input type="button" value="수락대기" disabled='disabled'></td>
	</c:if>
	<c:if test="${A.FRIEND_STATUS eq 9}">
	<td align ="center"><input type="button" value="신청" onclick="AddFriend(${A.MEMBER_NO})"></td>
	</c:if>
	</tr>
</c:forEach>
</table>
</form>
</body>
</html>