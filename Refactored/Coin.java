import java.lang.Math;

public class Coin {
    public int sequenceNumber = 0;
    public String state;

    public Coin() {
        // Initialise the coin to be face-up
        state = "Tail";
    }

    public String flip() {
        // Flip the coin
        if (Math.random() >= 0.5)
            state = "Head";
        else
            state = "Tail";
        sequenceNumber++;
        return state;
    }


    public static void main(String[] args) {
        Coin c = new Coin();
        for (int i = 0; i < 10; i++)
            System.out.println(c.flip());
    }
}
