package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {
  private final Image image;
  private final int thiccness;
  private final Color borderColor;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    if (thiccness < 0) {
      throw new IllegalArgumentException("Thiccness cannot be negative.");
    }
    if (image == null) {
      throw new IllegalArgumentException("Image cannot be null.");
    }
    if (borderColor == null) {
      throw new IllegalArgumentException("Color cannot be null.");
    }
    this.image = image;
    this.thiccness = thiccness;
    this.borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    int width = this.getWidth();
    int height = this.getHeight();
    if (x < 0 || y < 0 || x >= width || y >= height) {
      throw new IllegalArgumentException("coordinates are invalid");
    }
    if ((x + thiccness) >= width || (y + thiccness) >= height || x < thiccness || y < thiccness) {
      return borderColor;
    } else {
      return image.getPixelColor(x - thiccness, y - thiccness);
    }
  }

  @Override
  public int getWidth() {
    return image.getWidth() + (2 * (thiccness));
  }

  @Override
  public int getHeight() {
    return image.getHeight() + (2 * (thiccness));
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
