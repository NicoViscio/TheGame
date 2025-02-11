import java.awt.*;

public class Bola implements Runnable {
    private BolaDTO data;
    private int velX;
    private int velY;
    private boolean running;
    private Thread thread;

    public Bola(int x, int y, int diametro, Color color) {
        this.data = new BolaDTO(x, y, diametro, color);
        this.velX = (int)(Math.random() * 10) - 5;
        this.velY = (int)(Math.random() * 10) - 5;

        if (velX == 0) velX = 1;
        if (velY == 0) velY = 1;
    }

    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            move();
            try {
                Thread.sleep(16); // Approximately 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        int newX = data.getX() + velX;
        int newY = data.getY() + velY;

        // Bounce off edges (assuming 800x600 canvas)
        if (newX <= 0 || newX + data.getDiametro() >= 800) {
            velX = -velX;
            newX = data.getX() + velX;
        }
        if (newY <= 0 || newY + data.getDiametro() >= 600) {
            velY = -velY;
            newY = data.getY() + velY;
        }

        data.setX(newX);
        data.setY(newY);
    }

    public BolaDTO getData() {
        return data;
    }
}