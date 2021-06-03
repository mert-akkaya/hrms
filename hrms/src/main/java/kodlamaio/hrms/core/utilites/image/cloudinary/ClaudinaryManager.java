package kodlamaio.hrms.core.utilites.image.cloudinary;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

import kodlamaio.hrms.core.utilites.image.ImageService;
import kodlamaio.hrms.core.utilites.results.DataResult;
import kodlamaio.hrms.core.utilites.results.ErrorDataResult;
import kodlamaio.hrms.core.utilites.results.SuccessDataResult;

@Service
public class ClaudinaryManager implements ImageService {

	Cloudinary cloudinary;
	private Map<String,String> valuesMap = new HashMap<>();
	
	public ClaudinaryManager() {
		valuesMap.put("cloud_name", "walhalla");
		valuesMap.put("api_key", "222516568567319");
		valuesMap.put("api_secret", "3mN4piFbTaBSXC4A7X7nWiM7yUI");
		
		cloudinary = new Cloudinary(valuesMap);
	}
	
	@Override
	public DataResult<Map> upload(MultipartFile multipartFile) throws IOException {
		Map<String,Object> supportedType = new HashMap<>();
		var list = Arrays.asList("png","jpeg","jpg");
		supportedType.put("supported_type", list);
		File file = convert(multipartFile);
		Map result;
		try {
			result = cloudinary.uploader().upload(file, supportedType);
		} catch (Exception e) {
			return new ErrorDataResult<Map>(e.getMessage());
		}
		file.delete();
		return new SuccessDataResult<Map>(result);
	}

	@Override
	public DataResult<Map> delete(String id) throws IOException {
		Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
		return new SuccessDataResult<Map>(result);
	}
	
	private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }

}
