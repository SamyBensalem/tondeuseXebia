public class Pelouse {

    private int limitation_X = 0;
    private int limitation_Y = 0;

    public Pelouse() {

    }


    public Pelouse(int limitation_X, int limitation_Y) {
        this.limitation_X = limitation_X;
        this.limitation_Y = limitation_Y;
    }



    public int getLimitation_X() {
        return limitation_X;
    }

    public void setLimitation_X(int limitation_X) {
        this.limitation_X = limitation_X;
    }

    public int getLimitation_Y() {
        return limitation_Y;
    }

    public void setLimitation_Y(int limitation_Y) {
        this.limitation_Y = limitation_Y;
    }
}
