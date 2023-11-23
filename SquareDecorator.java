package com.comp301.a06image;

import java.awt.*;

public class SquareDecorator implements Image {
  private final Image image;
  private final int squareX;
  private final int squareY;
  private final int squareSize;
  private final Color color;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    if (image == null) {
      throw new IllegalArgumentException("Image cannot be null.");
    }
    if (squareSize < 0) {
      throw new IllegalArgumentException("squareSize cannot be negative.");
    }
    this.image = image;
    this.squareX = squareX;
    this.squareY = squareY;
    this.squareSize = squareSize;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0) {
      throw new IllegalArgumentException("cannot be 0.");
    }
    if (y < 0) {
      throw new IllegalArgumentException("cannot be 0.");
    }
    if (x >= getWidth() | y >= getHeight()) {
      throw new IllegalArgumentException("cannot be 0.");
    }
    if (x < squareX || y < squareY | x >= squareX + squareSize | y >= squareY + squareSize) {
      return image.getPixelColor(x, y);
    } else {
      return color;
    }
  }

  @Override
  public int getWidth() {
    return this.image.getWidth();
  }

  @Override
  public int getHeight() {
    return this.image.getHeight();
  }

  @Override
  public int getNumLayers() {
    return image.getNumLayers() + 1;
  }
}
