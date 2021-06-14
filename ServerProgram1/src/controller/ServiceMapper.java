package controller;

import command.DeletePage;
import command.JoinPage;
import command.LoginPage;

import command.MemberService;
import command.UpdatePage;

public class ServiceMapper {
	private static ServiceMapper instance = new ServiceMapper();
	private ServiceMapper() {}
	public static ServiceMapper getInstance() {
		if (instance == null) {
			instance = new ServiceMapper();
		}
		return instance;
	}
	public MemberService serviceMemberMapper(String cmd) {
		MemberService command = null;
		switch(cmd) {
		case "loginPage.do":
			command = new LoginPage();
			break;
		case "join.do":
			command= new JoinPage();
			break;
		case "delete.do":
			command= new DeletePage();
			break;
		case "update.do":
			command= new UpdatePage();
			break;
		}
		return command;
	}
}
