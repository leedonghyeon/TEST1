package com.manage.biz.dao;

import java.util.List;

import com.manage.biz.vo.JoinMember;
import com.manage.biz.vo.Friends;


public interface JoinMemberDao {

	int insertJoinMember(JoinMember insert_member) throws Exception; //ȸ������ 
	JoinMember selectJoinMember(String member_id) throws Exception;
    JoinMember findByUserIdAndPassword(String userId, String password) throws Exception; //�α���
    JoinMember deleteMemeber(JoinMember member) throws Exception; //ȸ��Ż��
    int findPassword(JoinMember joinmember) throws Exception; //��й�ȣ ã��
    void updatePassword(JoinMember joinmember) throws Exception; //��й�ȣ ����
    int matching(JoinMember joinmember) throws Exception; //���̵� �н����� ��ġ ���� 
    int CheckID(JoinMember joinmember) throws Exception; //���̵� �ߺ� �˻� 
    List<JoinMember> findPeople(JoinMember joinmember) throws Exception;
    int addfriend(Friends friends) throws Exception; 
    List<Friends> selectfriends() throws Exception; 
    void allowfriends(Friends friends) throws Exception; 
}
