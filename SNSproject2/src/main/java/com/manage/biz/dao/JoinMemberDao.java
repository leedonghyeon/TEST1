package com.manage.biz.dao;

import java.util.List;

import com.manage.biz.vo.JoinMember;
import com.manage.biz.vo.Board;
import com.manage.biz.vo.Friends;


public interface JoinMemberDao {

	int insertJoinMember(JoinMember insert_member) throws Exception; //�쉶�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 
	void updateUserInfo(JoinMember joinmember) throws Exception;
	JoinMember selectJoinMember(String member_id) throws Exception;
    JoinMember findByUserIdAndPassword(String userId, String password) throws Exception; //�뜝�떥源띿삕�뜝�룞�삕
    JoinMember deleteMemeber(JoinMember member) throws Exception; //�쉶�뜝�룞�삕�깉�뜝�룞�삕
    int findPassword(JoinMember joinmember) throws Exception; //�뜝�룞�삕艅섇뜝�떕占� 李얍뜝�룞�삕
    void updatePassword(JoinMember joinmember) throws Exception; //�뜝�룞�삕艅섇뜝�떕占� �뜝�룞�삕�뜝�룞�삕
    int matching(JoinMember joinmember) throws Exception; //�뜝�룞�삕�뜝�떛�벝�삕 �뜝�떩�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕移� �뜝�룞�삕�뜝�룞�삕 
    int CheckID(JoinMember joinmember) throws Exception; //�뜝�룞�삕�뜝�떛�벝�삕 �뜝�뙥釉앹삕 �뜝�떙�궪�삕 
    List<JoinMember> findPeople(JoinMember joinmember) throws Exception;
    List<JoinMember> myfriend(Friends friends) throws Exception;
    void addfriend(Friends friends) throws Exception; 
    void addfriend2(Friends friends) throws Exception; 
    List<Friends> selectfriends(Friends friends) throws Exception; 
    List<Friends> request(Friends friends) throws Exception; 
    void allowfriends(Friends friends) throws Exception; 
    void cancelfriends(Friends friends) throws Exception; 
    void stopfriend(Friends friends) throws Exception; 
    String insertBoardContent(Board board_contents) throws Exception; //占쌉시깍옙 占쌜쇽옙
    List<Board> listBoardContents(JoinMember joinmember) throws Exception; //占쌉시깍옙 占쌜쇽옙
    Board deleteBoardContent(Board board) throws Exception; //占쌉시뱄옙 占쏙옙占쏙옙
}
