package gates;

public class And extends Gates {
	public And(Wires i1,Wires i2,Wires r) throws Exception
	{  
		genEncryptedLut(0,0,0,1,i1,i2,r);
	}
}