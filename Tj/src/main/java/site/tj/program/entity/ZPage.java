package site.tj.program.entity;

import lombok.Getter;
import lombok.Setter;

public class ZPage {
	
	
	@Getter @Setter private int pageNo;
	@Getter @Setter private int pageSize;
	@Getter @Setter private int pageCount;
	public ZPage(int pageNo, int pageSize, int pageCount) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
	}
	public ZPage(){}
	@Override
	public String toString() {
		return "ZPage [pageNo=" + pageNo + ", pageSize=" + pageSize + ", pageCount=" + pageCount + "]";
	}
	
}
