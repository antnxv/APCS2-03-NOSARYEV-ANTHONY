public class Kernel {
  float[][] kernel;
  
  public Kernel(float[][]init) {
    kernel = init;
  }
  
  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
    return 0;
  }

  void apply(PImage source, PImage destination) {
    for (int y = 0; y < source.height; y ++)
      for (int x = 0; x < source.width; x ++)
        destination.set(x, y, calcNewColor(source, x, y));
  }
}
