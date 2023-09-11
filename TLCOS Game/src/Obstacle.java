import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Obstacle {
    private int x;
    private int y;
    private int width;

    private int height;
    private Picture obstaclePic;


    public Obstacle(int x, int y, int width, int height, String imgPath) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.obstaclePic = new Picture(x, y, "obstacle.png");
        this.obstaclePic.draw();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    // Check collision with Zeze
    public boolean checkCollisionWithZ(Zeze zeze) {
        int zezeX = zeze.getX();
        int zezeY = zeze.getY();
        int zezeWidth = zeze.getWidth();
        int zezeHeight = zeze.getHeight();

        return (x + width >= zezeX && x <= zezeX + zezeWidth && y + height >= zezeY && y < zezeY + zezeHeight);
    }

    // Check collision with HotBabe

    public boolean checkCollisionWithB(HotBabe hotBabe) {
        int babeX = hotBabe.getX();
        int babeY = hotBabe.getY();
        int babeWidth = hotBabe.getWidth();
        int babeHeight = hotBabe.getHeight();

        return (x + width >= babeX && x <= babeX + babeWidth && y + height >= babeY && y < babeY + babeHeight);
    }

}
