import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RoomManager extends Remote {
    
    String listAvailableRooms() throws RemoteException;

    String bookRoom(int roomType, String guestName) throws RemoteException;

    String listGuests() throws RemoteException;
}
