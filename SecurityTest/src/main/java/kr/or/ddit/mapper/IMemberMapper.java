package kr.or.ddit.mapper;

import kr.or.ddit.vo.CrudMember;

public interface IMemberMapper {
	public CrudMember readByUserId(String username);
}
