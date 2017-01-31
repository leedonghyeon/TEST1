package com.manage.biz.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manage.biz.service.JoinMemberService;
import com.manage.biz.vo.JoinMember;

import com.manage.biz.vo.Friends;

/**
 * Handles requests for the application home page.
 */
@Controller
public class JoinMemberController {
	
	@Autowired
	JoinMemberService joinmemberService;
	
	private static final Logger logger = LoggerFactory.getLogger(JoinMemberController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	
	//ȸ������ ������
	@RequestMapping("/application") 
	public String IntroPage(Locale locale, Model model) throws Exception {

		return "sns/JoinMembership"; //views->sns->JoinMembership.jsp
		
	}
	
	//ȸ������ - db�� ����
	@RequestMapping("/insert") 
	public String JoinMemberList(JoinMember joinmember, Model model) throws Exception {
		
		joinmemberService.insertJoinMember(joinmember);
		return "sns/loginpage"; //views->sns->loginpage.jsp
		
	}
	
	//�α��� ������(���̵�, ��й�ȣ �Է�)
	@RequestMapping("/loginForm") //Ȩ������ �ּ� http://localhost:8080/biz/loginForm
    public String loginForm(Model model){
		
        return "sns/loginpage";
        
    }
	
    //�α��� ó��
    @RequestMapping("/loginProcess")
	public String loginProcess(JoinMember user, HttpSession session, Model model) throws Exception {
    	
		JoinMember loginUser = joinmemberService.findByUserIdAndPassword(user.getMember_id(), user.getMember_password());

		if (loginUser != null) { //session check
			session.setAttribute("userLoginInfo", loginUser);
			return "sns/main"; //�α��� �� �Ѿ�� ȭ��
		}
		
		return "sns/FailPage";	//�α��� ���� �� 

	}
    
    // �α׾ƿ�
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        /*session.setAttribute("userLoginInfo", null);*/
        session.invalidate(); //session ����(�ȿ��ִ� ������ �ٻ���)
        return "redirect:loginForm";
        
    }
 
    //ȸ��Ż�� ������  
    @RequestMapping("/deleteForm")
    public String deletePage() throws Exception{

    	return "sns/delForm";
    	
    }
   
    //ȸ��Ż��
    @RequestMapping("/delete")
    public String execute(JoinMember user, HttpSession session, Model model) throws Exception{
    	
    	int rtn = joinmemberService.matching(user);
    	
    	if(rtn == 1){
    		model.addAttribute("user", user);
	    	session.invalidate();
	    	joinmemberService.removeMember(user);
	    	return "redirect:loginForm";
    	}
    	else{
    		model.addAttribute("msg1", "��й�ȣ�� Ȯ���ϼ���.");
			return "sns/delForm";	
    	}
    	
    }

    //�н����� ã�� ������
    @RequestMapping("/pass")
	public String IntroPage1(Locale locale, Model model) throws Exception {

		return "sns/FindPassword"; 
		
	}
	
    //��й�ȣ ã��
	@RequestMapping("/findpassword")
	public String FindPassword(JoinMember joinmember, Model model) throws Exception {

		int rtn=joinmemberService.findPassword(joinmember);
		if(rtn==1)
		{
			model.addAttribute("joinmember", joinmember);
			model.addAttribute("msg", "change your password.");
			return "sns/UpdatePassword";
		}
		else
		{	
			model.addAttribute("msg1", "Ʋ�Ƚ��ϴ�.");
			return "sns/FindPassword";	
		}
		
	}
	
	//��й�ȣ ����
	@RequestMapping("/updatepassword") 
	public String UpdatePassword(JoinMember joinmember, Model model) throws Exception {
		
		joinmemberService.updatePassword(joinmember);

		return "sns/loginpage";
		
	}
	
	//���̵� �ߺ��˻�
	@RequestMapping("/CheckID")
	public String CheckID(JoinMember joinmember, Model model) throws Exception {

		int rtn1=joinmemberService.CheckID(joinmember);
		
		if(rtn1==0)
		{
			model.addAttribute("joinmember", joinmember);
			model.addAttribute("msg2", "������ ���̵��Դϴ�");
			return "sns/JoinMembership"; 
		}
		else
		{	
			model.addAttribute("msg2", "�ߺ��Դϴ�.");
			return "sns/JoinMembership";	
		}
	}
	
	@RequestMapping("/findpeople")//친구 찾기
	public String FindPeople(JoinMember joinmember, Model model, HttpServletRequest req) throws Exception {

		List<JoinMember> peoplelist = joinmemberService.findPeople(joinmember);
		model.addAttribute("joinmember", peoplelist);
		
		
		model.addAttribute("msg", req.getParameter("msg")); //addfriend -> findpeople
		model.addAttribute("member_name", joinmember.getMember_name());//addfriend -> findpeople
		return "sns/PeopleList";

	}
	//친구 신청 및 신청한 목록
	@RequestMapping("/addfriend")
	public String addfriend( Model model, Friends friends,JoinMember joinmember, HttpServletRequest req) throws Exception {
		int m_friend = joinmemberService.addfriend(friends);
		model.addAttribute("joinmember", joinmember);
		String msg = "add friend finish";
		return "redirect:findpeople?member_name="+req.getParameter("member_name")+"&msg="+msg; //redirect member_name 과 message 전달
	}
	// 친구 수락
	@RequestMapping("/friendsList") 
	public String friendslist(Friends friends, Model model) throws Exception {
		List<Friends> friendslist = joinmemberService.selectfriends(friends);
		model.addAttribute("friends", friendslist);
		
		return "sns/FriendList";
	}
	@RequestMapping("/allowfriends") 
	public String allowfriends(Friends friends, Model model) throws Exception {

		joinmemberService.allowfriends(friends);
		List<Friends> friendslist = joinmemberService.selectfriends(friends);
		model.addAttribute("friends", friendslist);
		return "sns/FriendList";
	}
	
	
	//친구조회
	@RequestMapping("/myfriend") 
	public String Myfriend(Friends friends, Model model,HttpServletRequest req) throws Exception {
	

		List<JoinMember> my = joinmemberService.myfriend(friends);
		model.addAttribute("myfriend", my);
		
		model.addAttribute("msg1", req.getParameter("msg1"));
		model.addAttribute("user1", friends.getUser1());
		
		return "sns/Myfriend";
	}	
	//친구끊기
	@RequestMapping("/stopfriend") 
	public String Stopfriend(Friends friends, Model model,HttpServletRequest req) throws Exception {
	
		joinmemberService.stopfriend(friends);
		String msg1 = "friend remove finish";
	
		return "redirect:myfriend?user1="+req.getParameter("user1")+"&msg1="+msg1;
	}	
	

}

