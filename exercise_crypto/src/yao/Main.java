package yao;

import java.util.Scanner;

import circuit.FullAdder;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int A = 0;
		int B = 0;
		int Cin = 0;
		int number1 = 0;
		int number2 = 0;
		System.out.println("A δημιουργεί το circuit του full adder");
		FullAdder f1 = new FullAdder();
		f1.getCircuit();
		System.out.println("A στέλνει τις τιμές A,B");
		System.out.println("βάζουμε input δύο 3ψήφιους αριθμούς σε binary μορφή,πχ 101 και 110");
		Scanner sc = new Scanner(System.in);
		number1 = sc.nextInt();
		int temp1 = number1;
		number2 = sc.nextInt();
		int temp2 = number2;
		int count1 = 0;
		int count2 = 0;
		//αρχικοποιούμε 2 πίνακες τιμών digit1 και digit2 για να πάρουμε τα επιμέρους ψηφία των αριθμών Α και Β
		int digit1[] = new int[4];
		int digit2[] = new int[4];
		while (number1 > 0) {
			number1 = number1 / 10;
			count1++;
		}
		while (temp1 > 0) {
			digit1[count1] = temp1 % 10;
			//System.out.println("Digit at place " + count1 + " is: " + digit1[count1]);
			temp1 = temp1 / 10;
			count1--;
		}
		while (number2 > 0) {
			number2 = number2 / 10;
			count2++;
		}
		while (temp2 > 0) {
			digit2[count2] = temp2 % 10;
			//System.out.println("Digit at place " + count2 + " is: " + digit2[count2]);
			temp2 = temp2 / 10;
			count2--;
		}

		int S1;
		String sum1;
		int S2;
		String sum2;
		int S3;
		String sum3;
		int Cout1;
		String c1;
		int Cout2;
		String c2;
		int Cout3;
		String c3;
		System.out.println("B executes the circuit of 3 Full Adders");
		//1ος Full Adder με Cin=0
		boolean[] s1 = f1.evaluate(digit1[3], digit2[3], Cin);
		if (s1[0] ==true ) {
			S1 = 1;
			sum1 = "1";
		} else {
			S1 = 0;
			sum1 = "0";
		}
		if (s1[1] == true) {
			Cout1 = 1;
			c1 = "1";
		} else {
			Cout1 = 0;
			c1 = "0";
		}
		System.out.println(S1);
		System.out.println(Cout1);
		//2ος Full Adder
		boolean[] s2 = f1.evaluate(digit1[2], digit2[2], Cout1);
		if (s2[0] == true) {
			S2 = 1;
			sum2 = "1";
		} else {
			S2 = 0;
			sum2 = "0";
		}
		if (s2[1] == true) {
			Cout2 = 1;
			c2 = "1";
		} else {
			Cout2 = 0;
			c2 = "0";
		}
		System.out.println(S2);
		System.out.println(Cout2);
		//3ος Full Adder
		boolean[] s3 = f1.evaluate(digit1[1], digit2[1], Cout2);
		if (s3[0] == true) {
			S3 = 1;
			sum3 = "1";
		} else {
			S3 = 0;
			sum3 = "0";
		}
		if (s3[1] == true) {
			Cout3 = 1;
			c3 = "1";
		} else {
			Cout3 = 0;
			c3 = "0";
		}
		System.out.println("Ο Β τυπώνει το άθροισμα");
		System.out.println(c3+sum3 + sum2 + sum1);
	
	}
}