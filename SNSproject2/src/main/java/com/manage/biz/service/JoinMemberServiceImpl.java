package com.manage.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manage.biz.dao.JoinMemberDao;
import com.manage.biz.vo.JoinMember;
import com.manage.biz.vo.Board;
import com.manage.biz.vo.Friends;


@Service
public class JoinMemberServiceImpl implements JoinMemberService{
	@Autowired
	private JoinMemberDao joinmemberDao;
	
	//회占쏙옙占쏙옙占쏙옙
	public int insertJoinMember(JoinMember joinmember) throws Exception{
		int m_seq =  joinmemberDao.insertJoinMember(joinmember);
		return m_seq;
	}
	
	public void updateUserInfo(JoinMember joinmember) throws Exception{
		joinmemberDao.updateUserInfo(joinmember);
	}
	
	public JoinMember getAllMember(String member_id) throws Exception{
		return joinmemberDao.selectJoinMember(member_id);
	}

	//占싸깍옙占쏙옙 처占쏙옙
    public JoinMember findByUserIdAndPassword(String userId, String password) throws Exception{
		return joinmemberDao.findByUserIdAndPassword(userId, password);
	}
    
    //회占쏙옙탈占쏙옙
    public JoinMember removeMember(JoinMember member) throws Exception{
    	return joinmemberDao.deleteMemeber(member);
    }
    
    //占쏙옙橘占싫� 찾占쏙옙
    public int findPassword(JoinMember joinmember)throws Exception{
    	int m_password = joinmemberDao.findPassword(joinmember);
    	return m_password;
    }
    
    //占쏙옙橘占싫� 占쏙옙占쏙옙
    public void updatePassword(JoinMember joinmember) throws Exception{
    	joinmemberDao.updatePassword(joinmember);
    }
    
    //占쏙옙占싱듸옙 占싻쏙옙占쏙옙占쏙옙 占쏙옙치占쏙옙占쏙옙
    public int matching(JoinMember joinmember) throws Exception {
    	int matching_ok = joinmemberDao.matching(joinmember);
    	return matching_ok;
    }
    
    //占쏙옙占싱듸옙 占쌩븝옙占싯삼옙
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
    
	public void addfriend(Friends friends) throws Exception{
		joinmemberDao.addfriend(friends);
		joinmemberDao.addfriend2(friends);
	}

    public List<Friends> selectfriends(Friends friends) throws Exception{
    	List<Friends> friendslist= joinmemberDao.selectfriends(friends);
    	return friendslist;

    }
    public List<Friends> request(Friends friends) throws Exception{
 
    	List<Friends> re= joinmemberDao.request(friends);
    	return re;
    }
    
    public void allowfriends(Friends friends) throws Exception{
    	joinmemberDao.allowfriends(friends);
    }
    public void cancelfriends(Friends friends) throws Exception{
    	joinmemberDao.cancelfriends(friends);
    }
    public void stopfriend(Friends friends) throws Exception{
    	joinmemberDao.stopfriend(friends);
    }
    public int insertBoardContent(Board board_contents) throws Exception{
    	int b_seq =  joinmemberDao.insertBoardContent(board_contents);
		return b_seq;
    }

    //�Խñ� ��ȸ
    public List<Board> listBoardContents(JoinMember joinmember) throws Exception{
    	List<Board> board_contents_list = joinmemberDao.listBoardContents(joinmember);
    	return board_contents_list;
    }
    
    //�Խù� ����
    public Board removeBoardContent(Board board_num) throws Exception{
    	return joinmemberDao.deleteBoardContent(board_num);
    }

}