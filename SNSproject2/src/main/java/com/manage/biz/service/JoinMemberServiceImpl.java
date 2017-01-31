package com.manage.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.biz.dao.JoinMemberDao;
import com.manage.biz.vo.JoinMember;
import com.manage.biz.vo.Friends;


@Service
public class JoinMemberServiceImpl implements JoinMemberService{
	@Autowired
	private JoinMemberDao joinmemberDao;
	
	//ȸ������
	public int insertJoinMember(JoinMember joinmember) throws Exception{
		int m_seq =  joinmemberDao.insertJoinMember(joinmember);
		return m_seq;
	}
	
	public JoinMember getAllMember(String member_id) throws Exception{
		return joinmemberDao.selectJoinMember(member_id);
	}

	//�α��� ó��
    public JoinMember findByUserIdAndPassword(String userId, String password) throws Exception{
		return joinmemberDao.findByUserIdAndPassword(userId, password);
	}
    
    //ȸ��Ż��
    public JoinMember removeMember(JoinMember member) throws Exception{
    	return joinmemberDao.deleteMemeber(member);
    }
    
    //��й�ȣ ã��
    public int findPassword(JoinMember joinmember)throws Exception{
    	int m_password = joinmemberDao.findPassword(joinmember);
    	return m_password;
    }
    
    //��й�ȣ ����
    public void updatePassword(JoinMember joinmember) throws Exception{
    	joinmemberDao.updatePassword(joinmember);
    }
    
    //���̵� �н����� ��ġ����
    public int matching(JoinMember joinmember) throws Exception {
    	int matching_ok = joinmemberDao.matching(joinmember);
    	return matching_ok;
    }
    
    //���̵� �ߺ��˻�
    public int CheckID(JoinMember joinmember)throws Exception{
    	
    	int m_id = joinmemberDao.CheckID(joinmember);
    	return m_id;
    }
    public List<JoinMember> findPeople(JoinMember joinmember) throws Exception{
    	List<JoinMember> peoplelist = joinmemberDao.findPeople(joinmember);
    	return peoplelist;
	}
    public List<JoinMember> myfriend(Friends friends) throws Exception{
    	List<JoinMember> my = joinmemberDao.myfriend(friends);
    	return my;
	}
    
	public int addfriend(Friends friends) throws Exception{
		int m_friend =  joinmemberDao.addfriend(friends);
		return m_friend;
	}
	public int addfriend2(Friends friends) throws Exception{
		return joinmemberDao.addfriend2(friends);

	}
    public List<Friends> selectfriends() throws Exception{
    	List<Friends> friendslist= joinmemberDao.selectfriends();
    	return friendslist;
    }
    public void allowfriends(Friends friends) throws Exception{
    	joinmemberDao.allowfriends(friends);
    }

}