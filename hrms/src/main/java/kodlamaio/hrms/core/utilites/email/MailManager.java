package kodlamaio.hrms.core.utilites.email;

public class MailManager implements MailService {

	@Override
	public void send(String email,String message) {
		//simulation
		//activation code will be added
		System.out.println("Mail send : "+email);	
	}

}
