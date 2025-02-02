package oop;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    List<Frame> frames = new ArrayList<>();
    public void play(List<String> shots) {
        int shotIndex = 0;
        int round = 1;

        while(round <= 10) {
            Frame frame;
            if(round == 10) {
                frame = new TenthFrame();
            } else {
                frame = new Frame();
            }

            int firstShot = Integer.parseInt(shots.get(shotIndex++));
            frame.setFirstShot(firstShot);

            if(firstShot != 10) {
                int secondShot = Integer.parseInt(shots.get(shotIndex++));
                frame.setSecondShot(secondShot);
            } else {
                //is strike add next two shots
                frame.setFirstShot(Integer.parseInt(shots.get(shotIndex)));
                frame.setFirstShot(Integer.parseInt(shots.get(shotIndex + 1)));
            }

            if (frame.getFrameScore() == 10) {
                //spare (strike should be above 10)
                frame.setSecondShot(Integer.parseInt(shots.get(shotIndex)));

                if(round == 10 && shotIndex < shots.size() - 1) {
                    ((TenthFrame)frame).setThirdShot(Integer.parseInt(shots.get(shotIndex+1)));
                }
            }

            frames.add(frame);
            round++;
        }

        System.out.println("Final Score: " + getFinalScore());
    }

    public int getFinalScore() {
        return frames.stream().mapToInt(Frame::getFrameScore).sum();
    }
}
