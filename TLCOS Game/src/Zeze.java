import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Zeze implements KeyboardHandler {

    private static final int WIDTH = 29;
    private static final int HEIGHT = 87;
    public static final int ZEZE_SIZE = 87;

    private Field field;
    private Picture zezePicture;
    private Keyboard keyboard;


    public Zeze(Field field) {
        this.field = field;
        int startX = Field.PADDING + 20;
        int startY = Field.PADDING + 40;

        zezePicture = new Picture(startX, startY, "zeze2.png");
        zezePicture.draw();

        initializeKeyboard();
    }

    //Getters for Zeze's dimensions and positioning
    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getX() {
        return zezePicture.getX();
    }

    public int getY() {
        return zezePicture.getY();
    }

    private void initializeKeyboard() {
        keyboard = new Keyboard(this);

        //Init keyboard events for arrow keys
        addKeyboardEvent(39, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(37, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(38, KeyboardEventType.KEY_PRESSED);
        addKeyboardEvent(40, KeyboardEventType.KEY_PRESSED);
    }

    private void addKeyboardEvent(int key, KeyboardEventType type) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);

        keyboard.addEventListener(event);
    }

    public void moveRight() {
        if (zezePicture.getX() < 965) {
            if (zezePicture.getWidth() == -WIDTH) {
                zezePicture.grow(WIDTH, 0);
                zezePicture.translate(10, 0);
            }
            zezePicture.translate(20, 0);
        }
    }


    public void moveLeft() {
        if (zezePicture.getX() >= 50) {

            if (zezePicture.getWidth() != -WIDTH) { //change Zeze's direction
                zezePicture.grow(-WIDTH, 0);
                zezePicture.translate(-10, 0);
            }
            zezePicture.translate(-20, 0);
        }
    }

    public void moveUp() {
        if (zezePicture.getY() >= 30) {
            zezePicture.translate(0, -20);
        }
    }

    public void moveDown() {
        if (zezePicture.getY() < 620) {
            zezePicture.translate(0, 20);
        }
    }

    public void resetPosition() {   //reset Zeze's position to the starting position
        zezePicture.translate(20 - zezePicture.getX(), 40 - zezePicture.getY());
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int keyPressed = keyboardEvent.getKey();
        switch (keyPressed) {
            case 39:
                moveRight();
                break;
            case 37:
                moveLeft();
                break;
            case 38:
                moveUp();
                break;
            case 40:
                moveDown();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

}
