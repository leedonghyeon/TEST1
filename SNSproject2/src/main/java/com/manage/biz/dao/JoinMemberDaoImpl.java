package com.manage.biz.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.manage.biz.vo.JoinMember;
import com.manage.biz.vo.Board;
import com.manage.biz.vo.Friends;


@Repository
public class JoinMemberDaoImpl implements JoinMemberDao{
	
	@Autowired
	SqlSessionTemplate sqlSession;

	/*�쉶�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 */
	public int insertJoinMember(JoinMember insert_member) throws Exception{
		sqlSession.insert("JoinMemberDao.insertMember", insert_member);
		int m_seq = insert_member.getMember_no();
		return m_seq;
	}
	
	public void updateUserInfo(JoinMember joinmember) throws Exception{
		System.out.println(joinmember.getMember_id());
		System.out.println(joinmember.getMember_password());
		sqlSession.update("JoinMemberDao.UpdateUserInfo", joinmember);
	}
	
	public JoinMember selectJoinMember(String member_id) throws Exception{
		return sqlSession.selectOne("JoinMemberDao.JoinMember", member_id);
	}
	
	/*�뜝�떥源띿삕�뜝�룞�삕 泥섇뜝�룞�삕*/
	public JoinMember findByUserIdAndPassword(String userId, String password) throws Exception{
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("member_id", userId);
        paramMap.put("member_password", password);

        return sqlSession.selectOne("JoinMemberDao.selectLoginUser", paramMap);
	}
	
	/*�쉶�뜝�룞�삕�깉�뜝�룞�삕*/
	public JoinMember deleteMemeber(JoinMember member) throws Exception{
		return sqlSession.selectOne("JoinMemberDao.deleteMember", member);
	}
	
	/*�뜝�룞�삕艅섇뜝�떕占� 李얍뜝�룞�삕*/
	public int findPassword(JoinMember joinmember) throws Exception{
		int m_password = sqlSession.selectOne("JoinMemberDao.selectFind", joinmember);
		return m_password;
	}
	
	/*�뜝�룞�삕艅섇뜝�떕占� �뜝�룞�삕�뜝�룞�삕*/
	public void updatePassword(JoinMember joinmember) throws Exception{
		sqlSession.update("JoinMemberDao.UpdatePassword", joinmember);
	}

	/*�뜝�룞�삕�뜝�떛�벝�삕 �뜝�룞�삕艅섇뜝�떕占� �뜝�룞�삕移� �뜝�룞�삕�뜝�룞�삕*/
	public int matching(JoinMember joinmember) throws Exception{
		int matching_ok = sqlSession.selectOne("JoinMemberDao.matching", joinmember);
		return matching_ok;
	}
	
	/*�뜝�룞�삕�뜝�떛�벝�삕 �뜝�뙥釉앹삕�뜝�떙�궪�삕*/
	public int CheckID(JoinMember joinmember) throws Exception{
		int m_id = sqlSession.selectOne("JoinMemberDao.selectCheckID", joinmember);
		return m_id;
	}	
	public List<JoinMember> findPeople(JoinMember joinmember) throws Exception{
		List<JoinMember> peoplelist = sqlSession.selectList("JoinMemberDao.findPeople", joinmember);
		return peoplelist;
	}
	
	public List<JoinMember> myfriend(Friends friends) throws Exception{
	
		List<JoinMember> my = sqlSession.selectList("JoinMemberDao.myfriend", friends);
		return my;
	}
	
	public void addfriend(Friends friends) throws Exception{
		sqlSession.insert("JoinMemberDao.addfriend", friends);
	}
	public void addfriend2(Friends friends) throws Exception{
		sqlSession.insert("JoinMemberDao.addfriend2", friends);
	}
	public List<Friends> selectfriends(Friends friends) throws Exception{
		List<Friends> friendslist = sqlSession.selectList("JoinMemberDao.selectfriends",friends);
		return friendslist;
	}
	public List<Friends> request(Friends friends) throws Exception{
		List<Friends> re = sqlSession.selectList("JoinMemberDao.request",friends);
		return re;
	}
	public void allowfriends(Friends friends) throws Exception{
		sqlSession.update("JoinMemberDao.allowfriends", friends);
	}
	public void cancelfriends(Friends friends) throws Exception{
		sqlSession.delete("JoinMemberDao.cancelfriends", friends);
	}
	public void stopfriend(Friends friends) throws Exception{
		sqlSession.delete("JoinMemberDao.stopfriend", friends);
	}
	public String insertBoardContent(Board board_contents) throws Exception{
		sqlSession.insert("JoinMemberDao.insertBoardContent", board_contents);
		String b_seq = board_contents.getBno();
		return b_seq;
	} 
	
	/*占쌉시깍옙 占쏙옙회*/
	public List<Board> listBoardContents(JoinMember joinmember) throws Exception{
		List<Board> board_contents_list = sqlSession.selectList("JoinMemberDao.selectBoardContent", joinmember);
		return board_contents_list;
	}
	
	/*占쌉시뱄옙 占쏙옙占쏙옙*/
	public Board deleteBoardContent(Board board) throws Exception{
		return sqlSession.selectOne("JoinMemberDao.deleteBoardContent", board);
	}
	
}
