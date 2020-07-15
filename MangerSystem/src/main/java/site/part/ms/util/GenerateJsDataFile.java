package site.part.ms.util;

import java.awt.geom.Area;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 该类用于将数据写入到js文件中去
 * @author ZHP
 *
 */
public class GenerateJsDataFile {
	private  String FILENAME="generatejs.js";
	private final String MethodPrefix="get";
	/**
	 * 获得输出流
	 * @param dataobj
	 * @param filename
	 * @return
	 */
	public OutputStream getJavaScript(Object dataobj,String filename) {
		if(filename!=null) {
			this.FILENAME=filename;
		}
		FileOutputStream fos=null;
		FileChannel fosc=null;
		try {
			fos=new FileOutputStream(this.FILENAME);
			fosc=fos.getChannel();
			String text=JsText(dataobj).toString();
			ByteBuffer byteBuffer=Charset.forName("utf-8").encode(text);
			int len=0;
			while((len=fosc.write(byteBuffer))!=0) {
				System.out.println("file length have written! "+len);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
//			GennerallyUtil.closeOutputStream(fos);
			if(fosc!=null) {
				try {
					fosc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return fos;
	}
	/**
	 * 读取对象中的数据，整合为js代码
	 * @param dataobj
	 * @return
	 */
	public StringBuffer JsText(Object dataobj) {
		StringBuffer jsContents=new StringBuffer();
		List<String> fieldNames=new LinkedList<String>();
		jsContents.append("_$data={");
		Class<?> clazz=dataobj.getClass();
		Field[] fields=clazz.getDeclaredFields();
		for(Field field:fields) {
			field.setAccessible(true);
			String fieldName=field.getName();
			fieldNames.add(fieldName);
		}
		Method[] methods=clazz.getDeclaredMethods();
		for(Method method:methods) {
			String fn=getFieldGetMethod(method, fieldNames);
			if(fn!=null) {
				try {
					Class<?> returnType=method.getReturnType();
					Object returnValue=method.invoke(dataobj, null);
					jsContents.append(fn+":");
					if(returnType==String.class) {						
						jsContents.append("\""+returnValue+"\",");
					}else if(returnType==int.class||returnType==Integer.class||returnType==float.class||returnType==Float.class){
						
					}else {						
						jsContents.append(returnValue+",");
					}
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					System.out.println("调用get方法出错");
					e.printStackTrace();
				}
			}
		}
		jsContents.deleteCharAt(jsContents.length()-1);
		jsContents.append("}");
		return jsContents;
	}
	public StringBuffer getObjectStr(Class<?> returnType,Method method,Object orgObj) throws Exception {
		StringBuffer sb=new StringBuffer();
		if(returnType==String.class) {
			
		}else if(returnType==int.class||returnType==Integer.class){
			
		}else if(returnType==float.class||returnType==Float.class) {
			
		}else if(returnType==double.class||returnType==Double.class) {
			
		}else if(returnType==byte.class||returnType==Byte.class) {
			
		}else if(returnType==char.class||returnType==Character.class) {
			
		}else if(returnType==short.class||returnType==Short.class) {
			
		}else if(returnType==long.class||returnType==Long.class) {
			
		}else if(returnType==boolean.class||returnType==Boolean.class) {
			
		} /*
			 * else if(returnType.newInstance() instanceof List) { List l=(List)
			 * method.invoke(orgObj, null); }
			 */
		else if(returnType.newInstance() instanceof Map) {
			Map m=(Map)method.invoke(orgObj, null);
		}else if(returnType.newInstance() instanceof Collection) {
			Collection c=(Collection)method.invoke(orgObj, null);
		}else {
			JsText(orgObj);
		}
		return sb;
	}
	/**
	 * 获取方法对应的fieldname,没有则返回null
	 * @param method
	 * @param fieldNames
	 * @return
	 */
	private String getFieldGetMethod(Method method,List<String> fieldNames) {
		for(String name:fieldNames) {
			String methodName=method.getName();
			if(methodName.equalsIgnoreCase(MethodPrefix+name)) {
				return name;
			}
		}
		return null;
	}
}
