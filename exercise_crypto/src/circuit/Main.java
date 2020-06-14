package circuit;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//Δημιουργία αντικειμένου f1 
		FullAdder f1 = new FullAdder();
		//δημιουργία κυκλώματος full adder
		f1.getCircuit();
		//τρέξιμο και αποτέλεσμα κυκλώματος για τιμές A=1,B=0 και Cin=0
	    f1.evaluate(1, 0, 0);
		
		

	}
}
