package ustc.gr.controller;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Black on 2017/4/2.
 */
public class MyFile {
    private String description;
    private String fileName;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
