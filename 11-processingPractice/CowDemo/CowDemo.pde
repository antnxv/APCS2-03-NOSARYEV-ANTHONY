ArrayList<Cow> particles;
boolean instructions;

void setup() {
  size(1000, 800);
  instructions = false;
  particles = new ArrayList<Cow>();
  for (int i = 0; i < 100; i++)
    particles.add(new Cow());
}

void draw() {
  background(0);
  for (Cow c : particles) {
    c.move();
    c.collide(particles);
    c.display();
  }
  fill(255);
  textSize(20);
  text("FPS: "+frameRate+"\nCows: "+particles.size(),5,30);
  if (!instructions)
    text("Open Instructions: i", 5, height-16);
  else text("Select All: *\nRotate CCW: (\nRotate CW: )\nSlow Down: _\nSpeed up: +\nClear: Spacebar\nReset: r\nClose Instructions: i", 5, height-230);
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

void keyPressed() { // added some bonus funcs using convent keys
  switch (key){
    case 'i': instructions = !instructions;
              break;
    case 'r': particles = new ArrayList<Cow>();
              for (int i = 0; i < 100; i ++)
                particles.add(new Cow());
              break;
    case ' ': particles = new ArrayList<Cow>();
              break;
    case '*': for (Cow c : particles) // shift+8
                c.selected = !c.selected;
              break;
    case '(': for (Cow c : particles) // shift+9
                c.turn(22.5);
              break;
    case ')': for (Cow c : particles) // shift+0
                c.turn(-22.5);
              break;
    case '_': for (Cow c : particles) // shift+-
                if (sqrt(pow(c.dx, 2)+pow(c.dy, 2)) > 1)
                  c.changeSpeed(-1);
              break;
    case '+': for (Cow c : particles) // shift+=
                c.changeSpeed(1);
              break;
  }
}
