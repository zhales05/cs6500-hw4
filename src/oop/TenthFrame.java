package oop;

public class TenthFrame extends Frame {
    private int thirdShot = 0;

    public TenthFrame() {
        super();
    }

    public void setThirdShot(int thirdShot) {
        this.thirdShot += thirdShot;
    }

    @Override
    public int getFrameScore() {
        return super.getFrameScore() + thirdShot;
    }
}
