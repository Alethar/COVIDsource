import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

class ResizeListener extends ComponentAdapter {
	JSplitPane split;
	JFrame frame;
	ResizeListener(JSplitPane split, JFrame frame) {
		this.split = split;
		this.frame = frame;
	}

    public void componentResized(ComponentEvent e) {
        // Recalculate the variable you mentioned
    	
    	split.setDividerLocation(frame.getBounds().width - 350);
    	System.out.println("hi");
    }
}
