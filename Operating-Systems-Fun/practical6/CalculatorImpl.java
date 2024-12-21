import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {
    // Constructor
    public CalculatorImpl() throws RemoteException {
        super();
    }

    // Implement the add method
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        try {
            CalculatorImpl calcServer = new CalculatorImpl();
            Naming.rebind("CalculatorService", calcServer);
            System.out.println("Calculator Service is running.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

