import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); 
            CalculatorImpl obj = new CalculatorImpl();
            Naming.rebind("rmi://localhost/CalculatorService", obj);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}