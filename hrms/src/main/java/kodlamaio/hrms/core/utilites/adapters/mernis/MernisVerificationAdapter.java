package kodlamaio.hrms.core.utilites.adapters.mernis;

import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilites.adapters.VerificationService;
import kodlamaio.hrms.entities.dtos.UserForMernisValidateDto;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisVerificationAdapter implements VerificationService {

	@Override
	public boolean checkIfRealPerson(UserForMernisValidateDto userForMernisValidate) {
		boolean result = false;
		
		try {
			KPSPublicSoapProxy client = new KPSPublicSoapProxy();
			result=client.TCKimlikNoDogrula(Long.parseLong(userForMernisValidate.getIdentityNumber()), userForMernisValidate.getFirstName().toUpperCase(new Locale("tr")), userForMernisValidate.getLastName().toUpperCase(new Locale("tr")), userForMernisValidate.getBirthYear());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	

}
