package OOP.OOP5.Interfaces;

public class MusicPlayer implements MediaPlayer {

    @Override
    public void start() {
        System.out.println("Music start.");
    }

    @Override
    public void stop() {
        System.out.println("Music stop.");
    }

}
