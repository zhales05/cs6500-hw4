package oop;

public class Frame {
    private int firstShot = 0;
    private int secondShot = 0;

    public void setFirstShot(int firstShot) {
        this.firstShot += firstShot;
    }

    public void setSecondShot(int secondShot) {
        this.secondShot += secondShot;
    }

    public int getFrameScore() {
        return firstShot + secondShot;
    }
}
