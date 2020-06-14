package gates;

public class Or extends Gates{
	public Or(Wires i1,Wires i2,Wires r) throws Exception
	{  
		genEncryptedLut(0,1,1,1,i1,i2,r);
		
	}


}
