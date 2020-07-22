package site.part.ms.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
			String text=JsonText(dataobj).toString();
			ByteBuffer byteBuffer=Charset.forName("utf-8").encode("_$data={"+text+"}");
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
	public StringBuffer JsonText(Object dataobj) {
		StringBuffer jsContents=new StringBuffer();
		jsContents.append("{");
		List<String> fieldNames=new LinkedList<String>();
		Class<?> clazz=dataobj.getClass();
		Field[] fields=clazz.getDeclaredFields();
		for(Field field:fields) {
			field.setAccessible(true);
			String fieldName=field.getName();
			fieldNames.add(fieldName);
		}
		Method[] methods=clazz.getDeclaredMethods();
		for(Method method:methods) {
			method.setAccessible(true);
			String fn=getFieldGetMethod(method, fieldNames);
			if(fn!=null) {
				try {
					Class<?> returnType=method.getReturnType();
					jsContents.append(fn+":");
					String t=getObjectStr(returnType,method,dataobj).toString();
					jsContents.append(t);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					System.out.println("调用get方法出错");
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		jsContents.deleteCharAt(jsContents.length()-1);
		jsContents.append("}");
		return jsContents;
	}

	/**
	 * 获取每个类型的字符串
	 * @param returnType
	 * @param method
	 * @param orgObj
	 * @return
	 * @throws Exception
	 */
	public StringBuffer getObjectStr(Class<?> returnType,Method method,Object orgObj) throws Exception {
		StringBuffer sb=new StringBuffer();
		if(returnType==String.class) {
			String s=(String) method.invoke(orgObj);
			sb.append("\""+s+"\"");
		}else if(returnType==int.class||returnType==Integer.class){
			Object o=method.invoke(orgObj);
			sb.append(o);
		}else if(returnType==float.class||returnType==Float.class) {
			Object o=method.invoke(orgObj);
			sb.append(o);
		}else if(returnType==double.class||returnType==Double.class) {
			Object o=method.invoke(orgObj);
			sb.append(o);
		}else if(returnType==byte.class||returnType==Byte.class) {
			Object o=method.invoke(orgObj);
			sb.append(o);
		}else if(returnType==char.class||returnType==Character.class) {
			Object o=method.invoke(orgObj);
			sb.append(o);
		}else if(returnType==short.class||returnType==Short.class) {
			Object o=method.invoke(orgObj);
			sb.append(o);
		}else if(returnType==long.class||returnType==Long.class) {
			Object o=method.invoke(orgObj);
			sb.append(o);
		}else if(returnType==boolean.class||returnType==Boolean.class) {
			Object o=method.invoke(orgObj);
			sb.append(o);
		}else if(returnType==Date.class) {
			Object o=method.invoke(orgObj);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sb.append("\""+sdf.format(o)+"\"");
		}
		else if(Map.class.isAssignableFrom(returnType)) {
			Map<?,?> m=(Map<?,?>)method.invoke(orgObj);
			StringBuffer maps=new StringBuffer();
			maps.append("{");
			for(Entry<?, ?> entry:m.entrySet()){
				Object a=entry.getValue();
				if(a instanceof String){
					maps.append(entry.getKey()).append(":").append("\""+a+"\"").append(",");
				}else{
					maps.append(entry.getKey()).append(":").append(a).append(",");
				}

			}
			maps.deleteCharAt(maps.length()-1);
			maps.append("}");
			sb.append(maps);
		}else if(Collection.class.isAssignableFrom(returnType)) {
			StringBuffer sc=new StringBuffer();
			Collection<?> c=(Collection<?>)method.invoke(orgObj);
			Iterator<?> iterable= c.iterator();
			sc.append("[");
			while(iterable.hasNext()){
				Object a=iterable.next();
				if(a instanceof String){
					sc.append("\""+a+"\""+",");
				}else{
					sc.append(a+",");
				}
			}
			sc.deleteCharAt(sc.length()-1);
			sc.append("]");
			sb.append(sc);
		}else {
			Object o=method.invoke(orgObj);
			sb=JsonText(o);
		}
		sb.append(",");
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
