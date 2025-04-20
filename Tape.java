import java.util.HashMap;

public class Tape {
    private HashMap<Integer, Character> tape = new HashMap<>();
    int head = 0;
    
    public Tape () {
        this.head = 0;
    }

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
