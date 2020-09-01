package site.part.ms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import site.part.ms.entity.User;
import site.part.ms.struct.FileNode;
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
		String re=gjdf.JsonText(user).toString();
		System.out.println(re);


		FileNode root=new FileNode("Root");
		root.append(new FileNode("子目录一"));
		root.append(new FileNode("子目录二"));
		FileNode f=new FileNode("子目录三");
		root.append(f);
		f.append(new FileNode("子目录"));

	}
}
