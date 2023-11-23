package com.comp301.a06image;

import java.awt.*;

public class ZoomDecorator implements Image {
  private final Image image;
  private final int multiplier;

  public ZoomDecorator(Image image, int multiplier) {
    if (image == null) {
      throw new IllegalArgumentException("Image cannot be null.");
    }
    if (multiplier < 1) {
      throw new IllegalArgumentException("Multiplier cannot be negative.");
    }
    this.image = image;
    this.multiplier = multiplier;
  }

  public ZoomDecorator(Image image) {
    this(image, 2);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    int resizedX = x / multiplier;
    int resizedY = y / multiplier;
    if (x < 0 || y < 0 || x >= this.getWidth() || y >= this.getHeight()) {
      throw new IllegalArgumentException("coordinates are invalid");
    }
    return image.getPixelColor(resizedX, resizedY);
  }

  @Override
  public int getWidth() {
    return image.getWidth() * multiplier;
  }

  @Override
  public int getHeight() {
    return image.getHeight() * multiplier;
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
