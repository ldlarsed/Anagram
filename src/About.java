import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class About extends JDialog implements ActionListener{

	private JEditorPane aboutText;
	private JButton btn_ok;
	private JPanel mainPanel;

	public About(JFrame parent) {
		super(parent, "About Anagram finder", true);
		
		aboutText = new JEditorPane();
		aboutText.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
		aboutText.setPreferredSize(new Dimension(300, 200));
		btn_ok = new JButton(Strings._OK);
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(aboutText, BorderLayout.CENTER);
		mainPanel.add(btn_ok, BorderLayout.SOUTH);
		aboutText.setText(Strings._aboutTxt);
		aboutText.setEditable(false);
		btn_ok.addActionListener(this);
		
		
		this.add(mainPanel);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == btn_ok)
			this.dispose();
	}
}
