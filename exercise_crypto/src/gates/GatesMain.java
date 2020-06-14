package gates;

import yao.Crypto_tools;

public class GatesMain {

	public static void main(String[] args) throws Exception {
		Wires a1=new Wires();
		Wires a2=new Wires();
		Wires ra=new Wires();
		Wires rb=new Wires();
		Wires rc=new Wires();
		Wires Nr=new Wires();
		
		Gates Xg1=new Xor(a1,a2,ra);
		Gates Ag2=new And(a1,a2,rb);
		Gates Og3=new Or(a1,a2,rc);
		Not Ng4=new Not(a1,Nr);
			
		byte[][] lut_g1=Xg1.getLut();
		byte[][] lut_g2=Ag2.getLut();
		byte[][] lut_g3=Og3.getLut();
		byte[][] lut_g4=Ng4.getLut();
		byte[] in_a1=a1.getValue1();
		byte[] in_a2=a2.getValue0();
		byte[] in_b1=a1.getValue1();
		byte[] in_b2=a2.getValue1();
		
		
		System.out.println("garbled XOR truth table:");
		Crypto_tools.printLut(Xg1, "g1");
		System.out.println("garbled AND truth table:");
		Crypto_tools.printLut(Ag2, "g2");
		System.out.println("garbled OR truth table:");
		Crypto_tools.printLut(Og3, "g3");
		System.out.println("garbled NOT truth table:");
		Crypto_tools.printLut1(Ng4, "g4");
		
	}

}
