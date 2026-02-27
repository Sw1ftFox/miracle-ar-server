package com.miraclear.viewing.controller;

import com.miraclear.viewing.dto.ModelDto;
import com.miraclear.viewing.service.StorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    private final StorageService storageService;

    public ModelController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/full")
    public ResponseEntity<List<ModelDto.FullInfo>> getAllModelsWithFullInfo() {
        try {
            List<ModelDto.FullInfo> models = storageService.getAllModelsWithFullInfo();
            return ResponseEntity.ok(models);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{name}/info")
    public ResponseEntity<ModelDto.DetailInfo> getModelInfo(@PathVariable String name) {
        try {
            ModelDto.DetailInfo modelInfo = storageService.getModelDetailInfo(name);
            if (modelInfo != null) {
                return ResponseEntity.ok(modelInfo);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deleteModel(@PathVariable String name) {
        try {
            boolean deleted = storageService.deleteModelAndRelatedFiles(name);
            if (deleted) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Ошибка при удалении модели: " + e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<List<String>> getAllModelFiles() {
        try {
            List<String> models = storageService.getModelFiles();

            return ResponseEntity.ok(models);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/sounds")
    public ResponseEntity<List<String>> getAllSoundFiles() {
        try {
            List<String> sounds = storageService.getSoundFiles();
            return ResponseEntity.ok(sounds);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/patterns")
    public ResponseEntity<List<String>> getAllPatternFiles() {
        try {
            List<String> patterns = storageService.getPatternFiles();
            return ResponseEntity.ok(patterns);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/previews")
    public ResponseEntity<List<String>> getAllImageFiles() {
        try {
            List<String> previews = storageService.getImageFiles();
            return ResponseEntity.ok(previews);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/descriptions")
    public ResponseEntity<List<String>> getAllDescriptionFiles() {
        try {
            List<String> descriptions = storageService.getDescriptionFiles();
            return ResponseEntity.ok(descriptions);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}