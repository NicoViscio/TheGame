import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    private List<Bola> bolas;

    public GameModel() {
        bolas = new ArrayList<>();
    }

    public void addBola() {
        int x = (int)(Math.random() * 700);
        int y = (int)(Math.random() * 500);
        Color color = new Color(
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255)
        );

        Bola bola = new Bola(x, y, 30, color);
        bolas.add(bola);
        bola.start();
    }

    // Especificamos que solo queremos objetos de tipo BolaDTO
    public List<BolaDTO> getBolas() {
        List<BolaDTO> bolasDTOs = new ArrayList<>();
        for (Bola bola : bolas) {
            bolasDTOs.add(bola.getData());
        }
        return bolasDTOs;
    }
}