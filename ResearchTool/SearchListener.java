import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchListener implements ActionListener {

	SearchListener () {
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Searcher searcher = Main.s;
		GUI gui = Main.g;
		
		searcher.clearSources();
		
		String searchTerm = gui.getSearchBarContent();
		System.out.println("Searched for: "+searchTerm);
		
		//Convert to ArrayList
		String[] termsArr = searchTerm.split(" ");
		ArrayList<String> terms = new ArrayList<>();
		for (String str: termsArr) terms.add(str);

		searcher.getSources(terms, 30);
		//TODO: Throw error if getSources returns something other than Null
				
		
		//Now tell GUI to load some stuff
		gui.loadSearchResults();
	}

}
