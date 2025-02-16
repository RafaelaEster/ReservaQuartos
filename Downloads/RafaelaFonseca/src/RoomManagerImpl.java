import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

public class RoomManagerImpl extends UnicastRemoteObject implements RoomManager {

    private final int[] availableRooms = {10, 20, 5, 3, 2}; 
    private final int[] roomPrices = {55, 75, 80, 150, 230}; 
    private final Map<Integer, String> guests = new HashMap<>();

    protected RoomManagerImpl() throws RemoteException {
        super();
    }

    @Override
    public String listAvailableRooms() throws RemoteException {
        StringBuilder rooms = new StringBuilder();
        for (int i = 0; i < availableRooms.length; i++) {
            rooms.append(String.format("%d quartos do tipo %d estão disponiveis por %d reais por noite%n",
                    availableRooms[i], i, roomPrices[i]));
        }
        return rooms.toString();
    }

    @Override
    public String bookRoom(int roomType, String guestName) throws RemoteException {
        if (roomType < 0 || roomType >= availableRooms.length) {
            return "Tipo de quarto invalido.";
        }
        if (availableRooms[roomType] > 0) {
            availableRooms[roomType]--;
            guests.put(roomType, guestName);
            return String.format("reserva confirmada para %s no quarto do tipo %d.", guestName, roomType);
        } else {
            return "Quarto indisponivel.";
        }
    }

    @Override
    public String listGuests() throws RemoteException {
        StringBuilder guestList = new StringBuilder();
        for (Map.Entry<Integer, String> entry : guests.entrySet()) {
            guestList.append(String.format("tipo de quarto %d: %s%n", entry.getKey(), entry.getValue()));
        }
        return guestList.toString();
    }
}
