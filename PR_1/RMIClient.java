import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Calculator stub = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");
            System.out.println("Addition: " + stub.add(10, 5));
            System.out.println("Subtraction: " + stub.sub(10, 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}