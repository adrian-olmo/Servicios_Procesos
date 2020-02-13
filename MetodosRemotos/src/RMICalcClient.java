import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMICalcClient {
    public static void main(String[] args) {
        RMICalcInterface calc = null;
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 5555);
            calc = (RMICalcInterface) registry.lookup("Calculadora");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (calc != null) {
            try {
                System.out.println("2 + 2 = " + calc.suma(2, 2));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}