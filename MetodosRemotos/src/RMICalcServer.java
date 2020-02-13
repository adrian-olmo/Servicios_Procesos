import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
import java.rmi.RemoteException;

interface RMICalcInterface extends Remote {
    public int suma(int a, int b) throws RemoteException;
}

public class RMICalcServer implements RMICalcInterface {
    public int suma(int a, int b) throws RemoteException {
        return (a + b);
    }

    public static void main(String[] args) {
        Registry reg = null;
        try {
            reg = LocateRegistry.createRegistry(5555);
        } catch (Exception e) {
            System.out.println("ERROR: No se ha podido crear el registro");
            e.printStackTrace();
        }
        RMICalcServer serverObject = new RMICalcServer();
        try {
            reg.rebind("Calculadora", (RMICalcInterface)UnicastRemoteObject.exportObject(serverObject, 0));
        } catch (Exception e) {
            System.out.println("ERROR: No se ha podido inscribir el objeto servidor.");
            e.printStackTrace();
        }
    }
}

