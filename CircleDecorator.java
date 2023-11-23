package com.comp301.a06image;

import java.awt.*;

public class CircleDecorator implements Image {
  private final Image image;
  private final int cx;
  private final int cy;
  private final Color color;
  int radius;

  public CircleDecorator(Image image, int cx, int cy, int radius, Color color) {
    if (image == null) {
      throw new IllegalArgumentException("Image cannot be null.");
    }
    if (radius < 0) {
      throw new IllegalArgumentException("Radius cannot be less than 0.");
    }
    this.image = image;
    this.cx = cx;
    this.cy = cy;
    this.color = color;
    this.radius = radius;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    double distance = Math.sqrt(((cx - x) * (cx - x)) + ((cy - y) * (cy - y)));
    if (distance >= this.radius) {
      return image.getPixelColor(x, y);
    } else {
      return color;
    }
  }

  @Override
  public int getWidth() {
    return image.getWidth();
  }

  @Override
  public int getHeight() {
    return image.getHeight();
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
