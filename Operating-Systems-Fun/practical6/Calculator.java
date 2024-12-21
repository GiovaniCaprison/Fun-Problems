import java.rmi.*;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    // Method to add two numbers
    public int add(int a, int b) throws RemoteException;
}

