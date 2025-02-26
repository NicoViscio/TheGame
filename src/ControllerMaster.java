import java.util.List;

public class ControllerMaster {

    public ControllerMaster() {
        GameModel model = new GameModel();
        GameVista vista = new GameVista();
        new GameController(model, vista, this);
    }

    public void infoBolas(List<BolaDTO> bolas) {
    }
}