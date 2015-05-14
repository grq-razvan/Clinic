package persistance.layer;

public interface SecretaryInterface {

	void registerDoctor(DoctorInterface doctor);

	void unregisterDoctor(DoctorInterface doctor);

	void notifyDoctor(String doctorUsername, String message);

}
