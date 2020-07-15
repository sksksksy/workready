package site.part.ms;

import site.part.ms.entity.User;
import site.part.ms.util.GenerateJsDataFile;
import site.part.ms.util.MSSystemStatus;

import java.util.*;

public class mytest {
	public static void main(String[] args) {
		mytest m=new mytest();
		m.generateJs();
	}
	void generateJs() {
		System.out.println(Collection.class.isAssignableFrom(List.class));
		/*User user=new User();
		user.setUserId("jjjjjjj");
		user.setUserName("youname");
		user.setUserCode("10038");
		user.setStatus(MSSystemStatus.OUT_LINE.Val());
		user.setPassword("123456");
		user.setEmplyeeNo("10086");*/
		GenerateJsDataFile gjdf=new GenerateJsDataFile();
		/*String re=gjdf.JsText(user).toString();
		System.out.println(re);*/
		Ts t=new Ts();
		List<String> list=new LinkedList<>();
		list.add("apple");
		list.add("pear");
		t.setName("zhouyanyu");
		t.setAge(18);
		t.setAihao(list);
		Map<String,String> m=new HashMap<>();
		m.put("shenggao","170");
		m.put("address","chongqing");
		t.setData(m);
		Jineng jn=new Jineng();
		jn.setId("10086");
		jn.setJname("bike");
		t.setJineng(jn);
		String r=gjdf.JsText(t).toString();
		System.out.println(r);

	}
}
class Ts{
	private String name;
	private int age;
	private List<String> aihao;
	private Map<String,String> data;
	private Jineng jineng;

	public Ts() {
	}

	public Ts(String name, int age, List<String> aihao, Map<String, String> data, Jineng jineng) {
		this.name = name;
		this.age = age;
		this.aihao = aihao;
		this.data = data;
		this.jineng = jineng;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getAihao() {
		return aihao;
	}

	public void setAihao(List<String> aihao) {
		this.aihao = aihao;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}

	public Jineng getJineng() {
		return jineng;
	}

	public void setJineng(Jineng jineng) {
		this.jineng = jineng;
	}
}
class Jineng{
	private String id;
	private String jname;

	public Jineng() {
	}

	public Jineng(String id, String jname) {
		this.id = id;
		this.jname = jname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}
}