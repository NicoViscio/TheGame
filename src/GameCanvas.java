import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class GameCanvas extends Canvas {
    private List<BolaDTO> bolas;
    private BufferedImage buffer;
    private Graphics2D bufferGraphics;

    public GameCanvas() {
        this.setBackground(Color.BLACK);
    }

    public void setBolas(List<BolaDTO> bolas) {
        this.bolas = bolas;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        update(g);
    }

    @Override
    public void update(Graphics g) {
        if (buffer == null ||
                buffer.getWidth() != getWidth() ||
                buffer.getHeight() != getHeight()) {

            buffer = new BufferedImage(
                    Math.max(1, getWidth()),
                    Math.max(1, getHeight()),
                    BufferedImage.TYPE_INT_RGB
            );

            if (bufferGraphics != null) {
                bufferGraphics.dispose();
            }
            bufferGraphics = (Graphics2D) buffer.getGraphics();
            // Enable antialiasing for smoother graphics
            bufferGraphics.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );
        }

        bufferGraphics.setColor(getBackground());
        bufferGraphics.fillRect(0, 0, getWidth(), getHeight());

        if (bolas != null) {
            for (BolaDTO bola : bolas) {
                bufferGraphics.setColor(bola.getColor());
                bufferGraphics.fillOval(
                        bola.getX(),
                        bola.getY(),
                        bola.getDiametro(),
                        bola.getDiametro()
                );
            }
        }

        g.drawImage(buffer, 0, 0, this);
    }

    public void destroy() {
        if (bufferGraphics != null) {
            bufferGraphics.dispose();
        }
    }
}