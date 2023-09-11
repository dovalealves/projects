import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartMenu implements KeyboardHandler {
    private Keyboard keyboard;
    private Field field;
    private boolean isMenuActive = true;
    private boolean isGameStarted = false;

    public StartMenu() {
        keyboardHandler();
    }

    //Initialize start menu
    public void StartMenuInit() {
        Picture menuImage = new Picture(10, 10, "MENU.jpg");
        menuImage.draw();

        try {
            while (isMenuActive) {
                if (isGameStarted) {
                    Thread.sleep(30);
                } else {
                    Thread.sleep(1000);
                }
            }
            menuImage.delete();  //delete when game starts
            field = new Field();
            field.gameInit();  //start the game

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void keyboardHandler() {
        keyboard = new Keyboard(this);
        addKeyboardEvent(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED);

    }

    private void addKeyboardEvent(int key, KeyboardEventType type) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(type);
        keyboard.addEventListener(event);
    }

    public boolean isMenuActive() {
        return isMenuActive;
    }

    public void setMenuActive(boolean active) {
        isMenuActive = active;
    }

    public void setGameStarted(boolean gameStarted) {
        isGameStarted = gameStarted;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            setMenuActive(false);
            setGameStarted(true);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}