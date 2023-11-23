package com.comp301.a06image;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PictureImage implements Image {
  private final BufferedImage bufferedImage;

  public PictureImage(String pathname) throws IOException {
    this.bufferedImage = ImageIO.read(new File(pathname));
  }

  @Override
  public Color getPixelColor(int x, int y) {
    int colorNumber = this.bufferedImage.getRGB(x, y);
    return new Color(colorNumber);
  }

  @Override
  public int getWidth() {
    return this.bufferedImage.getWidth();
  }

  @Override
  public int getHeight() {
    return this.bufferedImage.getHeight();
  }

  @Override
  public int getNumLayers() {
    return 1;
  }

  public int getRGB(int x, int y) {
    return this.bufferedImage.getRGB(x, y);
  }
}
