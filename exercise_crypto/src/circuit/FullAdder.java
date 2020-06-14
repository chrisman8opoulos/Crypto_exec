package circuit;

import gates.And;
import gates.Gates;
import gates.Or;
import gates.Wires;
import gates.Xor;
import yao.Crypto_tools;

public class FullAdder {
	byte[][] lut_g1, lut_g2, lut_g3, lut_g4, lut_g5;
	Wires a, b, c, r1, r2, r3, r4, r5;

	//Δημιουργία του κυκλώματος του full adder(ορισμός πυλών και wires που θα χρειστούμε)
	public void getCircuit() throws Exception {
		System.out.println("Generate Full Adder Circuit");

		a = new Wires();
		b = new Wires();
		c = new Wires();

		r1 = new Wires();
		r2 = new Wires();
		r3 = new Wires();
		r4 = new Wires();
		r5 = new Wires();

		Gates g1 = new Xor(a, b, r1);
		Gates g2 = new Xor(r1, c, r2);
		Gates g3 = new And(a, b, r3);
		Gates g4 = new And(c, r1, r4);
		Gates g5 = new Or(r3, r4, r5);

		lut_g1 = g1.getLut();
		lut_g2 = g2.getLut();
		lut_g3 = g3.getLut();
		lut_g4 = g4.getLut();
		lut_g5 = g5.getLut();

		System.out.println("Full Adder Circuit has been generated");
	}
	//τρέξιμο του κυκλώματος και print του αποτελέσματος
	public boolean[] evaluate(int input_a, int input_b, int input_c) throws Exception {
		System.out.println("Evaluate Full Adder Circuit");
		byte[] in_a = { 10 };
		byte[] in_b = { 9 };
		byte[] in_c = { 8 };

		if (input_a == 0) {
			in_a = a.getValue0();
		} else if (input_a == 1) {
			in_a = a.getValue1();

		}

		if (input_b == 1) {
			in_b = b.getValue1();
		} else if (input_b == 0) {
			in_b = b.getValue0();
			;
		}
		if (input_c == 1) {
			in_c = c.getValue1();
			;
		} else if (input_c == 0) {
			in_c = c.getValue0();

		}
		
		Gates gate1 = new Gates(lut_g1);
		Gates gate2 = new Gates(lut_g2);
		Gates gate3 = new Gates(lut_g3);
		Gates gate4 = new Gates(lut_g4);
		Gates gate5 = new Gates(lut_g5);
		
		//παίρνουμε το αποτέλεσμα των πυλών
		byte[] ret1 = gate1.operate(in_b, in_a);
		byte[] ret2 = gate2.operate(in_c, ret1);
		byte[] ret3 = gate3.operate(in_b, in_a);
		byte[] ret4 = gate4.operate(ret1, in_c);
		byte[] ret5 = gate5.operate(ret4, ret3);

		boolean[] results = new boolean[2];
		
		//ν το ret2 είναι ίσο με το r2.getValue0() τότε η έξοδος του sum είναι 0 
		//, αλλιώς αν είναι ίση με r2.getValue1() τότε η έξοδος του sum είναι ίση με 1
		if (Crypto_tools.arraysAreEqual(ret2, r2.getValue0())) {
			results[0] = false;
			System.out.println("SUM=0");
		} else if (Crypto_tools.arraysAreEqual(ret2, r2.getValue1())) {
			results[0] = true;
			System.out.println("SUM=1");
		}
		
		// αν το ret5 ισούται με r5.getValue0() τότε το κρατούμενο ισούται με 0 
		//αλλιώς αν ret5 ισούται με ret5.getValue1() τότε το κρατούμενο ισούται με 1
		if (Crypto_tools.arraysAreEqual(ret5, r5.getValue0())) {
			results[1] = false;
			System.out.println("Cout=0");
		} else if (Crypto_tools.arraysAreEqual(ret5, r5.getValue1())) {
			results[1] = true;
			System.out.println("Cout=1");
		}
		return results;

	}
}
