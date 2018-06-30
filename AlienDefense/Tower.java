import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Auto Generated Java Class.
 */
public class Tower extends GCompound implements Runnable {
  // constants
  private static final double DELAY = 1;
  // instance variables
  private AlienDefenseMain game; // the main game
  private GImage tower, explosion;
  public double size, speed, xSpeed, ySpeed, xMove, yMove;
  private int health;
  public int towerType;
  public int pathNumber;
  public boolean runningWave;

// The constructor
  public Tower(double size, int type, AlienDefenseMain game) {
    // save the parameters in instance variables
    this.game = game;
    this.size = size;
    
    // Draw the alien Ship by finding an image file
    towerType = type;
    if (type == 1) {
    tower = new GImage("Images/Tower1.png");
    speed = .1;
    health = 1;
    }
    else if (towerType == 2) {
    tower = new GImage("Images/Tower2.gif");
    speed = .15;
    health = 2;
    }
    else if (towerType == 3) {
    tower = new GImage("Images/Vorp.gif");
    speed = .3;
    health = 2;
    }
    else if (towerType == 4) {
    tower = new GImage("Images/Meborp.gif");
    speed = .2;
    health = 5;
    }
    else if (towerType == 5) {
    tower = new GImage("Images/Horp.gif");
    tower.setSize(size,size);
    speed = .15;
    health = 5;
    }
    runningWave = false;
    tower.setSize(size,size);
    add(tower);
  }
  
  // Run the method to animate the Ship.
  public void run() {
    while (runningWave) {
      oneTimeStep();
      pause(DELAY);      
    }   
  }
  
  // in each time step, shoot
  private void oneTimeStep() {  
    shoot();
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
  public void shoot() {
	  
  }
  public void removeShip() {
    removeAll(); 
  }

}
