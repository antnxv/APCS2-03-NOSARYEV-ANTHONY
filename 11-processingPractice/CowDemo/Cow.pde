public class Cow {
  float x, y, dx, dy, radius;
  boolean colliding, selected;
  color c;

  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    colliding = selected = false;
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    if (selected && colliding){
      x += dx;
      y += dy;
    }
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    noStroke();
    if (colliding)
      fill(255, 0, 0, 25);
    else
      fill(c);
    ellipse(x, y, radius*2, radius*2);
    if (selected){
      fill(255);
      textSize(15);
      text("DX: "+dx+"\nDY: "+dy,x+radius+5,y);
      
    }
    
  }

  void click(){
    if (dist(mouseX, mouseY, x, y) < radius)
      selected = !selected;
  }
  
  void collide(ArrayList<Cow> others){
    colliding = false;
    for (Cow c : others){
      if (c != this && dist(c.x, c.y, x, y) < radius + c.radius)
        colliding = true;
    }
  }
}
