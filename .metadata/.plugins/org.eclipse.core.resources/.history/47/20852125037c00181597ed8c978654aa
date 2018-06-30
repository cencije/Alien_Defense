import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Auto Generated Java Class.
 */
public class AlienShip extends GCompound implements Runnable {
  // constants
  private static final double DELAY = 1;
  // instance variables
  private AlienDefenseMain game; // the main game
  private GImage alienShip, explosion;
  public double size, speed, xSpeed, ySpeed, xMove, yMove;
  private int health;
  public int alienType;
  public int pathNumber;
  public boolean isFlying;

// The constructor
  public AlienShip(double size, int type, AlienDefenseMain game) {
    // save the parameters in instance variables
    this.game = game;
    this.size = size;
    
    // Draw the alien Ship by finding an image file
    alienType = type;
    if (alienType == 1) {
    alienShip = new GImage("Images/Blorp.gif");
    speed = .1;
    health = 1;
    }
    else if (alienType == 2) {
    alienShip = new GImage("Images/Shlorp.gif");
    speed = .15;
    health = 2;
    }
    else if (alienType == 3) {
    alienShip = new GImage("Images/Vorp.gif");
    speed = .3;
    health = 2;
    }
    else if (alienType == 4) {
    alienShip = new GImage("Images/Meborp.gif");
    speed = .2;
    health = 5;
    }
    else if (alienType == 5) {
    alienShip = new GImage("Images/Horp.gif");
    alienShip.setSize(size,size);
    speed = .15;
    health = 5;
    }
    else if (alienType == 6) {
    alienShip = new GImage("Images/Yorp.gif");
    speed = .2;
    health = 7;
    }
    else if (alienType == 7) {
    alienShip = new GImage("Images/Rainborp.gif");
    speed = .25;
    health = 7;
    }
    xMove = 0;
    yMove = 0;
    isFlying = true;
    alienShip.setSize(size,size);
    add(alienShip);
  }
  
  // Run the method to animate the Ship.
  public void run() {
    while (isFlying) {
      oneTimeStep();
      pause(DELAY);      
    }   
  }
  
  // in each time step, move the ship
  private void oneTimeStep() {
    double x = getX();
    double y = getY();
    game.boundaryChecks(this);
    move(xMove, yMove); 
  }
  public void moveRight() {
    xMove = speed;
    yMove = 0;
    pathNumber = 2;
  }
  public void moveLeft() {
    xMove = -speed;
    yMove = 0;
    pathNumber = 4;
  }
  public void moveUp() {
    xMove = 0;
    yMove = -speed;
    pathNumber = 1;
  }
  public void moveDown() {
    xMove = 0;
    yMove = speed;
    pathNumber = 3;
    
  }
  public void getHit(int dmgNumber) {
    health = health - dmgNumber;
    System.out.println("" + health);
    if (health <= 0) {
     killShip(); 
    }
  }
  public int getHealth() { return health; }
  public boolean getFlying() { return isFlying; }
  public void removeShip() {
    isFlying = false;
    removeAll(); 
  }
  public void killShip() {
    if (alienType == 5) {
     game.giveLife(); 
    }
    explode();
  }
    // Animate the Ships explosion
  public void explode() {
    // Remove the ship, stop animating it
    remove(alienShip);
    isFlying = false;
    // Add the explosion
    explosion = new GImage("Images/Explosion1.png");
    explosion.setSize(size,size);
    add(explosion);
    pause(500);
    explosion.setVisible(false);
    remove(explosion);
  }
}
