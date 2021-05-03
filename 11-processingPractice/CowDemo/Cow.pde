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
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    fill(c);
    noStroke();
    ellipse(x, y, radius*2, radius*2);
    
  }

  void click(){
    selected = !selected;
    //if (dist(mouseX, mouseY, x, y) < radius){
    //  radius = random(60)+20;
    //  c = color(random(255), random(255), random(255));
    //}
    //if the mouseX and mouseY are touching this cow, change the cow somehow.
  }
  
  void collide(ArrayList<Cow> others){
    for (Cow c : others){
      if (dist(c.x, c.y, x, y) < min(radius, c.radius))
        colliding = c.colliding = true;
      else
        colliding = c.colliding = false;
    }
  }
}
