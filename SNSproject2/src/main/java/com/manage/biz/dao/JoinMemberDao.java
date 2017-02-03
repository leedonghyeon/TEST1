package com.manage.biz.dao;

import java.util.List;

import com.manage.biz.vo.JoinMember;
import com.manage.biz.vo.Board;
import com.manage.biz.vo.Friends;


public interface JoinMemberDao {

	int insertJoinMember(JoinMember insert_member) throws Exception; //회占쏙옙占쏙옙占쏙옙 
	void updateUserInfo(JoinMember joinmember) throws Exception;
	JoinMember selectJoinMember(String member_id) throws Exception;
    JoinMember findByUserIdAndPassword(String userId, String password) throws Exception; //占싸깍옙占쏙옙
    JoinMember deleteMemeber(JoinMember member) throws Exception; //회占쏙옙탈占쏙옙
    int findPassword(JoinMember joinmember) throws Exception; //占쏙옙橘占싫� 찾占쏙옙
    void updatePassword(JoinMember joinmember) throws Exception; //占쏙옙橘占싫� 占쏙옙占쏙옙
    int matching(JoinMember joinmember) throws Exception; //占쏙옙占싱듸옙 占싻쏙옙占쏙옙占쏙옙 占쏙옙치 占쏙옙占쏙옙 
    int CheckID(JoinMember joinmember) throws Exception; //占쏙옙占싱듸옙 占쌩븝옙 占싯삼옙 
    List<JoinMember> findPeople(JoinMember joinmember) throws Exception;
    List<JoinMember> myfriend(Friends friends) throws Exception;
    void addfriend(Friends friends) throws Exception; 
    void addfriend2(Friends friends) throws Exception; 
    List<Friends> selectfriends(Friends friends) throws Exception; 
    List<Friends> request(Friends friends) throws Exception; 
    void allowfriends(Friends friends) throws Exception; 
    void cancelfriends(Friends friends) throws Exception; 
    void stopfriend(Friends friends) throws Exception; 
    int insertBoardContent(Board board_contents) throws Exception; //�Խñ� �ۼ�
    List<Board> listBoardContents(JoinMember joinmember) throws Exception; //�Խñ� �ۼ�
    Board deleteBoardContent(Board board) throws Exception; //�Խù� ����
}
