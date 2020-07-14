package site.part.ms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectSerialize {
	/**
	 * 序列化
	 * @param obj
	 * @param filepath-保存路径，包含文件名
	 */
	public void duplicate(Serializable obj,String filepath) {
		ObjectOutputStream oos=null;
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(filepath);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(obj);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			GennerallyUtil.closeOutputStream(oos);
			GennerallyUtil.closeOutputStream(fos);
		}
	}
	/**
	 * 反序列化
	 * @param filepath 保存路径，包含文件名
	 * @return
	 */
	public Object Rduplicate(String filepath) {
		File f=new File(filepath);
		ObjectInputStream ois=null;
		FileInputStream fis=null;
		Object r=null;
		try {
			fis=new FileInputStream(f);
			ois=new ObjectInputStream(fis);
			r=ois.readObject();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			GennerallyUtil.closeInputStream(ois);
			GennerallyUtil.closeInputStream(fis);
		}
		return r;
	}
	
}
