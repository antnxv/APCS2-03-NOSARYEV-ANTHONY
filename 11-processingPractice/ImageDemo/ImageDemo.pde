//PImage img0 = loadImage("redcar.jpg");
PImage img; //loadImage("redcar.jpg");

void setup(){
  size(772, 495);
  img = loadImage("redcar.jpg");
  for (int c = 0; c < width; c ++){
    for (int r = 0; r < height; r ++){
      float re = red(img.get(c,r));
      float gr = green(img.get(c,r));
      float bl = blue(img.get(c,r));
      if (re < gr*1.02 || re < bl*1.02)
        //img.set(c, r, color(255-re, 255-gr, 255-bl)); // Invert (ugly)
        img.set(c, r, color((re+gr+bl)/3)); // Grey
      else{
        float reOld = re;
        re = gr+bl/2;
        gr = reOld;
        bl = reOld;
        img.set(c, r, color(re, gr, bl)); // Turq
      }
    }
  }
}

void draw(){
  image(img, 0, 0);
}
