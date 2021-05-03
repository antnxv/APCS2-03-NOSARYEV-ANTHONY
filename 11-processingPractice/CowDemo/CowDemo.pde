ArrayList<Cow> particles; 
void setup() {
  size(1000, 800);
  particles = new ArrayList<Cow>();
  for (int i = 0; i < 100; i++)
    particles.add(new Cow());
}

void draw() {
  background(0);
  for (Cow c : particles) {
    c.move();
    c.display();
  }
  fill(255);
  textSize(20);
  text("FPS: "+frameRate+"\nCows: "+particles.size(),0,20);
}

void mousePressed() {
  if (mouseButton == LEFT)
    for (Cow c : particles){
      c.click();
    }
  else if (mouseButton == RIGHT){
    Cow c = new Cow();
    particles.add(c);
    c.x = mouseX;
    c.y = mouseY;
  }
}

void keyPressed() {
  if (key == ' ')
    particles = new ArrayList<Cow>();
}
