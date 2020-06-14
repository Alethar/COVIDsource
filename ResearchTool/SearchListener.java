import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchListener implements ActionListener {
	
	private GUI gui;
	private Searcher searcher;
	
	SearchListener (GUI g, Searcher s) {
		gui = g;
		searcher = s;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		String searchTerm = gui.getSearchBarContent();
		System.out.println("Searched for: "+searchTerm);
		searcher.getSources(searchTerm.split(" "), 10);
		//TODO: Throw error if getSources returns something other than Null
		
		//Now tell GUI to load some stuff
		gui.loadSearchResults();
	}

}
