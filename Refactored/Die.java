public class Die {
    private int number;

    public int getNumber(){
        return number;
    }

    public void roll() {
        number =  (int)(Math.random() * 6) + 1;
    }
}
