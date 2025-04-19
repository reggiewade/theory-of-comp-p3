import java.util.HashMap;

public class TM {
    private HashMap<Integer, Character> tape = new HashMap<>();
    private int head = 0;

    public char read() {
        return tape.getOrDefault(head, '_');
    }

    public void write(char symbol) {
        tape.put(head, symbol);
    }

    public void moveLeft() {
        head--;
    }

    public void moveRight() {
        head++;
    }

    public int getHeadPosition() {
        return head;
    }
}
