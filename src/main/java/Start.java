import com.codecool.polishdraughts.Board;
import com.codecool.polishdraughts.Game;

public class Start {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();
        game.tryToMakeMove();
    }

}
