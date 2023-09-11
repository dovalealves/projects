import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HotBabe {

    public static final int HOTBABE_SIZE = 87;
    private static final int WIDTH = 87;
    private static final int HEIGHT = 29;

    private Picture hotBabeShape;
    private Field field;
    private BabeDirection currentDirection;


    public HotBabe(Field field) {
        this.field = field;
        int startX = (Field.WIDTH - HOTBABE_SIZE) / 2;
        int startY = Field.HEIGHT - 250;

        hotBabeShape = new Picture(startX, startY, "HotBabereduced.png");
        hotBabeShape.draw();
        currentDirection = BabeDirection.DOWN;
    }


    // Getters for HotBabe's dimensions and position
    public int getX() {
        return hotBabeShape.getX();
    }

    public int getY() {
        return hotBabeShape.getY();
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public BabeDirection hotBabeMove() {
        int stepSize = 60;

        int newX = hotBabeShape.getX();
        int newY = hotBabeShape.getY();

        // Move HotBabe based on the current direction
        switch (currentDirection) {
            case UP:
                newY -= stepSize;
                break;
            case DOWN:
                newY += stepSize;
                break;
            case LEFT:
                newX -= stepSize;
                break;
            case RIGHT:
                newX += stepSize;
                break;
            case UP_LEFT:
                newX -= stepSize;
                newY -= stepSize;
                break;
            case UP_RIGHT:
                newX += stepSize;
                newY -= stepSize;
                break;
            case DOWN_LEFT:
                newX -= stepSize;
                newY += stepSize;
                break;
            case DOWN_RIGHT:
                newX += stepSize;
                newY += stepSize;
                break;

        }
        // Check if the new position is within the field boundaries
        if (newX >= Field.PADDING && newX + hotBabeShape.getWidth() <= Field.WIDTH && newY >= Field.PADDING && newY + hotBabeShape.getHeight() <= Field.HEIGHT) {   // adicionamos height da babe na ultima condicao e adiconar width da babe na segunda
            hotBabeShape.translate(newX - hotBabeShape.getX(), newY - hotBabeShape.getY());
        }
        // Choose a new random direction and return it
        return currentDirection = choseDirection();
    }

    public BabeDirection choseDirection() {
        BabeDirection newDirection = currentDirection;

        if (Math.random() > 0.5) { // Changes direction 50% of the time, randomly
            newDirection = BabeDirection.values()[(int) (Math.random() * BabeDirection.values().length)];
        }

        return newDirection;
    }

    public void changeDirection() { // Change HotBabe's direction when there's a collision
        currentDirection = choseDirection();
    }

}



