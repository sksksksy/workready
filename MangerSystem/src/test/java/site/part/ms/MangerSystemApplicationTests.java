package site.part.ms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import site.part.ms.entity.User;
import site.part.ms.util.GenerateJsDataFile;
import site.part.ms.util.MSSystemStatus;

@SpringBootTest
class MangerSystemApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void generateJs() {
		User user=new User();
		user.setUserId("jjjjjjj");
		user.setUserName("youname");
		user.setUserCode("10038");
		user.setStatus(MSSystemStatus.OUT_LINE.Val());
		user.setPassword("123456");
		user.setEmplyeeNo("10086");
		GenerateJsDataFile gjdf=new GenerateJsDataFile();
		String re=gjdf.JsText(user).toString();
		System.out.println(re);
	}
}
