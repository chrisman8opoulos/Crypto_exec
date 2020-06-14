package gates;

public class Xor extends Gates {
	public Xor(Wires i1,Wires i2,Wires r) throws Exception
	{
		genEncryptedLut(0,1,1,0,i1,i2,r);
	}

}
