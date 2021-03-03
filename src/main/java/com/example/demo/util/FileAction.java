package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Component
public class FileAction {
    @Value("${upload.path}")
    private String uploadPath;

    private static Path path;

    private Path getPath(String path) {
        return Paths.get(path);
    }

    @PostConstruct
    public void postConstruct() {

        path = getPath(uploadPath); // <-- using myVar after the bean construction
    }


    public static String uploadFile(MultipartFile file) {
        if (!file.getOriginalFilename().equals("")) {
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(path.toString(), resultFileName);
            System.out.println(filePath);
            try (OutputStream os = Files.newOutputStream(filePath)) {
                os.write(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resultFileName;
        }
        return null;
    }

    public static String viewFile(String fileName) {
        if (!fileName.isEmpty()) {
            try {
                InputStream is = new FileInputStream(new File(String.valueOf(path), fileName));
                return "data:image/png;base64," + new String(Base64.getEncoder().encode(StreamUtils.copyToByteArray(is)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
