package com.tddair;

import java.util.HashMap;
import java.util.Map;

import com.tddair.exception.MemberException;

public class MemberDao {
	private Map<String, Member> members = new HashMap<>();

	public MemberDao() {
	}

	public void register(String username, String email) throws MemberException {
		if (null != lookup(username)) {
			throw new MemberException("username already exists");
		}
		
		if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
			throw new MemberException("Invalid Email");
		}
		
		Member member = new Member(username, email);
		
		members.put(username, member);
	}

	public Member lookup(String username) {
		return members.get(username);
	}
}
