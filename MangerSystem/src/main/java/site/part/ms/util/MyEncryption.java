package site.part.ms.util;


/**
 * 该加密算法有点假，并没有把数字变为对应的字符，也没有进行压缩
 */
public class MyEncryption {
	private MECode mecode=null;
	protected static final String SPLIT_CHAR="%";
	public enum EncryptionType{
		SPLIT_TWO,EXCHANGE
	}
	public MyEncryption(byte[] data) {
		mecode=new MECode();
		mecode.setStrs(data);
	}
	public MECode getEncode(EncryptionType t) {
		int a[] = null;
		if (t== EncryptionType.SPLIT_TWO) {
			a=encry();
		}else if(t== EncryptionType.EXCHANGE) {
			a=encry01();
		}
		mecode.setBytes(a);
		return mecode;
	}
	/**
	 * 解密该类型的数据
	 * @param str
	 * @return
	 */
	public String Decode(String str,EncryptionType t) {
		if(t== EncryptionType.EXCHANGE) {
			return Decode01(str);
		}else {	
			int[] a=getNumbers(str);
			int l=a.length;
			byte[] b=new byte[(l/2)+1];
			for(int i=0;i<l;i+=2) {
				byte  d=(byte) ((a[i]<<4)|a[i+1]);
				b[(i+1)/2]=d;
			}
			String s=new String(b);
			return s;
		}
		
	}
	public String Decode01(String str) {
		int[] as=getNumbers(str);
		int l=as.length;
		byte[] bs=new byte[l];
		int a,b,c;
		for(int i=0;i<l;i++) {
			a=(as[i]&0xff)>>4;
			b=(as[i]&0x0f);
			c=(b<<4)|a;
			bs[i]=(byte)c;
		}
		String s=new String(bs);
		return s;
		
	}
	/**
	 * 字符的简单加密
	 * @return
	 */
	public int[] encry() {
		int a,b;
		byte[] bytes=mecode.getStrs();
		int len=bytes.length;
		int[] results=new int[len<<1];
		for(int i=0;i<len;i++) {
			a=(bytes[i]&0xff)>>4;
			b=(bytes[i]&0x0f);
			results[i<<1]=a;
			results[(i<<1)+1]=b;
		}
		return results;
		
	}
	public int[] encry01() {
		int a,b,c;
		byte[] bytes=mecode.getStrs();
		int len=bytes.length;
		int[] results=new int[len];
		for(int i=0;i<len;i++) {
			a=(bytes[i]&0xff)>>4;
			b=(bytes[i]&0x0f);
			c=(b<<4)|a;
			results[i]=c;
		}
		return results;
		
	}
	public int[] getNumbers(String str) {
		String[] temp=str.split(SPLIT_CHAR);
		int len=temp.length;
		int[] a = new int[len];
		for(int i=0;i<len;i++) {
			a[i]=Integer.parseInt(temp[i]);
		}
		return a;
	}
}
