import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameVista extends JFrame {
    private GameCanvas canvas;
    private GameControlPanel controlPanel;

    public GameVista() {
        this.setTitle("Bolas");
        this.setSize(800, 700);
        this.setLayout(null);

        canvas = new GameCanvas();
        canvas.setBounds(0, 0, 800, 600);

        controlPanel = new GameControlPanel();
        controlPanel.setBounds(0, 600, 800, 100);

        this.add(canvas);
        this.add(controlPanel);

        // Windows Listener para limpiar la pantalla
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                canvas.destroy();
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public GameCanvas getCanvas() {
        return canvas;
    }

    public AddBola getAddButton() {
        return controlPanel.getBAddBola();
    }
}