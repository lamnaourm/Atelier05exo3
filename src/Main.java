import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txt_val1;
	private JTextField txt_val2;
	private JLabel lblNombre_2;
	private JLabel lbl_op;
	private JTextField txt_res;
	private JLabel lblResultat;
	private JButton btnCalculer;
	private JButton btnRaz;
	private JButton btnFermer;
	private JPanel panel_1;
	private JRadioButton rdbtnAddition;
	private JRadioButton rdbtnSoustraction;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnDivision;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(10, 11, 270, 198);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre 1 : ");
		lblNombre.setBounds(10, 25, 61, 14);
		panel.add(lblNombre);
		
		txt_val1 = new JTextField();
		txt_val1.setBounds(118, 19, 116, 20);
		txt_val1.setDocument(new ControleDecimal());
		panel.add(txt_val1);
		txt_val1.setColumns(10);
		
		txt_val2 = new JTextField();
		txt_val2.setColumns(10);
		txt_val2.setDocument(new ControleDecimal());
		txt_val2.setBounds(118, 99, 116, 20);
		panel.add(txt_val2);
		
		lblNombre_2 = new JLabel("Nombre 2 : ");
		lblNombre_2.setBounds(10, 105, 61, 14);
		panel.add(lblNombre_2);
		
		lbl_op = new JLabel("+");
		lbl_op.setBorder(new LineBorder(Color.GREEN));
		lbl_op.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_op.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_op.setBounds(91, 58, 46, 30);
		panel.add(lbl_op);
		
		txt_res = new JTextField();
		txt_res.setEditable(false);
		txt_res.setColumns(10);
		txt_res.setBounds(118, 152, 116, 20);
		panel.add(txt_res);
		
		lblResultat = new JLabel("Resultat :");
		lblResultat.setBounds(10, 155, 61, 14);
		panel.add(lblResultat);
		
		btnCalculer = new JButton("Calculer");
		btnCalculer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txt_val1.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Valeur 1 vide");
					txt_val1.requestFocus();
					return;
				}
				if(txt_val2.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Valeur 2 vide");
					txt_val2.requestFocus();
					return;
				}
				
				double val1 = Double.parseDouble(txt_val1.getText()); 
				double val2 = Double.parseDouble(txt_val2.getText());
				if(rdbtnAddition.isSelected()) {
					txt_res.setText(String.valueOf(val1+val2));
				}else if(rdbtnDivision.isSelected()) {
					if(val2==0)
						JOptionPane.showMessageDialog(null, "Operation Impossible");
					
					txt_res.setText(String.valueOf(val1/val2));
				}else if(rdbtnSoustraction.isSelected()) {
					txt_res.setText(String.valueOf(val1-val2));
				}else {
					txt_res.setText(String.valueOf(val1*val2));
				}
			}
		});
		btnCalculer.setBounds(10, 220, 89, 23);
		contentPane.add(btnCalculer);
		
		btnRaz = new JButton("RAZ");
		btnRaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_val1.setText("");
				txt_val2.setText("");
				txt_res.setText("");
				txt_val1.requestFocus();
				rdbtnAddition.setSelected(true);
			}
		});
		btnRaz.setBounds(110, 220, 89, 23);
		contentPane.add(btnRaz);
		
		btnFermer = new JButton("Fermer");
		btnFermer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFermer.setBounds(346, 220, 89, 23);
		contentPane.add(btnFermer);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Operations", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(290, 11, 145, 198);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		ItemListener i = (e) -> {
			if(rdbtnAddition.isSelected()) {
				lbl_op.setText("+");
			}else if(rdbtnDivision.isSelected()) {
				lbl_op.setText("/");
			}else if(rdbtnSoustraction.isSelected()) {
				lbl_op.setText("-");
			}else {
				lbl_op.setText("*");
			}
		};
		
		rdbtnAddition = new JRadioButton("Addition");
		rdbtnAddition.addItemListener(i);
		rdbtnAddition.setSelected(true);
		buttonGroup.add(rdbtnAddition);
		rdbtnAddition.setBounds(16, 21, 109, 23);
		panel_1.add(rdbtnAddition);
		
		rdbtnSoustraction = new JRadioButton("Soustraction");
		rdbtnSoustraction.addItemListener(i);
		buttonGroup.add(rdbtnSoustraction);
		rdbtnSoustraction.setBounds(16, 65, 109, 23);
		panel_1.add(rdbtnSoustraction);
		
		rdbtnNewRadioButton = new JRadioButton("Produit");
		rdbtnNewRadioButton.addItemListener(i);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(16, 109, 109, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		rdbtnDivision = new JRadioButton("Division");
		rdbtnDivision.addItemListener(i);
		buttonGroup.add(rdbtnDivision);
		rdbtnDivision.setBounds(16, 153, 109, 23);
		panel_1.add(rdbtnDivision);
	}
}
