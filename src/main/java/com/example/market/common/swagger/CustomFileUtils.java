package com.example.market.common.swagger;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Component
@Getter
public class CustomFileUtils {
    public final String uploadPath;

    public CustomFileUtils(@Value("${file.directory}") String uploadPath) {
        this.uploadPath = uploadPath;
    }

    //폴더 만들기
    public String makeFolders(String path) {
        File folder = new File(uploadPath, path);
        folder.mkdirs();
        return folder.getAbsolutePath();
    }

    //파일명에서 확장자 추출
    public String getExt(String fileName) {
        int idx = fileName.lastIndexOf(".");
        return fileName.substring(idx);
    }

    //UUID 랜덤 파일명
    public String makeRandomFileName() {
        return UUID.randomUUID().toString();
    }

    //랜덤 파일명 with 확장자 만들기
    public String makeRandomFileName(String fileName) {
        return makeRandomFileName() + getExt(fileName);
    }

    //랜덤 파일명 with 확장자 만들기
    public String makeRandomFileName(MultipartFile mf) {
        return mf == null ? null : makeRandomFileName(mf.getOriginalFilename());
    }

    //파일 저장
    public void transferTo(MultipartFile mf, String target) throws Exception {
        File saveFile = new File(uploadPath, target); //최종 경로
        mf.transferTo(saveFile);
    }

    //폴더 삭제
    public void deleteFolder(String path) {
        File folder = new File(uploadPath, path);
        if(folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            for(File f : files) {
                if(f.isDirectory()) {
                    deleteFolder(f.getAbsolutePath());
                } else {
                    f.delete();
                }
            }
            folder.delete();
        }
    }



}

