package kodlamaio.hrms.core.utilites.image;



import kodlamaio.hrms.core.utilites.results.DataResult;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	DataResult<Map> upload(MultipartFile multipartFile) throws IOException;
	DataResult<Map> delete(String id) throws IOException;
}
