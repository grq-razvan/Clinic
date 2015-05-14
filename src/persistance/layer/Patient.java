package persistance.layer;

import java.util.Date;

public class Patient {

	private int cardNumber;
	private String cnp, name, address;
	private Date dateOfBirth;

	public Patient(int cardNumber, String cnp, String name, String address,
			Date dateOfBirth) {
		super();
		this.cardNumber = cardNumber;
		this.cnp = cnp;
		this.name = name;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}


	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
