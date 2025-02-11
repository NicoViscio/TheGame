import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GameController {
    private GameModel model;
    private GameVista vista;
    private ControllerMaster master;

    public GameController(GameModel model, GameVista vista, ControllerMaster master) {
        this.model = model;
        this.vista = vista;
        this.master = master;

        javax.swing.Timer timer = new javax.swing.Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateView();
            }
        });
        timer.start();

        vista.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addBola();
            }
        });
    }

    private void updateView() {
        List<BolaDTO> bolas = model.getBolas();
        vista.getCanvas().setBolas(bolas);

        master.infoBolas(bolas);
    }
}