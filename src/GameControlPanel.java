import javax.swing.*;

public class GameControlPanel extends JPanel{

    AddBola AddBola = new AddBola();

    public GameControlPanel(){

        this.add(AddBola);
        this.setBounds(0,200,400,100);
        this.setVisible(true);
    }
    public AddBola getBAddBola() {
        return AddBola;
    }
}
