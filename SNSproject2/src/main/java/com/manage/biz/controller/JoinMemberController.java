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
import com.manage.biz.vo.Board;
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
	
	//회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
	@RequestMapping("/application") 
	public String IntroPage(Locale locale, Model model) throws Exception {

		return "sns/JoinMembership"; //views->sns->JoinMembership.jsp
		
	}
	
	//회占쏙옙占쏙옙占쏙옙 - db占쏙옙 占쏙옙占쏙옙
	@RequestMapping("/insert") 
	public String JoinMemberList(JoinMember joinmember, Model model) throws Exception {
		
		joinmemberService.insertJoinMember(joinmember);
		return "sns/loginpage"; //views->sns->loginpage.jsp
		
	}
	
	//占싸깍옙占쏙옙 占쏙옙占쏙옙占쏙옙(占쏙옙占싱듸옙, 占쏙옙橘占싫� 占쌉뤄옙)
	@RequestMapping("/loginForm") //홈占쏙옙占쏙옙占쏙옙 占쌍쇽옙 http://localhost:8080/biz/loginForm
    public String loginForm(Model model){
		
        return "sns/loginpage";
        
    }
	
    //占싸깍옙占쏙옙 처占쏙옙
    @RequestMapping("/loginProcess")
	public String loginProcess(JoinMember user, HttpSession session, Model model) throws Exception {
    	
		JoinMember loginUser = joinmemberService.findByUserIdAndPassword(user.getMember_id(), user.getMember_password());

		if (loginUser != null) { //session check
			session.setAttribute("userLoginInfo", loginUser);
			return "sns/main"; //占싸깍옙占쏙옙 占쏙옙 占싼어가占쏙옙 화占쏙옙
		}
		
		return "sns/FailPage";	//占싸깍옙占쏙옙 占쏙옙占쏙옙 占쏙옙 

	}
    
    // 占싸그아울옙
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        /*session.setAttribute("userLoginInfo", null);*/
        session.invalidate(); //session 占쏙옙占쏙옙(占싫울옙占쌍댐옙 占쏙옙占쏙옙占쏙옙 占쌕삼옙占쏙옙)
        return "redirect:loginForm";
        
    }
 
    //회占쏙옙탈占쏙옙 占쏙옙占쏙옙占쏙옙  
    @RequestMapping("/deleteForm")
    public String deletePage() throws Exception{

    	return "sns/delForm";
    	
    }
   
    //회占쏙옙탈占쏙옙
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
    		model.addAttribute("msg1", "占쏙옙橘占싫ｏ옙占� 확占쏙옙占싹쇽옙占쏙옙.");
			return "sns/delForm";	
    	}
    	
    }

    //占싻쏙옙占쏙옙占쏙옙 찾占쏙옙 占쏙옙占쏙옙占쏙옙
    @RequestMapping("/pass")
	public String IntroPage1(Locale locale, Model model) throws Exception {

		return "sns/FindPassword"; 
		
	}
	
    //占쏙옙橘占싫� 찾占쏙옙
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
			model.addAttribute("msg1", "틀占싫쏙옙占싹댐옙.");
			return "sns/FindPassword";	
		}
		
	}
	
	//占쏙옙橘占싫� 占쏙옙占쏙옙
	@RequestMapping("/updatepassword") 
	public String UpdatePassword(JoinMember joinmember, Model model) throws Exception {
		
		joinmemberService.updatePassword(joinmember);

		return "sns/loginpage";
		
	}
	
	//占쏙옙占싱듸옙 占쌩븝옙占싯삼옙
	@RequestMapping("/CheckID")
	public String CheckID(JoinMember joinmember, Model model) throws Exception {

		int rtn1=joinmemberService.CheckID(joinmember);
		
		if(rtn1==0)
		{
			model.addAttribute("joinmember", joinmember);
			model.addAttribute("msg2", "this is ok");
			return "sns/JoinMembership"; 
		}
		else
		{	
			model.addAttribute("msg2", "there is already id.");
			return "sns/JoinMembership";	
		}
	}
	
	@RequestMapping("/findpeople")//移쒓뎄 李얘린
	public String FindPeople(JoinMember joinmember, Model model, HttpServletRequest req) throws Exception {

		List<JoinMember> peoplelist = joinmemberService.findPeople(joinmember);// 친구 목록 찾기 -- 나 제외 (status 2=신청중,3=수락대기 ,9 신청가능)
		model.addAttribute("joinmember", peoplelist);
		
		model.addAttribute("member_name", joinmember.getMember_name());//addfriend -> findpeople
		model.addAttribute("member_no", joinmember.getMember_no());
		model.addAttribute("msg", req.getParameter("msg")); //addfriend -> findpeople
		return "sns/PeopleList";

	}
	//친구 신청
	@RequestMapping("/addfriend")
	public String addfriend( Model model, Friends friends,JoinMember joinmember, HttpServletRequest req) throws Exception {
		joinmemberService.addfriend(friends);
		model.addAttribute("joinmember", joinmember);
		String msg = "add friend finish";
		return "redirect:findpeople?member_name="+req.getParameter("member_name")+"&member_no="+req.getParameter("member_no")+"&msg="+msg; //redirect member_name 怨� message �쟾�떖
	}
	// 移쒓뎄 �닔�씫
	@RequestMapping("/friendsList") 
	public String friendslist(Friends friends, Model model) throws Exception {
		List<Friends> friendslist = joinmemberService.selectfriends(friends);
		model.addAttribute("friends", friendslist);
		
		return "sns/FriendList";
	}
	//移쒓뎄 �닔�씫�븷 �뿬遺� �쁽�솴
	@RequestMapping("/allowfriends") 
	public String allowfriends(Friends friends, Model model) throws Exception {

		joinmemberService.allowfriends(friends);
		List<Friends> friendslist = joinmemberService.selectfriends(friends);
		model.addAttribute("friends", friendslist);
		return "sns/FriendList";
	}
	// 移쒓뎄 �떊泥��븳 �쁽�솴
	@RequestMapping("/request") 
	public String Request(Friends friends, Model model) throws Exception {
		
		List<Friends> re = joinmemberService.request(friends);
		model.addAttribute("friends", re);
		return "sns/Request";
	}
	//移쒓뎄 �떊泥� 痍⑥냼�븯湲�
	@RequestMapping("/cancelfriends") 
	public String cancelfriends(Friends friends, Model model) throws Exception {

		joinmemberService.cancelfriends(friends);
		List<Friends> re = joinmemberService.request(friends);
		model.addAttribute("friends", re);
	
		return "sns/Request";
	}
	//移쒓뎄議고쉶
	@RequestMapping("/myfriend") 
	public String Myfriend(Friends friends, Model model,HttpServletRequest req) throws Exception {
	

		List<JoinMember> my = joinmemberService.myfriend(friends);
		model.addAttribute("myfriend", my);
		
		model.addAttribute("msg1", req.getParameter("msg1"));
		model.addAttribute("user1", friends.getUser1());
		
		return "sns/Myfriend";
	}	
	//移쒓뎄�걡湲�
	@RequestMapping("/stopfriend") 
	public String Stopfriend(Friends friends, Model model,HttpServletRequest req) throws Exception {
	
		joinmemberService.stopfriend(friends);
		String msg1 = "friend remove finish";
	
		return "redirect:myfriend?user1="+req.getParameter("user1")+"&msg1="+msg1;
	}	
	
	//게시물 작성
		@RequestMapping("/writeBoard")
		public String board(JoinMember joinmember, Board board_contents, HttpSession session, Model model) throws Exception {
			
			model.addAttribute("joinmember", joinmember);
			JoinMember sessionMember = (JoinMember)session.getAttribute("userLoginInfo");
			board_contents.setBoard_writer(sessionMember.getMember_id());
			joinmemberService.insertBoardContent(board_contents);
			
			return "redirect:goMain";
			
		}

		//게시글 삭제
		@RequestMapping("/deleteBoardContent")
	    public String deleteBoardContent(Board board, Model model, HttpSession session) throws Exception{
			
			joinmemberService.removeBoardContent(board);
			
			return "redirect:goMain";
			
	    }
}

