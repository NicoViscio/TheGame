import java.awt.*;

public class BolaDTO {
    private int x;
    private int y;
    private int diametro;
    private Color color;

    //  Porpiedades de la bola
    public BolaDTO(int x, int y, int diametro, Color color) {
        this.x = x;
        this.y = y;
        this.diametro = diametro;
        this.color = color;
    }

    // Getters y setters
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public int getDiametro() { return diametro; }
    public Color getColor() { return color; }
}