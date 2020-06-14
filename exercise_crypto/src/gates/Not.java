package gates;

import yao.Crypto_tools;

public class Not {
	byte[][] lut=new byte[4][];
	
	public Not(){}
	
	public Not(byte[] l1,byte[] l2,byte[] l3,byte[] l4)
	{
		lut[0]=l1;
		lut[1]=l2;
	}
	public Not(byte[][] lut)
	{
		this.lut=lut;
	}

	public byte[] operate(byte[] key1, byte[] key2) throws Exception
	{
		byte[] result1=null;
		byte[] result2=null;
		
		for(int i=0;i<4;i++)
		{
			result1=Crypto_tools.AESdecrypt(lut[i],key1);
			result2=Crypto_tools.AESdecrypt(result1,key2);
			
			if(result2[0]==0x12&&result2[1]==0x33&&result2[2]==0x21)
				return result2;
		}
		
		return null;
	}
	
	
	void genEncryptedLut1Not(int i00,int i11,Wires i1, Wires r) throws Exception
	{	
		//encrypt
		lut[0]=Crypto_tools.AESencrypt(Crypto_tools.AESencrypt(r.value[i00],i1.value[0]),r.value[0]);
		lut[1]=Crypto_tools.AESencrypt(Crypto_tools.AESencrypt(r.value[i11],i1.value[1]),r.value[0]);
	
	}
	public byte[] getLutEntry(int i)
	{
		return lut[i];
	}
	
	public byte[][] getLut()
	{
		return lut;
	}
	
	public Not(Wires i1,Wires r) throws Exception
	{
		genEncryptedLut1Not(0,1,i1,r);
	}

}
