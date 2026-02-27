package com.miraclear.viewing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.beans.factory.annotation.Autowired;
import com.miraclear.viewing.service.StorageService;
import java.io.IOException;
import java.nio.file.*;

@SpringBootApplication
public class ViewingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ViewingApplication.class, args);
	}

	@Autowired
	private StorageService storageService;

	@EventListener(ApplicationReadyEvent.class)
	public void initStorage() {
		try {
			String storageLocation = storageService.getStorageLocation();
			System.out.println("Storage location from properties: " + storageLocation);

			Path storagePath = Paths.get(storageLocation).toAbsolutePath().normalize();
			System.out.println("Absolute storage path: " + storagePath);

			if (!Files.exists(storagePath)) {
				System.out.println("Creating models directory...");
				Files.createDirectories(storagePath);
			}

			if (!Files.isDirectory(storagePath)) {
				throw new IOException("Storage path is not a directory");
			}

			if (!Files.isWritable(storagePath)) {
				throw new IOException("Storage directory is not writable");
			}

			System.out.println("Successfully initialized model storage at: " + storagePath);

		} catch (InvalidPathException e) {
			System.err.println("Invalid storage path configuration: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Failed to initialize model storage: " + e.getMessage());
		}
	}
}