/**
 * 
 */
package site.tj.program.service.impl;

import java.util.List;

import site.tj.program.service.ProgramOperation;

/**
 * @author Administrator
 *
 */
public class ProgOperationImpl implements ProgramOperation {
	public  List<?> queryBy() {
		
		return null;
		
	}
	/**
	 * 前台的current会在前台js中增加
	 */
	public  List<?> pagination(int current,int pageSize,int count){
		String countsql="select count(1) from table";
		int page=count%pageSize==0?(count/pageSize):(count/pageSize+1);//总页数
		String sql="select * from table limit "+(current-1)*pageSize+","+pageSize;
		return null;
	}
}
