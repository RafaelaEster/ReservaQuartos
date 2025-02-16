import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HotelServer {
    public static void main(String[] args) {
        try {
            RoomManagerImpl roomManager = new RoomManagerImpl();

            LocateRegistry.createRegistry(1099);

            Naming.rebind("rmi://localhost/RoomManager", roomManager);

            System.out.println("Servidor de Hotel pronto.");
        } catch (Exception e) {
            System.out.println("Erro no servidor: " + e);
        }
    }
}
