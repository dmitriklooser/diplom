package geneticalg;

/**
 * Simple Room abstraction -- used to store the room capacity and compare against the student Group's size.
 */
public class Room {
	public enum TypeRoom{
		AUDITORIA,
		LABORATORIA,
		SPORT
	}
	private final int roomId;
	private final String roomNumber;
	private final int capacity;
	private final TypeRoom typeRoom;
	
	/**
	 * Initialize new Room
	 * 
	 * @param roomId
	 *            The ID for this classroom
	 * @param roomNumber
	 *            The room number
	 * @param capacity
	 *            The room capacity
	 */
	public Room(int roomId, String roomNumber, int capacity, TypeRoom type) {
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.capacity = capacity;
		this.typeRoom = type;
	}

	/**
	 * Return roomId
	 * 
	 * @return roomId
	 */
	public int getRoomId() {
		return this.roomId;
	}

	/**
	 * Return room number
	 * 
	 * @return roomNumber
	 */
	public String getRoomNumber() {
		return this.roomNumber;
	}

	/**
	 * Return room capacity
	 * 
	 * @return capacity
	 */
	public int getRoomCapacity() {
		return this.capacity;
	}
	public TypeRoom getTypeRoom() {
		return this.typeRoom;
	}
}