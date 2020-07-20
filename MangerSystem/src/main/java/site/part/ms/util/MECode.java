package site.part.ms.util;

public class MECode {
	private int[] bytes=null;
	//default encode
	private String encode="utf-8";
	
	private byte[] strs=null; 
	
	public int[] getBytes() {
		return bytes;
	}

	public void setBytes(int[] bytes) {
		this.bytes = bytes;
	}

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}
	
	public byte[] getStrs() {
		return strs;
	}

	public void setStrs(byte[] strs) {
		this.strs = strs;
	}
	public String getString() {
		StringBuffer sb01=new StringBuffer();
		String s=new String(intToByte(bytes));
		System.out.println(s);
		int len=bytes.length;
		for(int i=0;i<len;i++){
			char b=(char)bytes[i];
			sb01.append(bytes[i]+MyEncryption.SPLIT_CHAR);
		}
		sb01.deleteCharAt(sb01.length()-1);
		return sb01.toString();
	}
	private byte[] intToByte(int[] a){
		int l=a.length;
		byte[] b=new byte[l];
		for(int i=0;i<l;i++){
			b[i]=(byte)a[i];
		}
		return b;
	}
}