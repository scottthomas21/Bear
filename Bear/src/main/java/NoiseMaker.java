package main.java;

public class NoiseMaker {
    public double price;
    String label;
    String recording;

    Location spot;

    public NoiseMaker() {
        this("Default Noise", "I wuv you", Location.CENTERBODY);
    }

    public NoiseMaker(String label, String recording, Location location) {
        this.label = label;
        this.recording = recording;
        this.spot = location;
        
        if (spot == Location.CENTERBODY) {
        	 this.price = 10; 
        }
        else {
            this.price = 5;
        }
    }

    public enum Location {
        RIGHT_HAND, LEFT_HAND, RIGHT_FOOT, LEFT_FOOT, CENTERBODY
    }
}
