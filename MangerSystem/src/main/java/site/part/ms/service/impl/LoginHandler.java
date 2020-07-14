package site.part.ms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.part.ms.entity.User;
import site.part.ms.mapper.UserMapper;
import site.part.ms.resp.MSResponseStatus;
import site.part.ms.resp.MSResponseStatus.MsStatus;
import site.part.ms.service.LoginAdapter;
import site.part.ms.util.MSSystemStatus;

@Service
public class LoginHandler implements LoginAdapter {
	@Autowired
	UserMapper userMapper;
	@Override
	public MSResponseStatus loginIn(User user) {
		MSResponseStatus msrs=new MSResponseStatus();
		int r=userMapper.login(user);
		if(r<1) {
			msrs.setMsg("登录名或密码错误");
			msrs.setStatusCode(MsStatus.LOGIN_ERROR);
			msrs.setData(null);
		}else if(r==1) {
			msrs.setMsg("登录成功");
			msrs.setStatusCode(MsStatus.SUCCESSFUL);
			msrs.setData(null);
			user.setStatus(MSSystemStatus.ON_LINE.Val());//修改为在线
			userMapper.updateLoginStatus(user);
		}
		return msrs;
	}

	@Override
	public MSResponseStatus loginOut(User user) {
		user.setStatus(MSSystemStatus.OUT_LINE.Val());//修改为离线
		userMapper.updateLoginStatus(user);
		return null;
	}

}
