package com.manage.biz.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.manage.biz.vo.JoinMember;
import com.manage.biz.vo.Friends;


@Repository
public class JoinMemberDaoImpl implements JoinMemberDao{
	
	@Autowired
	SqlSessionTemplate sqlSession;

	/*ȸ������ */
	public int insertJoinMember(JoinMember insert_member) throws Exception{
		sqlSession.insert("JoinMemberDao.insertMember", insert_member);
		int m_seq = insert_member.getMember_no();
		return m_seq;
	}
	
	public JoinMember selectJoinMember(String member_id) throws Exception{
		return sqlSession.selectOne("JoinMemberDao.JoinMember", member_id);
	}
	
	/*�α��� ó��*/
	public JoinMember findByUserIdAndPassword(String userId, String password) throws Exception{
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("member_id", userId);
        paramMap.put("member_password", password);

        return sqlSession.selectOne("JoinMemberDao.selectLoginUser", paramMap);
	}
	
	/*ȸ��Ż��*/
	public JoinMember deleteMemeber(JoinMember member) throws Exception{
		return sqlSession.selectOne("JoinMemberDao.deleteMember", member);
	}
	
	/*��й�ȣ ã��*/
	public int findPassword(JoinMember joinmember) throws Exception{
		int m_password = sqlSession.selectOne("JoinMemberDao.selectFind", joinmember);
		return m_password;
	}
	
	/*��й�ȣ ����*/
	public void updatePassword(JoinMember joinmember) throws Exception{
		sqlSession.update("JoinMemberDao.UpdatePassword", joinmember);
	}

	/*���̵� ��й�ȣ ��ġ ����*/
	public int matching(JoinMember joinmember) throws Exception{
		int matching_ok = sqlSession.selectOne("JoinMemberDao.matching", joinmember);
		return matching_ok;
	}
	
	/*���̵� �ߺ��˻�*/
	public int CheckID(JoinMember joinmember) throws Exception{
		int m_id = sqlSession.selectOne("JoinMemberDao.selectCheckID", joinmember);
		return m_id;
	}	
	public List<JoinMember> findPeople(JoinMember joinmember) throws Exception{
		System.out.println("dao list");
		List<JoinMember> peoplelist = sqlSession.selectList("JoinMemberDao.findPeople", joinmember);
		return peoplelist;
	}
	
	public List<JoinMember> myfriend(Friends friends) throws Exception{
	
		List<JoinMember> my = sqlSession.selectList("JoinMemberDao.myfriend", friends);
		return my;
	}
	
	public int addfriend(Friends friends) throws Exception{
		int m_friend = sqlSession.insert("JoinMemberDao.addfriend", friends);
		return m_friend ;
	}
	public int addfriend2(Friends friends) throws Exception{
		return sqlSession.insert("JoinMemberDao.addfriend2", friends);
	}
	public List<Friends> selectfriends() throws Exception{
		List<Friends> friendslist = sqlSession.selectList("JoinMemberDao.selectfriends");
		return friendslist;
	}
	public void allowfriends(Friends friends) throws Exception{
		sqlSession.update("JoinMemberDao.allowfriends", friends);
	}

	
}
