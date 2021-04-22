package myanimations;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;

public class BlinkingButton extends AnimationTimer {

    private Glow bloom;
    private double threshold;
    private int animationDirection = 1;
    private long lastUpdate = 0;
    
    public BlinkingButton(Button button) {
    	
    	bloom = new Glow();
    	bloom.setLevel(0);
    	button.setEffect(bloom);
    }
	
	@Override
	public void handle(long now) {
		
		if (now - lastUpdate >= 100000000) {
			doHandle();
            lastUpdate = now;
        }
	}
	
	private void doHandle() {

	    threshold = bloom.getLevel();
        threshold += 0.1 * animationDirection;
        if (threshold >= 1) {
            threshold = 1;
            animationDirection = -1;
        }
        if (threshold <= 0) {
        	 threshold = 0;
             animationDirection = 1;
        }
        bloom.setLevel(threshold);
    }
}
