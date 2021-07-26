package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// selectList
	public List<PersonVo> getList() {
		List<PersonVo> pList = sqlSession.selectList("phonebook.getList");

		return pList;
	}
	
	// insert
	public int insert(PersonVo personVo) {
		int count = sqlSession.insert("phonebook.insert", personVo);
		
		return count;
	}
	
	// delete
	public int delete(int personID) {
		int count = sqlSession.delete("phonebook.delete", personID);
		
		return count;
	}
	
	// selectOne
	public PersonVo personInfo(int personID) {
		PersonVo personInfo = sqlSession.selectOne("phonebook.personInfo", personID);
		
		return personInfo;
	}
	
	// update
	public int update(PersonVo personVo) {
		int count = sqlSession.update("phonebook.update", personVo);
		
		return count;
	}

}
