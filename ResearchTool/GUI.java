import java.awt.*;
import javax.swing.*;


public class GUI extends JFrame
{
	private JPanel searchArea;
	private JPanel taskArea;
	private JPanel mainArea;
	
	private JPanel dailyTasks;
	private JPanel articleDropoff;
	
    private JPanel searchbox;
    private JPanel searchtags;
    private JPanel searchpanels;
    
    public GUI(Main main) {
    	super("Researcher");
    	setVisible(true);
    	setSize(1600, 900);
    	
    	mainArea = new JPanel();
    	mainArea.setLayout(new BorderLayout());
    	add(mainArea);
    	
    	taskArea = new JPanel();
    	searchArea = new JPanel();
    	
    	searchArea.setBackground(Color.white);
    	taskArea.setBackground(Color.gray);

    	JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, searchArea, taskArea);
    	splitPane.setEnabled(false);
    	splitPane.setDividerSize(0);
    	splitPane.setDividerLocation(getBounds().width - 350);
    	//TODO: This needs to resize when the window size changes
    	
    	mainArea.add(splitPane, BorderLayout.CENTER);
    	
    	
    	
    	//Sidebar
    	taskArea.setLayout(new BoxLayout(taskArea, BoxLayout.Y_AXIS));
    	dailyTasks = new JPanel();
    	articleDropoff = new JPanel();
    	
    	dailyTasks.setBackground(Color.red);
    	articleDropoff.setBackground(Color.green);
    	
    	taskArea.add(dailyTasks);
    	taskArea.add(articleDropoff);
    }
}
