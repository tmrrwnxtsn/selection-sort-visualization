package animations;

import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HighlightCell extends AnimationTimer {

	private double opacity = 0;
	private double opacityDirection = 1;

	private Rectangle theRectangle;

	private long lastUpdate = 0;

	private int cellColorR;
	private int cellColorG;
	private int cellColorB;

	public HighlightCell(Rectangle rect, int R, int G, int B) {

		this.theRectangle = rect;
		this.cellColorR = R;
		this.cellColorG = G;
		this.cellColorB = B;
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
			theRectangle.setFill(Color.rgb(cellColorR, cellColorG, cellColorB, opacity));
		} else {
			if (opacity >= 1 && opacityDirection > 0) {
				opacity = 1;
				theRectangle.setFill(Color.rgb(cellColorR, cellColorG, cellColorB, opacity));
				opacityDirection = -1;
			} else {
				if (opacity <= 0 && opacityDirection < 0) {
					stop();
					opacity = 1;
					theRectangle.setFill(Color.rgb(255, 255, 255, opacity));
				}
			}
		}
	}
}
