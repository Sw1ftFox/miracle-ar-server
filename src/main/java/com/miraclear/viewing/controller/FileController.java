package com.miraclear.viewing.controller;

import com.miraclear.viewing.service.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private final StorageService storageService;

    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("type") String type,
            @RequestParam("modelName") String modelName) {

        try {
            String result = storageService.saveFileWithModelAssociation(file, type, modelName);
            return ResponseEntity.ok(Map.of("message", result));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Ошибка при загрузке файла: " + e.getMessage()));
        }
    }

    @GetMapping("/patterns/default")
    public ResponseEntity<Resource> serveDefaultPattern() {
        return storageService.serveFile("default.patt", "patterns", "application/octet-stream");
    }

    @GetMapping("/models/{fileName:.+}")
    public ResponseEntity<Resource> serveModelFile(@PathVariable String fileName) {
        return storageService.serveFile(fileName, "models", "model/gltf-binary");
    }

    @GetMapping("/sounds/{fileName:.+}")
    public ResponseEntity<Resource> serveSoundFile(@PathVariable String fileName) {
        return storageService.serveFile(fileName, "sounds", "audio/mpeg");
    }

    @GetMapping("/patterns/{fileName:.+}")
    public ResponseEntity<Resource> servePatternFile(@PathVariable String fileName) {
        return storageService.serveFile(fileName, "patterns", "application/octet-stream");
    }

    @GetMapping("/previews/{fileName:.+}")
    public ResponseEntity<Resource> serveImageFile(@PathVariable String fileName) {
        return storageService.serveImageFile(fileName);
    }

    @DeleteMapping("/models/{fileName:.+}")
    public ResponseEntity<?> deleteModelFile(@PathVariable String fileName) {
        return deleteFile(fileName, "models");
    }

    @DeleteMapping("/sounds/{fileName:.+}")
    public ResponseEntity<?> deleteSoundFile(@PathVariable String fileName) {
        return deleteFile(fileName, "sounds");
    }

    @DeleteMapping("/patterns/{fileName:.+}")
    public ResponseEntity<?> deletePatternFile(@PathVariable String fileName) {
        return deleteFile(fileName, "patterns");
    }

    @DeleteMapping("/previews/{fileName:.+}")
    public ResponseEntity<?> deleteImageFile(@PathVariable String fileName) {
        return deleteFile(fileName, "previews");
    }

    @DeleteMapping("/descriptions/{fileName:.+}")
    public ResponseEntity<?> deleteDescriptionFile(@PathVariable String fileName) {
        return deleteFile(fileName, "descriptions");
    }

    private ResponseEntity<?> deleteFile(String fileName, String fileType) {
        try {
            System.out.println("Delete request - File: " + fileName + ", Type: " + fileType);

            boolean deleted = storageService.deleteFile(fileName, fileType);

            if (deleted) {
                return ResponseEntity.ok().body(Map.of(
                        "message", "Файл успешно удален",
                        "fileName", fileName,
                        "fileType", fileType));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "Файл не найден: " + fileName));
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            System.err.println("Error deleting file: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Ошибка при удалении файла: " + e.getMessage()));
        }
    }
}