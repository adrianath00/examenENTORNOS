package CalcuBasica;

public class CalcuBasica {
	private double num1;
    public double numero2;
 
    public static void main(String[] args) {
        CalcuBasica calculadora = new CalcuBasica();
        calculadora.setNum1(10);
        calculadora.numero2 = 5;
 
        extracted(calculadora);
    }

	private static void extracted(CalcuBasica calculadora) {
		// Suma
        double suma = calculadora.getNum1() + calculadora.numero2;
        System.out.println("La suma es: " + suma);
 
        // Resta
        double resta = calculadora.getNum1() - calculadora.numero2;
        System.out.println("La resta es: " + resta);
 
        // Multiplicación
        double multiplicacion = calculadora.getNum1() * calculadora.numero2;
        System.out.println("La multiplicación es: " + multiplicacion);
 
        // División
        if (calculadora.numero2 != 0) {
            double division = calculadora.getNum1() / calculadora.numero2;
            System.out.println("La división es: " + division);
        } else {
            System.out.println("No se puede dividir entre cero.");
        }
	}

	private double getNum1() {
		return num1;
	}

	private void setNum1(double num1) {
		this.num1 = num1;
	}
}