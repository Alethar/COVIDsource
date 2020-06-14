import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	static GUI main;
	
	private Searcher searcher;
	private JPanel searchArea;
	private JPanel taskArea;
	private JPanel mainArea;
	
	private JTextField searchBar;
	
	/**
	 * Initialize GUI Elements. This block handles the frame and the overall layout.
	 */
	public GUI(Searcher searcher) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		super("Researcher");
		this.searcher = searcher;
		setVisible(true);
		setSize(1600, 900);
		
		if (main == null) main=this;
		else {
			System.out.println("ERROR: GUI SINGLETON BREACHED");
		}

		mainArea = new JPanel();
		mainArea.setLayout(new BorderLayout());
		add(mainArea);

		taskArea = new JPanel();
		searchArea = new JPanel();

		// searchArea.setBackground(Color.white);
		taskArea.setBackground(Color.gray);

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, searchArea, taskArea);
		splitPane.setEnabled(false);
		splitPane.setDividerSize(0);
		splitPane.setDividerLocation(getBounds().width - 350);
		// TODO: This needs to resize when the window size changes

		mainArea.add(splitPane, BorderLayout.CENTER);

		initSearch();
		initTaskbar();

		// Apparently, setting the look and feel is necessary to avoid an error thrown
		// by updateComponentTreeUI
		// And updateComponentTreeUI is to load the page
		// All because JTextField breaks absolutely everything
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	
	/**
	 * Initializes the left part of the page
	 */
	private void initSearch() {
		// Configuring overall JPanel
		searchArea.setLayout(new BorderLayout());

		// Top bar (includes search bar and the button with it)
		JPanel topBar = new JPanel();
		topBar.setLayout(new BoxLayout(topBar, BoxLayout.Y_AXIS));
		topBar.setBorder(new EmptyBorder(0, 30, 0, 0));
		topBar.add(Box.createRigidArea(new Dimension(0, 15)));
		

		// Adding items to top
		SearchAction searchAction = new SearchAction();
		
		searchBar = new JTextField(20);
		searchBar.addActionListener(searchAction);
		topBar.add(searchBar);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(searchAction);
		topBar.add(searchButton);

		// Assigning top bar to whole area container
		// (NOTE: This has to happen after topBar is fully constructed, otherwise it
		// will throw an error.)
		searchArea.add(topBar, BorderLayout.NORTH);

		// Search results
		JPanel searchResults = new JPanel();
		searchResults.setLayout(new GridBagLayout());
		searchResults.setBackground(Color.white);
		addSearchResult(searchResults);

		searchArea.add(searchResults, BorderLayout.CENTER);
	}

	/**
	 * Initializes the right part of the page
	 */
	private void initTaskbar() {
		// Sidebar
		taskArea.setLayout(new BorderLayout());
		JPanel taskAreaContent = new JPanel();
		taskAreaContent.setLayout(new BoxLayout(taskAreaContent, BoxLayout.Y_AXIS));
		taskArea.add(taskAreaContent, BorderLayout.NORTH);

		// Logo
		JPanel logo = new JPanel();
		JLabel logoText = new JLabel("COVIDsource");
		logoText.setFont(new Font(logoText.getFont().getName(), Font.BOLD, 25));
		logo.add(logoText);
		taskAreaContent.add(logoText);

		// Daily Tasks
		JPanel dailyTasks = new JPanel(new GridBagLayout());
		// dailyTasks.setBackground(Color.red);
		addTask("Reclaim the holy lands: COMPLETE", dailyTasks);
		addTask("taskB", dailyTasks);
		addTask("taskC", dailyTasks);
		addTask("taskD", dailyTasks);
		addTask("taskE", dailyTasks);

		taskAreaContent.add(dailyTasks);

		// Article Dropoff
		JPanel articleDropoff = new JPanel();
		articleDropoff.setBackground(Color.green);
		taskAreaContent.add(articleDropoff);
	}
	
	/**
	 * Adds a task onto a list of tasks
	 * @param taskText: the text meant to be inside the task
	 * @param container: the container (with a GridBagLayout) holding the task
	 */
	public void addTask(String taskText, JPanel container) {
		int rows = container.getComponentCount() / 2;

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

	public void addSearchResult(JPanel container) {
		System.out.println("TODO: insert search result.");
	}
	
	public String getSearchBarContent() {
		return searchBar.getText();
	}
}