import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;
import java.util.List;

public class Field implements KeyboardHandler {

    public static final int PADDING = 10;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    private Zeze zeze;
    private HotBabe hotBabe;
    private boolean isStop;
    private Picture background;

    private List<Obstacle> obstacles; //List to hold obstacles
    private static final int OBSTACLE_WIDTH = 100;
    private static final int OBSTACLE_HEIGHT = 70;


    public Field() {
        obstacles = new ArrayList<>();  // initializing list, field and obstacles in fixed position
        initialize();
        initializeObstacles();
    }

    private void initializeObstacles() {
        int[][] obstacleFixedPositions = {
                {150, 150},
                {350, 150},
                {550, 150},
                {750, 150},
                {250, 350},
                {450, 350},
                {650, 350},
                {150, 550},
                {350, 550},
                {550, 550},
                {750, 550}
        };

        //create obstacles on specific positions and add to the list
        for (int[] position : obstacleFixedPositions) {
            int x = position[0];
            int y = position[1];
            Obstacle obstacle = new Obstacle(x, y, OBSTACLE_WIDTH, OBSTACLE_HEIGHT, "obstacle.png");
            obstacles.add(obstacle);
        }
    }

    //Initialize display and background image
    private void initialize() {
        background = new Picture(PADDING, PADDING, "beachy3.jpg");
        background.draw();
    }


    public void gameInit() {
        zeze = new Zeze(this);
        hotBabe = new HotBabe(this);

        movement();   // start game movement loop

        WinMenu winMenu = new WinMenu();
        winMenu.startMenuInit();
    }

    public void resetZezePosition() {
        zeze.resetPosition();  //resets Zeze position
    }

    public void movement() {
        while (!isStop) {
            hotBabe.hotBabeMove();  //Run Hotbabe
            if (checkCollision()) {
                break;   //exit loop if there's a collision
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public boolean checkCollision() {

        //Get Zeze and HotBabe positions and dimensions
        int zezeXPos = zeze.getX();
        int zezeYPos = zeze.getY();
        int zezeWidth = zeze.getWidth();
        int zezeHeight = zeze.getHeight();

        int babeX = hotBabe.getX();
        int babeY = hotBabe.getY();
        int babeWidth = hotBabe.getWidth();
        int babeHeight = hotBabe.getHeight();

        //Collision check between Zeze and Hotbabe
        boolean babeCollision = zezeXPos + zezeWidth >= babeX &&
                zezeXPos <= babeX + babeWidth &&
                zezeYPos + zezeHeight >= babeY &&
                zezeYPos <= babeY + babeHeight;

        if (babeCollision) {
            return true;
        }

        //Collisions between obstacles and both Zeze and Hotbabe
        for (Obstacle obstacle : obstacles) {
            if (obstacle.checkCollisionWithZ(zeze)) {
                zeze.resetPosition();
            }
            if (obstacle.checkCollisionWithB(hotBabe)) {
                hotBabe.changeDirection();
            }

        }
        return false;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
