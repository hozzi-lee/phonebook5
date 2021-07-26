package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// insert2
	public int insert2(String name, String hp, String company) {
		// personVo에 필드값이 있을경우
		// PersonVo personVo = new PersonVo(name, hp, company);
		
		// map을 사용해서 데이터를 묶는다
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("name", name);
		personMap.put("hp", hp);
		personMap.put("company", company);
		
		int count = sqlSession.insert("phonebook.insert2", personMap);
		
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
	
	// selectOne - 2
	public Map<String, Object> personInfo2(int personID) {
		Map<String, Object> personMap = sqlSession.selectOne("phonebook.personInfo2", personID);
//		System.out.println(personMap);
//		System.out.println(personMap.get("PERSON_ID"));
		
		return personMap;
	}
	
	// update
	public int update(PersonVo personVo) {
		int count = sqlSession.update("phonebook.update", personVo);
		
		return count;
	}

}
