import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
	
	private Color DEEP_BLUE;
	private Color MID_BLUE;
	private Color LIGHT_BLUE;
	private Color LIGHT_GRAY;
	
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		DEEP_BLUE = new Color(52, 102, 168);
		MID_BLUE = new Color(70, 130, 210);
		LIGHT_BLUE = new Color(172, 202, 244);
		LIGHT_GRAY = new Color(240, 240, 240);

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
		topBar.setBackground(MID_BLUE);
		

		// Adding items to top
		SearchListener searchAction = new SearchListener();
		
		searchBar = new JTextField(2);
		searchBar.addActionListener(searchAction);
		searchBar.setPreferredSize(new Dimension(0, 50));
		searchBar.setBorder(new EmptyBorder(0, 0, 0, 0));
		searchBar.setFont(new Font(searchBar.getFont().getName(), Font.PLAIN, 15));
		
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("assets/search.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(138, 48, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		
		JButton searchButton = new JButton(imageIcon);
		searchButton.setBorderPainted(false); 
		searchButton.setContentAreaFilled(false); 
		searchButton.setFocusPainted(false); 
		searchButton.setOpaque(false);
		searchButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		searchButton.addActionListener(searchAction);
		searchButton.setBackground(MID_BLUE);
		
		JPanel topBarContent = new JPanel(new BorderLayout());
		topBarContent.setOpaque(false);
		topBarContent.setBorder(new EmptyBorder(0, 0, 14, 0));
		topBarContent.add(searchButton, BorderLayout.EAST);
		topBarContent.add(searchBar, BorderLayout.CENTER);
		topBar.add(topBarContent);

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
		searchResults.setBorder(new EmptyBorder(20, 30, 0, 0));
		
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
		//JLabel logoText = new JLabel("CovidSource");
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("assets/logo2.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(165, 58, Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(dimg);
		JLabel logoImg = new JLabel(imageIcon);
		logoImg.setBorder(new EmptyBorder(10, 0, 0, 15));
		//logoText.setFont(new Font(logoText.getFont().getName(), Font.BOLD, 25));
		logo.add(logoImg);
		taskAreaContent.add(logoImg);
		
		taskAreaContent.setBackground(MID_BLUE);
		
		//Spacing
		taskAreaContent.add(Box.createRigidArea(new Dimension(0, 70)));
		
		// Daily Tasks
		dailyTasks = new JPanel();
		dailyTasks.setLayout(new BoxLayout(dailyTasks, BoxLayout.Y_AXIS));
		dailyTasks.setBorder(new EmptyBorder(20, 0, 20, 0));
		
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
		
		//Task button
		BufferedImage img1 = null;
		try {
		    img1 = ImageIO.read(new File("assets/addtask.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		Image dimg1 = img1.getScaledInstance(105, 36, Image.SCALE_SMOOTH);
		ImageIcon imageIcon1 = new ImageIcon(dimg1);
		
		JButton addTaskButton = new JButton(imageIcon1);
		addTaskButton.setBorderPainted(false); 
		addTaskButton.setContentAreaFilled(false); 
		addTaskButton.setFocusPainted(false); 
		addTaskButton.setOpaque(false);
		addTaskButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		addTaskPanel.add(addTaskButton, BorderLayout.EAST);
		
		addTaskButton.addActionListener(new AddTaskListener(addTaskField));
		addTaskField.addActionListener(new AddTaskListener(addTaskField));
		addTaskPanel.setBorder(new EmptyBorder(0, 0, 20, 0));
		
		taskAreaContent.add(addTaskPanel);
		
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
