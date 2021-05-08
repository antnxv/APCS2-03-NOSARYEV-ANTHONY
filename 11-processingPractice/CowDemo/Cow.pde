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
  
  void turn(float angle) {
    float v = dist(0, 0, dx, dy);
    angle -= degrees(atan2(dy,dx));
    dx = v * cos(radians(-angle));
    dy = v * sin(radians(-angle));
  }
  
  void changeSpeed(float dv){
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
      text("DX: "+dx+"\nDY: "+dy+"\nA: "+degrees(atan2(-dy,dx)),x+radius+5,y);
      fill(0);
      ellipse(x-radius/2, y-radius/8, radius/3, radius/3);
      ellipse(x+radius/2, y-radius/8, radius/3, radius/3);
      if (!colliding){
        strokeWeight(radius/10);
        stroke(0);
        noFill();
        arc(x, y+radius/6, radius, 3*radius/4, PI/6, 5*PI/6); 
        endShape();
      }
    }
    
  }

  void click(){
    if (dist(mouseX, mouseY, x, y) < radius)
      selected = !selected;
    //turn(30);
  }
  
  void collide(ArrayList<Cow> others){
    colliding = false;
    for (Cow c : others){
      if (c != this && dist(c.x, c.y, x, y) < radius + c.radius)
        colliding = true;
    }
  }
}
