import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchAction implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		String searchTerm = GUI.main.getSearchBarContent();
		System.out.println("Searched for: "+searchTerm);
		Searcher.main.getSources(searchTerm, 10);
	}

}
