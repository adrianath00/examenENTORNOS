package cajanegra;
import java.util.Scanner;
public class cajanegra {
	public class ImpuestoCalculator {
	    // Lógica para calcular el impuesto
	    public static double calcularImpuesto(String tipoContrato, double salario) {
	        switch (tipoContrato.toLowerCase()) {
	            case "indefinido":
	                if (salario < 1500) {
	                    return 0;
	                } else if (salario < 3000) {
	                    return salario * 0.05;
	                } else {
	                    return salario * 0.10;
	                }

	            case "temporal":
	                if (salario < 1000) {
	                    return 0;
	                } else if (salario < 2000) {
	                    return salario * 0.08;
	                } else {
	                    return salario * 0.15;
	                }

	            case "por obra":
	                if (salario < 500) {
	                    return 0;
	                } else if (salario < 1000) {
	                    return salario * 0.12;
	                } else {
	                    return salario * 0.18;
	                }

	            default:
	                throw new IllegalArgumentException("Tipo de contrato inválido");
	        }
	    }

	    // Método principal para ejecutar el programa manualmente y realizar pruebas
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Ejecución manual
	        System.out.print("Ingrese el tipo de contrato (indefinido/temporal/por obra): ");
	        String tipoContrato = scanner.nextLine();

	        System.out.print("Ingrese el salario: ");
	        double salario = scanner.nextDouble();

	        try {
	            double impuesto = calcularImpuesto(tipoContrato, salario);
	            System.out.println("El impuesto a pagar es: " + impuesto);
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        // Ejecución de pruebas
	        System.out.println("\nEjecutando pruebas automáticas...");
	        ejecutarPruebas();

	        scanner.close();
	    }

	    // Método para ejecutar las pruebas
	    public static void ejecutarPruebas() {
	        // Contrato Indefinido
	        assert calcularImpuesto("indefinido", 1400) == 0 : "Error en test caso 1 (indefinido, 1400)";
	        assert calcularImpuesto("indefinido", 1500) == 75.0 : "Error en test caso 2 (indefinido, 1500)";
	        assert calcularImpuesto("indefinido", 2500) == 125.0 : "Error en test caso 3 (indefinido, 2500)";
	        assert calcularImpuesto("indefinido", 3000) == 300.0 : "Error en test caso 4 (indefinido, 3000)";

	        // Contrato Temporal
	        assert calcularImpuesto("temporal", 900) == 0 : "Error en test caso 5 (temporal, 900)";
	        assert calcularImpuesto("temporal", 1000) == 80.0 : "Error en test caso 6 (temporal, 1000)";
	        assert calcularImpuesto("temporal", 1500) == 120.0 : "Error en test caso 7 (temporal, 1500)";
	        assert calcularImpuesto("temporal", 2000) == 300.0 : "Error en test caso 8 (temporal, 2000)";

	        // Contrato por Obra
	        assert calcularImpuesto("por obra", 400) == 0 : "Error en test caso 9 (por obra, 400)";
	        assert calcularImpuesto("por obra", 500) == 60.0 : "Error en test caso 10 (por obra, 500)";
	        assert calcularImpuesto("por obra", 750) == 90.0 : "Error en test caso 11 (por obra, 750)";
	        assert calcularImpuesto("por obra", 1000) == 180.0 : "Error en test caso 12 (por obra, 1000)";

	        // Caso de Error
	        try {
	            calcularImpuesto("freelance", 2000);
	            assert false : "Error en test caso 13 (freelance, 2000) - Se esperaba una excepción";
	        } catch (IllegalArgumentException e) {
	            assert e.getMessage().equals("Tipo de contrato inválido") : "Mensaje de excepción incorrecto";
	        }

	        System.out.println("¡Todos los casos de prueba pasaron exitosamente!");
	    }
	}
}
