import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchAction implements ActionListener {

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Searched for: "+GUI.main.getSearchBarContent());
		
	}

}
