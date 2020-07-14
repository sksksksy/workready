package site.part.ms.service;

import site.part.ms.entity.User;
import site.part.ms.resp.MSResponseStatus;

public interface LoginAdapter {
	default boolean isLogin(User user) {return false;};
	public MSResponseStatus loginIn(User user);
	public MSResponseStatus loginOut(User user);
}
