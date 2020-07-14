package site.part.ms.util;

public enum MSSystemStatus {
	ON_LINE(0x2),//用户在线
	OUT_LINE(0x3),//用户离线
	;
	private int val;
	MSSystemStatus(int i) {
		this.val=i;
	}
	public void setVal(int i) {
		this.val=i;
	}
	public int Val() {
		return this.val;
	}
}
