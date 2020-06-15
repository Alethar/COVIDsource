import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	
	private Searcher searcher;
	private JPanel searchArea;
	private JPanel taskArea;
	private JPanel mainArea;
	private JSplitPane splitPane;
	private JPanel dailyTasks;
	
	private JTextField searchBar;
	private JPanel searchResults;
	private JPanel articleDropoff;
	private JPanel ArticleHolderArea;
	
	private Main main;
	
	/**
	 * Initialize GUI Elements. This block handles the frame and the overall layout.
	 */
	public GUI() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		super("Researcher");
		searcher = Main.s;
		setVisible(true);
		setSize(1600, 900);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		mainArea = new JPanel();
		mainArea.setLayout(new BorderLayout());
		add(mainArea);

		taskArea = new JPanel();
		searchArea = new JPanel();

		// searchArea.setBackground(Color.white);
		taskArea.setBackground(Color.gray);

		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, searchArea, taskArea);
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
		//SwingUtilities.updateComponentTreeUI(this);
		
		revalidate();
		repaint();
		
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
		SearchListener searchAction = new SearchListener();
		
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
		JPanel searchResultsHolder = new JPanel(new BorderLayout());
		searchArea.add(searchResultsHolder, BorderLayout.CENTER);
		
		searchResults = new JPanel();
		searchResults.setLayout(new BoxLayout(searchResults, BoxLayout.Y_AXIS));
		searchResults.setBackground(Color.white);
		searchResults.setBorder(new EmptyBorder(20, 50, 0, 0));
		
		//addSearchResult(new NewsArticle("title", "sampleText", "url", "smallurl", "author", 5, 5), searchResults);
		
		JScrollPane searchResultsScroll = new JScrollPane(searchResults);
		searchResultsHolder.add(searchResultsScroll, BorderLayout.CENTER);
		searchArea.add(searchResultsHolder, BorderLayout.CENTER);
	}

	/**
	 * Initializes the right part of the page
	 */
	private void initTaskbar() {
		// Sidebar
		taskArea.setLayout(new BorderLayout());
		JPanel taskAreaHolder = new JPanel();
		taskAreaHolder.setLayout(new BorderLayout());
		taskAreaHolder.setBackground(Color.WHITE);
		
		JPanel taskAreaContent = new JPanel();
		taskAreaContent.setLayout(new BoxLayout(taskAreaContent, BoxLayout.Y_AXIS));
		taskAreaHolder.add(taskAreaContent, BorderLayout.NORTH);
		
		JScrollPane taskAreaScroll = new JScrollPane(taskAreaHolder);
		taskArea.add(taskAreaHolder, BorderLayout.CENTER);

		// Logo
		JPanel logo = new JPanel();
		JLabel logoText = new JLabel("COVIDsource");
		logoText.setFont(new Font(logoText.getFont().getName(), Font.BOLD, 25));
		logo.add(logoText);
		taskAreaContent.add(logoText);
		
		//Spacing
		taskAreaContent.add(Box.createRigidArea(new Dimension(0, 50)));
		
		// Daily Tasks
		dailyTasks = new JPanel();
		dailyTasks.setLayout(new BoxLayout(dailyTasks, BoxLayout.Y_AXIS));
		
		// dailyTasks.setBackground(Color.red);
//		addTask("Reclaim the holy lands: COMPLETE", dailyTasks);
//		addTask("taskB", dailyTasks);
//		addTask("taskC", dailyTasks);
//		addTask("taskD", dailyTasks);
//		addTask("taskE", dailyTasks);
		loadTasks();

		taskAreaContent.add(dailyTasks);
		
		//Add tasks from here
		JPanel addTaskPanel = new JPanel(new BorderLayout());
		JTextField addTaskField = new JTextField();
		addTaskPanel.add(addTaskField, BorderLayout.CENTER);
		
		JButton addTaskButton = new JButton("Add");
		addTaskPanel.add(addTaskButton, BorderLayout.EAST);
		
		addTaskButton.addActionListener(new AddTaskListener(addTaskField));
		addTaskField.addActionListener(new AddTaskListener(addTaskField));
		
		taskAreaContent.add(addTaskPanel);
		
		//Spacing
		taskAreaContent.add(Box.createRigidArea(new Dimension(0, 50)));
		
		// Article Dropoff
//		articleDropoff = new JPanel();
//		JLabel dropoffLabel = new JLabel("OMNOMNOMNOMNOM");
//		dropoffLabel.setFont(new Font(logoText.getFont().getName(), Font.BOLD, 25));
//		dropoffLabel.addMouseListener(new ArticleReleaseListener());
//		
//		articleDropoff.setBackground(Color.green);
//		
//		articleDropoff.add(dropoffLabel);
//		taskAreaContent.add(articleDropoff);
		
		ArticleHolderArea = new JPanel();
		ArticleHolderArea.setLayout(new BoxLayout(ArticleHolderArea, BoxLayout.Y_AXIS));
		taskAreaContent.add(ArticleHolderArea);
	}
	
	public void loadTasks() {
		TaskManager tm = main.t;
		System.out.println(tm.tasks.get(0).text);
		
		for (Task task : tm.tasks) {
			addTask(task);
		}
	}
	
	/**
	 * Adds a task onto a list of tasks
	 * @param taskText: the text meant to be inside the task
	 * @param container: the container (with a GridBagLayout) holding the task
	 */
	public void addTask(Task task) {
		JTask t = new JTask(task, this, Main.s);
		dailyTasks.add(t);
		
		dailyTasks.revalidate();
		dailyTasks.repaint();
	}
	
	public void removeTask(int id) {
		Component[] comps = dailyTasks.getComponents();
		for (Component comp : comps) {
			JTask jTask = (JTask) comp;
			if (jTask.task.id == id) {
				dailyTasks.remove(comp);
				
				dailyTasks.revalidate();
				dailyTasks.repaint();
				break;
			}
		}
	}
	
	//Loads all search results
	public void loadSearchResults() {
		//Clear existing cache
		searchResults.removeAll();
		searchResults.revalidate();
		searchResults.repaint();
		
		//Load in new
		for (int i=0; i<searcher.getArticleNum(); i++) {
			Article art = searcher.getArticle(i);
			System.out.println(art.getName());
			
			addSearchResult(art, searchResults);
		}
		
		//SwingUtilities.updateComponentTreeUI(this);
		revalidate();
		repaint();
		
		System.out.println(searcher.getArticleNum());
	}

	public void addSearchResult(Article article, JPanel container) {
		
		//TODO: Create class for parent and attach article to it.
		//This is so the credibility score can be layed out next to it.
		//All of this can then go into the constructor for the new class.
		
		JArticlePanel parent = new JArticlePanel(article);
		
		container.add(parent);
		
		//Spacing
		container.add(Box.createRigidArea(new Dimension(0, 20)));
	}
	
	public String getSearchBarContent() {
		return searchBar.getText();
	}
	
	public void stashArticle(Article art) {
		//Avoid duplicates
		Component[] stashedArts = ArticleHolderArea.getComponents();
		for (int i=0; i<stashedArts.length; i++) {
			JStashedArticle stashedArt = (JStashedArticle) stashedArts[i];
			
			//Wee, using references. This won't cause a problem at all.
			if (art == stashedArt.art) {
				System.out.println("DUPLICATE DETECTED, ABORTING");
				return;
			}
		}
		
		JStashedArticle stashedArt = new JStashedArticle(art);
		ArticleHolderArea.add(stashedArt);
		ArticleHolderArea.revalidate();
		ArticleHolderArea.repaint();
		System.out.println("hi");
	}

	public void removeStashedArticle(Article art) {
		Component[] stashedArts = ArticleHolderArea.getComponents();
		for (int i=0; i<stashedArts.length; i++) {
			JStashedArticle stashedArt = (JStashedArticle) stashedArts[i];
			
			//Wee, using references. This won't cause a problem at all.
			if (art == stashedArt.art) {
				ArticleHolderArea.remove(stashedArt);
				ArticleHolderArea.revalidate();
				ArticleHolderArea.repaint();
				break;
			}
		}
	}
}
