package kodlamaio.hrms.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kodlamaio.hrms.core.utilites.adapters.VerificationService;
import kodlamaio.hrms.core.utilites.adapters.mernis.MernisVerificationAdapter;
import kodlamaio.hrms.core.utilites.email.MailManager;
import kodlamaio.hrms.core.utilites.email.MailService;

@Configuration
public class Configuraiton {

	@Bean
	public MailService mailService() {
		return new MailManager();
	}
	
	@Bean
	public VerificationService verificationService() {
		return new MernisVerificationAdapter();
	}
}
