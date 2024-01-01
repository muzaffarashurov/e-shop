package uz.brogrammers.eshop.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.brogrammers.eshop.common.property.FileStorageProperty;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageProperty property) throws FileNotFoundException {
        this.fileStorageLocation = Paths.get(property.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectory(this.fileStorageLocation);
        } catch (IOException ex) {
            throw new FileNotFoundException("Could not create directory " + this.fileStorageLocation);
        }
    }

    public String storeFile(MultipartFile file) throws FileNotFoundException {
        String name = StringUtils.cleanPath(file.getOriginalFilename().split("\\.")[0]);
        String type = StringUtils.cleanPath(file.getOriginalFilename().split("\\.")[1]);
        String fileName = name + new Date().getTime() + "." + type;

        try {
            if (fileName.contains("..")) {
                throw new FileNotFoundException("Sorry! Filename contains invalid path sequence: " + fileName);
            }
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;

        }catch (IOException e) {
            throw new FileNotFoundException("Couldn't store file " + fileName + ". Please try again!");
        }
    }

}
