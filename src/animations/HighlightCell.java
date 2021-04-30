package animations;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HighlightCell extends AnimationTimer {

	private double opacity = 0;
	private double opacityDirection = 1;
    private Rectangle rect;
    private long lastUpdate = 0;
    private int rectColorR;
    private int rectColorG;
    private int rectColorB;
    
    public HighlightCell(Rectangle rect, int R, int G, int B) {
    	
    	this.rect = rect;
    	this.rectColorR = R;
    	this.rectColorG = G;
    	this.rectColorB = B;
    }
	
	@Override
	public void handle(long now) {
		
		if (now - lastUpdate >= 1000000) {
			doHandle();
            lastUpdate = now;
        }
	}
	
	private void doHandle() {
		
        opacity += 0.1 * opacityDirection;

        if (opacity >= 0 && opacity <= 1 && opacityDirection > 0) {
        	rect.setFill(Color.rgb(rectColorR, rectColorG, rectColorB, opacity));
        }
        else {
        	if (opacity >= 1 && opacityDirection > 0) {
        		opacity = 1;
                rect.setFill(Color.rgb(rectColorR, rectColorG, rectColorB, opacity));
                opacityDirection = -1;
            }
        	else {
        		if (opacity <= 0 && opacityDirection < 0) {
        			stop();
        			opacity = 1;
                	rect.setFill(Color.rgb(255, 255, 255, opacity));
                }
        	}
        }
    }
}
