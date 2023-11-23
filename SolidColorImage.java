package com.comp301.a06image;

import java.awt.*;

public class SolidColorImage implements Image {
  private final int width;
  private final int height;
  private final Color color;

  public SolidColorImage(int width, int height, Color color) {
    if (width < 0) {
      throw new IllegalArgumentException("Width cannot be less than 0. ");
    }
    if (height < 0) {
      throw new IllegalArgumentException("Height cannot be less than 0. ");
    }
    if (color == null) {
      throw new IllegalArgumentException("Color cannot be null.");
    }
    this.width = width;
    this.height = height;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= width || y < 0 || y >= height) {
      throw new IllegalArgumentException("Invalid pixel coordinates.");
    }
    return this.color;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getNumLayers() {
    return 1;
  }
}
