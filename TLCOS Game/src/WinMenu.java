import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class WinMenu implements KeyboardHandler {
    private Picture background;
    private Keyboard keyboard;
    private boolean isMenuActive = true;
    private Field field;

    public WinMenu() {
        initialize();
        keyboardHandler();
    }

    public void initialize() {
        background = new Picture(10, 10, "WIN.jpg");
    }

    public void startMenuInit() {
        background.draw();
        Sound sound = new Sound("george-micael-wham-careless-whisper-1-_1_.wav");
        sound.play(true);

        try {
            while (isMenuActive) {
                Thread.sleep(30);
            }
            background.delete();
            sound.stop();
            Field field = new Field();
            field.gameInit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void keyboardHandler() {
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

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            setMenuActive(false);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
