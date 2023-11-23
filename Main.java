package com.comp301.a06image;

import java.awt.Color;
import java.io.IOException;
import javafx.application.Application;

public class Main {
  /**
   * Creates and returns an image object for testing. The image that this method produces will be
   * automatically displayed on the screen when main() is run below. Use this method to test
   * different decorators.
   */
  public static Image makeImage() throws IOException {
    Color greenish = new Color(0, 255, 52);
    SolidColorImage test1 = new SolidColorImage(200, 200, Color.green);
    PictureImage baseImage = new PictureImage("img/kmp.jpg");
    Color red = new Color(255, 0, 0);
    Color blue = new Color(0, 0, 255);
    Color yellow = new Color(255, 255, 0);
    Color orange = new Color(200, 80, 10);
    BorderDecorator bordered = new BorderDecorator(baseImage, 5, red);
    BorderDecorator borderedTwice = new BorderDecorator(bordered, 50, blue);
    CircleDecorator circled = new CircleDecorator(borderedTwice, 50, 50, 40, yellow);
    SquareDecorator squared = new SquareDecorator(circled, 100, 100, 40, orange);
    ZoomDecorator zoomed = new ZoomDecorator(squared);
    return zoomed;
  }

  /**
   * Use this method for testing your code. When main() runs, the image you created and decorated in
   * the makeImage() method above will be generated and displayed on the screen. You don't need to
   * make any changes to this main() method.
   */
  public static void main(String[] args) {
    Application.launch(ImageDisplay.class, args);
  }
}
