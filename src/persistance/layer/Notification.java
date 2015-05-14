package persistance.layer;

public class Notification {
	private int id;
	private String username, message;

	public Notification(int id, String username, String message) {
		super();
		this.id = id;
		this.username = username;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
