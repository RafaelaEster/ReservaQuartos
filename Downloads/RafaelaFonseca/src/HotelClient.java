import java.rmi.Naming;

public class HotelClient {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Comandos:");
            System.out.println("java HotelClient list <endereço do servidor>");
            System.out.println("java HotelClient book <endereço do servidor> <tipo de quarto> <nome do convidado>");
            System.out.println("java HotelClient clients <endereço do servidor>");
            return;
        }

        try {
            RoomManager roomManager = (RoomManager) Naming.lookup("rmi://" + args[1] + "/RoomManager");

            if (args[0].equals("list")) {
               
                System.out.println(roomManager.listAvailableRooms());
            } else if (args[0].equals("book")) {
               
                int roomType = Integer.parseInt(args[2]);
                String guestName = args[3];
                System.out.println(roomManager.bookRoom(roomType, guestName));
            } else if (args[0].equals("clients")) {
                
                System.out.println(roomManager.listGuests());
            }
        } catch (Exception e) {
            System.out.println("Erro no cliente: " + e);
        }
    }
}
