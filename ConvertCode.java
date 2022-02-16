package finalExam;

public class ConvertCode {
	
	public static double getFarCel(double input) {
		double output;
		output = (input - 32) * 5/9;
		return output;
	}
	
	public static double getFarKel(double input) {
		double output;
		output = ((input - 32) * 5/9) + 273.15;
		return output;
	}
	
	public static double getCelFar(double input) {
		double output;
		output = (input * 9/5) + 32;
		return output;
	}
	
	public static double getCelKel(double input) {
		double output;
		output = input + 273.15;
		return output;
	}
	
	public static double getKelFar(double input) {
		double output;
		output = (input - 273.15) * 9/5 + 32;
		return output;
	}
	
	public static double getKelCel(double input) {
		double output;
		output = input - 273.15;
		return output;
	}
}
