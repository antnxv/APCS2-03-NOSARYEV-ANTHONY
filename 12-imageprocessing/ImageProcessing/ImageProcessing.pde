public class Kernel {
  float[][] kernel;
  
  public Kernel(float[][]init) {
    kernel = init;
  }
  
  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
    try{
      int bound = kernel.length/2;
      float[] rgb = new float[3];
      for (int c = -bound; c <= bound; c ++)
        for (int r = -bound; r <= bound; r ++){
          rgb[0] += kernel[c+bound][r+bound] * red(img.get(x+c, y+r)); // red
          rgb[1] += kernel[c+bound][r+bound] * green(img.get(x+c, y+r)); // green
          rgb[2] += kernel[c+bound][r+bound] * blue(img.get(x+c, y+r)); // blue
        }
      return color(rgb[0], rgb[1], rgb[2]);
    }catch (IndexOutOfBoundsException e){
      return 0;
    }
  }

  void apply(PImage source, PImage destination) {
    for (int y = 0; y < source.height; y ++)
      for (int x = 0; x < source.width; x ++)
        destination.set(x, y, calcNewColor(source, x, y));
  }
}
