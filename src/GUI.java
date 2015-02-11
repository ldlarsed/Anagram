import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class GUI extends JFrame {

	private JMenuBar menuBar;
	private JMenu fileMenu, helpMenu;
	private JMenuItem quitMenuItem, aboutMenuItem;

	private JTextField txtF_file_path;
	private JButton btn_file_open, btn_search, btn_close;
	private JLabel lbl_counter;
	private JScrollPane scroll;

	private JPanel p_menu_panel, p_file_panel, p_counter_panel, p_component_panel, p_button_panel,
			p_wrapper;

	private JTextArea textA_output;

	public GUI() {
		super(Strings._title);

		// Menu
		menuBar = new JMenuBar();
		fileMenu = new JMenu(Strings._menFile);
		helpMenu = new JMenu(Strings._menHelp);
		quitMenuItem = new JMenuItem(Strings._menQuit);
		aboutMenuItem = new JMenuItem(Strings._menAbout);
		fileMenu.add(quitMenuItem);
		helpMenu.add(aboutMenuItem);
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		// GUI components
		txtF_file_path = new JTextField(Const.txtF_size);
		txtF_file_path.setEditable(false);
		btn_file_open = new JButton(Strings._btnBrowse);
		lbl_counter = new JLabel("0");
		lbl_counter.setHorizontalAlignment(JLabel.CENTER);
		Font lbl_font = lbl_counter.getFont();
		lbl_counter.setFont(new Font(lbl_font.getName(), Font.PLAIN, 20));
		textA_output = new JTextArea(20,20);
//		textA_output.setPreferredSize(new Dimension(5, 10));
		textA_output.setBorder(new TitledBorder(Strings._output));
		scroll = new JScrollPane(textA_output);
		btn_search = new JButton(Strings._btnSearch);
		btn_close = new JButton(Strings._btnClose);

		// Panels
		p_menu_panel = new JPanel(new BorderLayout());
		p_menu_panel.add(menuBar, BorderLayout.LINE_START);

		p_file_panel = new JPanel(new BorderLayout());
		p_file_panel.setBorder(BorderFactory.createTitledBorder(Strings._file));
		p_file_panel.add(txtF_file_path, BorderLayout.LINE_START);
		p_file_panel.add(btn_file_open, BorderLayout.EAST);
		
		p_counter_panel = new JPanel(new BorderLayout());
		p_counter_panel.setBorder(new TitledBorder(Strings._count));
		p_counter_panel.add(lbl_counter, BorderLayout.CENTER);
		
		p_component_panel = new JPanel(new BorderLayout());
		p_component_panel.add(p_menu_panel, BorderLayout.NORTH);
		p_component_panel.add(p_file_panel, BorderLayout.CENTER);
		p_component_panel.add(p_counter_panel, BorderLayout.SOUTH);
		
		p_button_panel = new JPanel(new BorderLayout());
		p_button_panel.add(btn_search, BorderLayout.CENTER);
		p_button_panel.add(btn_close, BorderLayout.LINE_END);

		p_wrapper = new JPanel(new BorderLayout());
		p_wrapper.setBorder(BorderFactory.createLineBorder(Const.col_bord));
		p_wrapper.add(p_component_panel,BorderLayout.NORTH);
		p_wrapper.add(scroll, BorderLayout.CENTER);
		p_wrapper.add(p_button_panel, BorderLayout.SOUTH);

		// JFrame
		this.add(p_wrapper);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
