package circuit;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//���������� ������������ f1 
		FullAdder f1 = new FullAdder();
		//���������� ���������� full adder
		f1.getCircuit();
		//������� ��� ���������� ���������� ��� ����� A=1,B=0 ��� Cin=0
	    f1.evaluate(1, 0, 0);
		
		

	}
}
