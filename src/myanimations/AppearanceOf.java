package myanimations;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.util.Duration;

public class AppearanceOf extends AnimationTimer {
	
	private KeyValue initKeyValue;
    private KeyFrame initFrame;
    private KeyValue endKeyValue;
    private KeyFrame endFrame;
    private Node theNode;
    private boolean choice;
    
    public AppearanceOf(Node theNode, boolean choice) {
    	
    	this.theNode = theNode;
    	this.choice = choice;
    }
	
	@Override
	public void handle(long now) {doHandle();}
	
	private void doHandle() {
		
		if (choice) {
    		initKeyValue = new KeyValue(theNode.opacityProperty(), theNode.getOpacity());
    	    initFrame = new KeyFrame(Duration.ZERO, initKeyValue);
    	    endKeyValue = new KeyValue(theNode.opacityProperty(), 1.0);
    	    endFrame = new KeyFrame(Duration.seconds(0.3), endKeyValue);
    	    theNode.setDisable(false);
    	}
    	else {
    		initKeyValue = new KeyValue(theNode.opacityProperty(), theNode.getOpacity());
    	    initFrame = new KeyFrame(Duration.ZERO, initKeyValue);
    	    endKeyValue = new KeyValue(theNode.opacityProperty(), 0.0);
    	    endFrame = new KeyFrame(Duration.seconds(0.3), endKeyValue);
    	    theNode.setDisable(true);
    	}
    	
    	Timeline timeline = new Timeline(initFrame, endFrame);
	    timeline.play();
    }
}

