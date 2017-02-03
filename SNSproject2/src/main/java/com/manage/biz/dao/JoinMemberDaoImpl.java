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

	/*회占쏙옙占쏙옙占쏙옙 */
	public int insertJoinMember(JoinMember insert_member) throws Exception{
		sqlSession.insert("JoinMemberDao.insertMember", insert_member);
		int m_seq = insert_member.getMember_no();
		return m_seq;
	}
	
	public JoinMember selectJoinMember(String member_id) throws Exception{
		return sqlSession.selectOne("JoinMemberDao.JoinMember", member_id);
	}
	
	/*占싸깍옙占쏙옙 처占쏙옙*/
	public JoinMember findByUserIdAndPassword(String userId, String password) throws Exception{
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("member_id", userId);
        paramMap.put("member_password", password);

        return sqlSession.selectOne("JoinMemberDao.selectLoginUser", paramMap);
	}
	
	/*회占쏙옙탈占쏙옙*/
	public JoinMember deleteMemeber(JoinMember member) throws Exception{
		return sqlSession.selectOne("JoinMemberDao.deleteMember", member);
	}
	
	/*占쏙옙橘占싫� 찾占쏙옙*/
	public int findPassword(JoinMember joinmember) throws Exception{
		int m_password = sqlSession.selectOne("JoinMemberDao.selectFind", joinmember);
		return m_password;
	}
	
	/*占쏙옙橘占싫� 占쏙옙占쏙옙*/
	public void updatePassword(JoinMember joinmember) throws Exception{
		sqlSession.update("JoinMemberDao.UpdatePassword", joinmember);
	}

	/*占쏙옙占싱듸옙 占쏙옙橘占싫� 占쏙옙치 占쏙옙占쏙옙*/
	public int matching(JoinMember joinmember) throws Exception{
		int matching_ok = sqlSession.selectOne("JoinMemberDao.matching", joinmember);
		return matching_ok;
	}
	
	/*占쏙옙占싱듸옙 占쌩븝옙占싯삼옙*/
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

	
}
