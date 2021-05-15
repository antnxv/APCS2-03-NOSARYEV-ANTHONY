PImage source;
PImage result;

void setup(){
  float[][] vals;
  
  // Type Options: 
  //  0. custom
  //  1. blur
  //  2. bottom sobel
  //  3. emboss
  //  4. identity
  //  5. left sobel
  //  6. outline
  //  7. right sobel
  //  8. sharpen
  //  9. top sobel
  // Preset types are all 3x3 kernels
  // If you choose a preset, comment out the explicit kernel definition
  // If you choose type 0, comment out the line calling chooseKernel()
  
  vals = chooseKernel(6); // chooseKernel() takes int associated with desired type
  
  //vals = new float[][] // can be any n*n size iff n is an odd integer;
  //{
  //  {0, 0, 0, 0, 0},
  //  {0, 0, 0, 0, 0},
  //  {0, 0, 1, 0, 0}
  //  {0, 0, 0, 0, 0},
  //  {0, 0, 0, 0, 0},
  //};
  
  Kernel k = new Kernel(vals);
  k.apply(source, result);
}

void draw(){
  image(source, 0, 0);
  image(result, 0, source.height);
}

void settings(){
  String path = "redcar.jpg";
  source = loadImage(path);
  result = loadImage(path);
  size(source.width, 2*source.height);
}

// All presets from https://setosa.io/ev/image-kernels/
float[][] chooseKernel(int type){ 
  switch (type){
    case 0:  return new float[][]{ // Custom (uses Identity)
      {0, 0, 0},
      {0, 1, 0},
      {0, 0, 0}};
    case 1:  return new float[][]{ // Blur
      {0.0625, 0.125, 0.0625},
      {0.125, 0.25, 0.125},
      {0.0625, 0.125, 0.0625}};
    case 2:  return new float[][]{ // Bottom Sobel
      {-1, -2, -1},
      {0, 0, 0},
      {1, 2, 1}};
    case 3:  return new float[][]{ // Emboss
      {-2, -1, 0},
      {-1, 1, 1},
      {0, 1, 2}};
    case 4:  return new float[][]{ // Identity
      {0, 0, 0},
      {0, 1, 0},
      {0, 0, 0}};
    case 5:  return new float[][]{ // Left Sobel
      {1, 0, -1},
      {2, 0, -2},
      {1, 0, -1}};
    case 6:  return new float[][]{ // Outline
      {-1, -1, -1},
      {-1, 8, -1},
      {-1, -1, -1}};
    case 7:  return new float[][]{ // Right Sobel
      {-1, 0, 1},
      {-2, 0, 2},
      {-1, 0, 1}};
    case 8:  return new float[][]{ // Sharpen
      {0, -1, 0},
      {-1, 5, -1},
      {0, -1, 0}};
    case 9:  return new float[][]{ // Top Sobel
      {1, 2, 1},
      {0, 0, 0},
      {-1, -2, -1}};
  }
  return new float[][]{ // Identity
    {0, 0, 0},
    {0, 1, 0},
    {0, 0, 0}};
}
             
