package tw.springmvc.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.springmvc.model.Picture;
import tw.springmvc.model.PictureService;



@Controller
public class UploadFileController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private PictureService pService;
	
	@RequestMapping(path = "/fileuploadEnrty.controller", method = RequestMethod.GET)
	public String processEntryFormPage() {
		return "UploadFile";
	}
	
	@RequestMapping(path = "/filuploadAction.contoller", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<byte[]> processFileUploadAction(@RequestParam(name = "myFiles") MultipartFile mFile) throws Exception{
		
		String fileName = mFile.getOriginalFilename();
		String fileTempDirPath = request.getSession().getServletContext().getRealPath("/") + "UploadTempDir\\";
		
		System.out.println("fileName:" + fileName);
		System.out.println("fileTempDirPath:" + fileTempDirPath);
		
		File dirPath = new File(fileTempDirPath);
		
		if(!dirPath.exists()) {
			boolean status = dirPath.mkdirs();
			System.out.println("status:" + status);
		}
		
		String fileSavePath = fileTempDirPath + fileName;
		File saveFile = new File(fileSavePath);
		mFile.transferTo(saveFile);
		System.out.println("fileSavePath:" + fileSavePath);	
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		
		if(fileName!=null && fileName.length()!=0) {
			savePicture(fileName, fileSavePath);
		}
		
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(saveFile), headers, HttpStatus.OK);
	}

	private void savePicture(String fileName, String fileSavePath) {
        try {
            Picture picture = new Picture();	
            picture.setFilename(fileName);
            
			FileInputStream is1 = new FileInputStream(fileSavePath);
			byte[] b = new byte[is1.available()];
			is1.read(b);
			is1.close();
			
			picture.setPicture(b);
			
			pService.insert(picture);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
