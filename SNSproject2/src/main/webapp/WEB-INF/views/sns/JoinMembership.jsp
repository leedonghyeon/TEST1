<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>회원가입 페이지</title>
        <meta charset="utf-8" >
        <script type="text/javascript">
        //텍스트박스 클릭시 보조문구(value)비우기
        function clearText(field){
            if(field.defaultValue==field.value)
             field.value="";
   		}
        
        //비밀번호 유효성 검사
        function CheckPassword(){
	        var pw1 = document.getElementById("password");
	    
	        if(!/^[a-zA-Z0-9]{8,20}$/.test(pw1.value))
	
	        { 
	        	document.getElementById('checkPwd').style.color = "red";
	        	document.getElementById('checkPwd').innerHTML = "비밀번호는 숫자와 영문자 조합으로 8~20자리를 사용해야 합니다.";
	        }	       
	        else{
	        	document.getElementById('checkPwd').style.color = "green";
	        	document.getElementById('checkPwd').innerHTML = "적절한 비밀번호 입니다.";
	        }

	        var chk_num = pw1.value.search(/[0-9]/g); 
	        var chk_eng = pw1.value.search(/[a-z]/ig);
	
	        if(chk_num < 0 || chk_eng < 0)
	        { 
	        	document.getElementById('checkPwd').style.color = "red";
	        	document.getElementById('checkPwd').innerHTML = "비밀번호는 숫자와 영문자를 혼용하여야 합니다.";
	            return false;
	        }
        }
        
        //이메일 유효성 검사
        function CheckEmail(){
        	var email = document.getElementById("id");
        	var aIndex = email.value.indexOf("@");
        	if(aIndex == 0) { //@가 처음에 위치한다.
        		document.getElementById('checkId').style.color = "red";
	        	document.getElementById('checkId').innerHTML = "메일 입력형식이 올바르지 않습니다.";
	        	email.focus();
	        	return false;
        	}
        	else{
        		document.getElementById('checkId').innerHTML = "";
        	}
        	
        	var dotIndex = email.value.indexOf('.');
        	var len = email.value.length;
        	
        	if(len == (dotIndex+1)) { // '.'이 마지막에 위치한다.
        		document.getElementById('checkId').style.color = "red";
	        	document.getElementById('checkId').innerHTML = "메일 입력형식이 올바르지 않습니다.";
	        	email.focus();
	        	return false;
        	}
        	else{
        		document.getElementById('checkId').innerHTML = "";
        	}
        	
        	if(aIndex == -1 || dotIndex == -1 || aIndex >= (dotIndex-1)) { // '@'나 '.'가 없거나 '@'가 '.'뒤에 위치하거나 붙어있다면
        		document.getElementById('checkId').style.color = "red";
	        	document.getElementById('checkId').innerHTML = "메일 입력형식이 올바르지 않습니다.";
	        	email.focus();
	        	return false;
        	}
        	document.getElementById('checkId').innerHTML = "";
        }
        
        //회원가입에 필요한 문항을 전부다 채워 넣었는지 check
        function Check_input_form(){
      
        	var name = document.form2.member_name.value;
        	var id = document.form2.member_id.value;
        	var password = document.form2.member_password.value;
        	
        	var member_birth = document.form2.member_birth_y.value;
        	if ( document.form2.member_birth_m.value.length == 1 ) 
        		member_birth = member_birth + "0" + document.form2.member_birth_m.value;
        	else  member_birth = member_birth + document.form2.member_birth_m.value; 
        	
        	if ( document.form2.member_birth_d.value.length == 1 )
        		member_birth = member_birth + "0" + document.form2.member_birth_d.value;
        	else  member_birth = member_birth + document.form2.member_birth_d.value; 

        	document.form2.member_birth.value = member_birth;
        	var member_sex = document.form2.member_sex.value;

        	if(name == null || id == null || password == null || member_birth == null || member_sex == null ||
        			name == "" || id == "" || password == "" || member_birth == ""   || member_sex == "" ) {
        		alert("공백을 채우세요");
        		return false; //submit 진행 차단
        	} else {
        		// 모든조건이 충족되면 true반환
        		document.form2.action = 'insert';
        		document.form2.submit();
        	} 

        }
        
        function CheckValue(){
        	if(document.form2.password.value != document.form2.password_re.value){
        		document.getElementById('checkValue').style.color = "red";
	        	document.getElementById('checkValue').innerHTML = "비밀번호가 일치하지 않습니다.";
        	}
        	else{
        		document.getElementById('checkValue').innerHTML ="";
        	}
        }

        function CheckID(){
        	if(document.form2.member_id.value == null || document.form2.member_id.value =="" || document.form2.member_id.value =="이메일"){
        		alert("공백을 채우세요");
        		return false;
        	}
        	else{
        		document.form2.action = 'CheckID';
        		document.form2.submit();
        	}
        }
        
        window.onload = function(){
      	   var msg = '${msg2}';
      	   
      	       if ( msg != '')	{   
      		   alert('${msg2}');
      		   document.form2.member_name.value = '${joinmember.member_name}';
      	       document.form2.member_id.value = '${joinmember.member_id}';
      	       }
        }
        </script>
        
</head>
<body>

		<h1>가입하기</h1><br>    

        <form name="form2" method="post">
        <div class="placeholder_box">
           <input type = "text" id = "name" value = "이름" name="member_name" onfocus="clearText(this)"><br>
           </div>
           <input type = "text" id = "id" value = "이메일" name="member_id" onfocus="clearText(this)" onkeyup="CheckEmail()" onkeydown = "check_Overlap_Id()">
           <input type ="button" id = "checkid" value = "중복검사" onclick="CheckID()"> <!-- 아이디 중복검사 버튼 -->
           <div id="checkId"></div> <!-- 이메일 유효성 체크 메세지 -->
           <input type = "password" id = "password" value = "비밀번호" name="member_password" onfocus="clearText(this)" onkeyup="CheckPassword()">
           <div id="checkPwd"></div> <!-- 비밀번호 유효성 체크 메세지 -->
           <input type = "password" id = "password_re" value = "비밀번호" onfocus="clearText(this)" onkeyup="CheckValue()">
           <div id="checkValue"></div> <!-- 비밀번호 일치 여부 메세지  -->
           <input type = "text" id = "email" value = "email" name="member_email" onfocus="clearText(this)" onkeyup="CheckValue()"><br>
            <input type = "text" id = "phone" value = "전화번호" name="member_phone" onfocus="clearText(this)" onkeyup="CheckValue()"><br>
 		    <input type = "text" id = "join" value ="가입날짜" name="member_join" onfocus="clearText(this)" onkeyup="CheckValue()"><br>
 		      <input type = "text" id = "privacy" value ="공개여부" name="member_privacy" onfocus="clearText(this)" onkeyup="CheckValue()"><br>
 		   <select  name="password_q" >
	         <option value="">질문 </option>
			 <option value="아버지의 성함은?">아버지의 성함은?</option>
			 <option value="가장 좋아하는 색깔은?">가장 좋아하는 색깔은?</option>
			 <option value="가장 좋아하는 음식은?">가장 좋아하는 음식은?</option>
	       </select>  
	       
	       <input type = "text" id = "password_a" name="password_a" value = "비밀번호답변" onfocus="clearText(this)"><br>         
          
           <select name="member_birth_y">
	         <option value="">연도 </option>
		         <c:forEach var="member_birth" begin="1980" end="2016" step="1">
		        	 <option value=${member_birth}>${member_birth}</option>
		         </c:forEach>
	       </select>  
	       <select name="member_birth_m">
	         <option value="">월 </option>
		         <c:forEach var="member_birth" begin="1" end="12" step="1">
		        	 <option value=${member_birth}>${member_birth}</option>
		         </c:forEach>
	       </select>
	       <select name="member_birth_d">
	         <option value="">일 </option>
		         <c:forEach var="member_birth" begin="1" end="31" step="1">
		    		 <option value=${member_birth}>${member_birth}</option>
	          	 </c:forEach>
           </select>
           <input type="hidden" name="member_birth" id="member_birth" value="">
             <br><input type="radio" id= "1" name="member_sex" value="FEMALE">여성
                 <input type="radio" id = "1" name="member_sex" value="MALE">남성<br><br>
             <input type="button" value="계정	 만들기" onClick="Check_input_form()"/>
        </form>
</body>
</html>

