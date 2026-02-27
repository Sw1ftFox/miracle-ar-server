package com.miraclear.viewing.controller;

import com.miraclear.viewing.dto.AppConfigDto;
import com.miraclear.viewing.dto.AuthDto;
import com.miraclear.viewing.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final StorageService storageService;

    public ApiController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/admin/authenticate")
    public ResponseEntity<AuthDto.Response> authenticateAdmin(@RequestBody AuthDto.Request request) {
        try {
            boolean authenticated = storageService.validatePassword(request.getPassword());
            AuthDto.Response response = new AuthDto.Response();
            response.setAuthenticated(authenticated);

            if (authenticated) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/app/config")
    public ResponseEntity<AppConfigDto> getAppConfig() {
        try {
            AppConfigDto config = storageService.getAppConfig();
            return ResponseEntity.ok(config);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}