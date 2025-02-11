import java.util.List;

public class ControllerMaster {
    private GameController gameController;

    public ControllerMaster() {
        GameModel model = new GameModel();
        GameVista vista = new GameVista();
        this.gameController = new GameController(model, vista, this);
    }

    public void infoBolas(List<BolaDTO> bolas) {
    }
}