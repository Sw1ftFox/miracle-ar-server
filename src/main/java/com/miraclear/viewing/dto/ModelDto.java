package com.miraclear.viewing.dto;

import java.time.LocalDateTime;

public class ModelDto {

  public static class FullInfo {
    private String name;
    private String previewUrl;
    private String description;
    private String modelUrl;
    private String patternUrl;
    private String soundUrl;
    private Boolean isCurrent;

    public FullInfo() {
    }

    // геттеры и сеттеры
    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getPreviewUrl() {
      return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
      this.previewUrl = previewUrl;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getModelUrl() {
      return modelUrl;
    }

    public void setModelUrl(String modelUrl) {
      this.modelUrl = modelUrl;
    }

    public String getPatternUrl() {
      return patternUrl;
    }

    public void setPatternUrl(String patternUrl) {
      this.patternUrl = patternUrl;
    }

    public String getSoundUrl() {
      return soundUrl;
    }

    public void setSoundUrl(String soundUrl) {
      this.soundUrl = soundUrl;
    }

    public Boolean getIsCurrent() {
      return isCurrent;
    }

    public void setIsCurrent(Boolean isCurrent) {
      this.isCurrent = isCurrent;
    }
  }

  public static class DetailInfo {
    private String name;
    private String previewUrl;
    private String description;
    private String modelUrl;
    private String patternUrl;
    private String soundUrl;
    private Long fileSize;
    private LocalDateTime createdAt;

    public DetailInfo() {
    }

    // геттеры и сеттеры
    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getPreviewUrl() {
      return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
      this.previewUrl = previewUrl;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getModelUrl() {
      return modelUrl;
    }

    public void setModelUrl(String modelUrl) {
      this.modelUrl = modelUrl;
    }

    public String getPatternUrl() {
      return patternUrl;
    }

    public void setPatternUrl(String patternUrl) {
      this.patternUrl = patternUrl;
    }

    public String getSoundUrl() {
      return soundUrl;
    }

    public void setSoundUrl(String soundUrl) {
      this.soundUrl = soundUrl;
    }

    public Long getFileSize() {
      return fileSize;
    }

    public void setFileSize(Long fileSize) {
      this.fileSize = fileSize;
    }

    public LocalDateTime getCreatedAt() {
      return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
    }
  }
}