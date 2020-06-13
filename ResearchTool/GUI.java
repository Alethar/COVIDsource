import java.awt.*;
import javax.swing.*;


public class GUI extends JFrame
{
	private Searcher searcher;
	private JPanel searchArea;
	private JPanel taskArea;
	private JPanel mainArea;
	
    private JPanel searchbox;
    private JPanel searchtags;
    private JPanel searchpanels;
    
    public GUI(Searcher searcher) {
    	super("Researcher");
    	this.searcher = searcher;
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
    	taskArea.setLayout(new BorderLayout());
    	JPanel taskAreaContent = new JPanel();
    	taskAreaContent.setLayout(new BoxLayout(taskAreaContent, BoxLayout.Y_AXIS));
    	taskArea.add(taskAreaContent, BorderLayout.NORTH);
    	
    	//Logo
    	JPanel logo = new JPanel();
    	JLabel logoText = new JLabel("COVIDsource");
    	logoText.setFont(new Font(logoText.getFont().getName(), Font.BOLD, 25));
    	logo.add(logoText);
    	taskAreaContent.add(logoText);
    	
    	//Daily Tasks
    	JPanel dailyTasks = new JPanel(new GridBagLayout());
    	//dailyTasks.setBackground(Color.red);
    	addTask("Reclaim the holy lands: COMPLETE", dailyTasks);
    	addTask("taskB", dailyTasks);
    	addTask("taskC", dailyTasks);
    	addTask("taskD", dailyTasks);
    	addTask("taskE", dailyTasks);
    	
    	taskAreaContent.add(dailyTasks);
    	
    	//Article Dropoff
    	JPanel articleDropoff = new JPanel();
    	articleDropoff.setBackground(Color.green);
    	taskAreaContent.add(articleDropoff);
    }
    
    public void addTask(String taskText, JPanel container) {
    	if (!(container.getLayout() instanceof GridBagConstraints)) {
    		System.out.println("ERROR: Wrong layout type.");
    	}
    	
    	int rows = container.getComponentCount()/2;
    	
    	JLabel task = new JLabel(taskText);
    	GridBagConstraints taskGBC = new GridBagConstraints();
    	taskGBC.gridx = 0;
    	taskGBC.gridy = rows;
    	taskGBC.weightx = 1;
    	container.add(task, taskGBC);
    	
    	JCheckBox checkBox = new JCheckBox();
    	GridBagConstraints checkBoxGBC = new GridBagConstraints();
    	checkBoxGBC.gridx = 1;
    	checkBoxGBC.gridy = rows;
    	checkBoxGBC.weightx = 0.5;
    	container.add(checkBox, checkBoxGBC);
    }
}