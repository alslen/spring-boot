package com.example.demo06.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo06.model.FileBoard;
import com.example.demo06.repository.FileRepository;

@Service
public class FileService {

	@Autowired
	private FileRepository fileRepository;
	public void fileInsert(FileBoard fboard, String uploadFolder) {
		// 파일 업로드 시키는 작업을 해야함.
		UUID uuid = UUID.randomUUID();  // 랜덤한 수 지정
		MultipartFile f = fboard.getUpload();  
		String uploadFileName = "";  // 파일이름 공백으로 넣음(파일 선택x)
		if(!f.isEmpty()) {  // 파일이 선택되었다면
			uploadFileName = uuid.toString()+"_"+f.getOriginalFilename(); // 똑같은 파일이름을 올리면 앞에 올린 파일이 없어지기 때문에 uuid값을 파일 이름 앞에 붙임
			File saveFile = new File(uploadFolder, uploadFileName); // 파일 위치에 파일이름으로 
			
			try {
				f.transferTo(saveFile); // 파일 업로드
				fboard.setFileImage(uploadFileName);  // 파일이름은 직접 셋팅해줘야함(적는 공간이 없기 때문에)
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}  
		}
		fileRepository.save(fboard);  // DB에 값을 insert
	}
	
	public List<FileBoard> fileList(){
		
		return fileRepository.findAll();
	}
	
	// 파일추가2
	public void fileInsert(FileBoard fboard) {
		// 파일 업로드 시키는 작업을 해야함.
		UUID uuid = UUID.randomUUID();  // 랜덤한 수 지정
		MultipartFile f = fboard.getUpload();  
		String uploadFileName = "";  // 파일이름 공백으로 넣음(파일 선택x)
		if(!f.isEmpty()) {  // 파일이 선택되었다면
			uploadFileName = uuid.toString()+"_"+f.getOriginalFilename(); // 똑같은 파일이름을 올리면 앞에 올린 파일이 없어지기 때문에 uuid값을 파일 이름 앞에 붙임
			File saveFile = new File(uploadFileName); // 파일 위치에 파일이름으로 
			
			try {
				f.transferTo(saveFile); // 파일 업로드
				fboard.setFileImage(uploadFileName);  // 파일이름은 직접 셋팅해줘야함(적는 공간이 없기 때문에)
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}  
		}
		fileRepository.save(fboard);  // DB에 값을 insert
	}
}
