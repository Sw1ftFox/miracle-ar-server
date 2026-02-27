package com.miraclear.viewing.dto;

import java.util.List;

public class AppConfigDto {
  private String currentModel;
  private String currentPattern;
  private String appVersion;
  private SupportedFormats supportedFormats;

  public static class SupportedFormats {
    private List<String> models;
    private List<String> previews;
    private List<String> sounds;
    private List<String> patterns;

    public SupportedFormats() {
    }

    public List<String> getModels() {
      return models;
    }

    public void setModels(List<String> models) {
      this.models = models;
    }

    public List<String> getImages() {
      return previews;
    }

    public void setImages(List<String> previews) {
      this.previews = previews;
    }

    public List<String> getSounds() {
      return sounds;
    }

    public void setSounds(List<String> sounds) {
      this.sounds = sounds;
    }

    public List<String> getPatterns() {
      return patterns;
    }

    public void setPatterns(List<String> patterns) {
      this.patterns = patterns;
    }
  }

  // геттеры и сеттеры
  public String getCurrentModel() {
    return currentModel;
  }

  public void setCurrentModel(String currentModel) {
    this.currentModel = currentModel;
  }

  public String getCurrentPattern() {
    return currentPattern;
  }

  public void setCurrentPattern(String currentPattern) {
    this.currentPattern = currentPattern;
  }

  public String getAppVersion() {
    return appVersion;
  }

  public void setAppVersion(String appVersion) {
    this.appVersion = appVersion;
  }

  public SupportedFormats getSupportedFormats() {
    return supportedFormats;
  }

  public void setSupportedFormats(SupportedFormats supportedFormats) {
    this.supportedFormats = supportedFormats;
  }
}