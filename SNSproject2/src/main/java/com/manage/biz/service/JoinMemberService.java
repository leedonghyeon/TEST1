package com.manage.biz.service;


import java.util.List;

import com.manage.biz.vo.JoinMember;
import com.manage.biz.vo.Friends;

public interface JoinMemberService {
	int insertJoinMember(JoinMember joinmember) throws Exception; //ȸ������
	JoinMember getAllMember(String member_id) throws Exception;
	JoinMember findByUserIdAndPassword(String userId, String password) throws Exception; //�α���	
	JoinMember removeMember(JoinMember member) throws Exception; //ȸ��Ż��
	int findPassword(JoinMember joinmember) throws Exception; //��й�ȣ ã��
	void updatePassword(JoinMember joinmember) throws Exception; //��й�ȣ ����
	int matching(JoinMember joinmember) throws Exception; //���̵� �н����� ��ġ ���� 
	int CheckID(JoinMember joinmember) throws Exception; //���̵� �ߺ��˻�
	List<JoinMember> findPeople(JoinMember joinmember) throws Exception;
	List<JoinMember> myfriend(Friends friends) throws Exception;
	int addfriend(Friends friends) throws Exception;
	List<Friends> selectfriends(Friends friends) throws Exception;
	void allowfriends(Friends friends) throws Exception;
	void stopfriend(Friends friends) throws Exception;
}
