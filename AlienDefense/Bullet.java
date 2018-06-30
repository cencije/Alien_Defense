import acm.program.*;
import acm.graphics.*;
import java.awt.*;

/* This class controls the bullets that are shot by enemies and the player
 * There are two types of bullets
 * The bullets can explode
 */
public class Bullet extends GCompound implements Runnable {
  // constants
  private static final double DELAY = 20;
  // instance variables
  private AlienDefenseMain game; // the main game
  private double size;
  public int type;
  private double xSpeed, ySpeed;
  private GImage explosion;
    
  // The constructor
  public Bullet(double size, int type, double xSpeed, 
                      double ySpeed, AlienDefenseMain game) {
    // save the parameters in instance variables
    this.game = game;
    this.size = size;
    this.type = type;
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
    
    // Create the bullet, centered at the origin
    GOval ammoBullet = new GOval(0,0, size, size);
    ammoBullet.setColor(Color.YELLOW);
    ammoBullet.setFilled(true);
    add(ammoBullet);
    
    // If it's a friendly bullet, make it blue.
    if (type == 1) {
      ammoBullet.setFillColor(Color.BLUE);      
    }
    // If it's an enemy bullet, make it red.
    if (type == 2) {
      ammoBullet.setFillColor(Color.RED);
    }
  }
  
  // Run the method to animate the bullet
  public void run() {
    while (true) {
      oneTimeStep();
      pause(DELAY);      
    }  
  }
  
  // Move the ball each step
  private void oneTimeStep() {
    double x = getX();
    double y = getY();
    
    // Move it
    move(xSpeed, ySpeed); 
    // Check collision with asteroids, alien Ships, the player, and the boss.
    /*game.checkCollisionAliensShips(this);
    game.checkCollisionAsteroids(this);
    game.checkCollisionPlayerShip(this);
    game.checkCollisionAlienBoss(this);*/

  }
  // Explode upon impact, called from main class.
  public void explode() {
    // Add the explosion, remove the bullet, then remove the explosion.
    explosion = new GImage("Pictures/Explosion1.png");
    add(explosion);
    explosion.setSize(40,40);
    pause(100);
    remove(explosion);
  }
  
}