package OOP.OOP5.Interfaces;

import java.util.Scanner;

public class NiceCar {
    private Engine engine;
    private MediaPlayer player;
    private Brake brake;
    private String EngineType;

    public void changeEngine() {
        Scanner input = new Scanner(System.in);
        EngineType = input.next();
        if (EngineType.equals("Electric")) {
            this.engine = new ElectricEngine();
        }
        engine.type(EngineType);
        input.close();
    }

    NiceCar() {
        engine = new PetrolEngine();
        player = new MusicPlayer();
        brake = new Brake();
    }

    public void startCar() {
        engine.start();
    }

    public void stopCar() {
        engine.stop();
    }

    public void acc() {
        engine.acc();
    }

    public void playMusic() {
        player.start();
    }

    public void stopMusic() {
        player.stop();
    }

    public void brakes() {
        brake.brake();
    }

    public void stopBrakes() {
        brake.stop();
    }

    public static void main(String[] args) {
        NiceCar car = new NiceCar();
        car.startCar();
        car.acc();
        car.playMusic();
        car.brakes();
        car.stopCar();
        car.stopBrakes();
        car.stopMusic();
        car.changeEngine();
        car.startCar();
        car.acc();
        car.playMusic();
        car.brakes();
        car.stopCar();
        car.stopBrakes();
        car.stopMusic();
    }

}
