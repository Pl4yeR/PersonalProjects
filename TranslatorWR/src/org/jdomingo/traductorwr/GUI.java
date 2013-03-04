package org.jdomingo.traductorwr;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JComboBox;

public class GUI {

	private JFrame frame;
	private JTextField textFrom;
	private JTextField textTo;
	private JTextArea textUso;
	private DefaultListModel listaContextoModel;
	private JList listContexto;
	private JButton save;
	private JCheckBox writeToFileCheck;
	private JCheckBox incluirContextoCheck;
	private JCheckBox borrarTextFromCheck;
	private JTextField separador;
	private JButton from1to2;
	private JButton from2to1;
	private JComboBox comboBoxIdioma1;
	private JComboBox comboBoxIdioma2;

	String[] idiomas = {"English", "Spanish", "French", "German", "Italian", "Portuguese"};
	String[] idiomasCortos = {"en", "es", "fr", "de", "it","pt"};

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Traductor (WordReference)");
		frame.setBounds(100, 100, 600, 420);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridBagLayout());
		frame.setVisible(true);

		JLabel lblNewLabel = new JLabel("Palabra a traducir");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets=new Insets(10, 0, 2, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		gbc_lblNewLabel.weightx = 1;
		gbc_lblNewLabel.gridwidth=2;
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		textFrom = new JTextField(15);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 5, 0, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		gbc_textField.weightx=1;
		gbc_textField.gridwidth=2;
		frame.getContentPane().add(textFrom, gbc_textField);
		textFrom.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Traducci\u00F3n");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets=new Insets(8, 0, 2, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		gbc_lblNewLabel_1.weightx=1;
		gbc_lblNewLabel_1.gridwidth=2;
		gbc_lblNewLabel_1.fill=GridBagConstraints.HORIZONTAL;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Contexto: ");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 5, 2, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
			
		JLabel lblTraduccin = new JLabel("Traducci\u00F3n: ");
		lblTraduccin.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_lblTraduccin = new GridBagConstraints();
		gbc_lblTraduccin.insets = new Insets(0, 2, 2, 5);
		gbc_lblTraduccin.gridx = 1;
		gbc_lblTraduccin.gridy = 3;
		frame.getContentPane().add(lblTraduccin, gbc_lblTraduccin);
		
		listaContextoModel = new DefaultListModel();
		listContexto = new JList(listaContextoModel);
		listContexto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_panel_list = new GridBagConstraints();
		gbc_panel_list.insets=new Insets(0, 5, 0, 2);
		gbc_panel_list.gridx = 0;
		gbc_panel_list.gridy = 4;
		gbc_panel_list.gridheight=4;
		gbc_panel_list.weightx=0.5;
		gbc_panel_list.weighty=1;
		gbc_panel_list.fill=GridBagConstraints.BOTH;
		
		JScrollPane scrollPane = new JScrollPane(listContexto);
		frame.getContentPane().add(scrollPane, gbc_panel_list);

		textTo = new JTextField(12);
		textTo.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 2, 0, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		gbc_textField_1.weightx = 0.5;
		gbc_textField_1.fill=GridBagConstraints.BOTH;
		frame.getContentPane().add(textTo, gbc_textField_1);
		textTo.setColumns(10);
		
		JLabel lblUso = new JLabel("Uso: ");
		lblUso.setFont(new Font("Dialog", Font.BOLD, 11));
		GridBagConstraints gbc_lblUso = new GridBagConstraints();
		gbc_lblUso.insets = new Insets(0, 2, 2, 5);
		gbc_lblUso.gridx = 1;
		gbc_lblUso.gridy = 5;
		frame.getContentPane().add(lblUso, gbc_lblUso);

		textUso = new JTextArea(12,30);
		textUso.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.insets = new Insets(0, 2, 0, 5);
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 6;
		gbc_textArea.weighty=1;
		gbc_textArea.weightx = 0.5;
		frame.getContentPane().add(textUso, gbc_textArea);
		
		
		save = new JButton("Guardar");
		save.setEnabled(false);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill=GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(1, 2, 0, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 7;
		gbc_button.weightx = 0.5;
		frame.getContentPane().add(save, gbc_button);

		GridBagLayout gbl_panelOpciones = new GridBagLayout();
		gbl_panelOpciones.columnWeights = new double[]{1.0, 0.0};
		JPanel panelOpciones = new JPanel(gbl_panelOpciones);
		panelOpciones.setAlignmentY(SwingConstants.LEFT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(8, 5, 0, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		gbc_panel.gridwidth = 2;
		gbc_panel.weightx=1;
		gbc_panel.fill=GridBagConstraints.BOTH;
		frame.getContentPane().add(panelOpciones, gbc_panel);

		writeToFileCheck = new JCheckBox("\u00BFHabilitar el guardado?",true);
		writeToFileCheck.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 0;
		gbc_chckbxNewCheckBox.fill=GridBagConstraints.HORIZONTAL;
		gbc_chckbxNewCheckBox.weightx=1;
		panelOpciones.add(writeToFileCheck, gbc_chckbxNewCheckBox);
		
		incluirContextoCheck = new JCheckBox("\u00BFIncluir contexto en el guardado?",false);
		incluirContextoCheck.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxincluirContextoEn = new GridBagConstraints();
		gbc_chckbxincluirContextoEn.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxincluirContextoEn.gridx = 0;
		gbc_chckbxincluirContextoEn.gridy = 1;
		gbc_chckbxincluirContextoEn.fill=GridBagConstraints.HORIZONTAL;
		gbc_chckbxincluirContextoEn.weightx=1;
		panelOpciones.add(incluirContextoCheck, gbc_chckbxincluirContextoEn);

		borrarTextFromCheck = new JCheckBox("\u00BFBorrar palabra origen tras traducir?");
		borrarTextFromCheck.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox1.gridx = 0;
		gbc_chckbxNewCheckBox1.gridy = 2;
		gbc_chckbxNewCheckBox1.fill= GridBagConstraints.HORIZONTAL;
		gbc_chckbxNewCheckBox1.weightx=1;
		panelOpciones.add(borrarTextFromCheck, gbc_chckbxNewCheckBox1);

		JLabel lblNewLabel_2 = new JLabel("Usar este separador (en blanco para 2 columnas): ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		gbc_lblNewLabel_2.fill=GridBagConstraints.HORIZONTAL;
		panelOpciones.add(lblNewLabel_2, gbc_lblNewLabel_2);

		separador = new JTextField();
		separador.setColumns(7);
		GridBagConstraints gbc_textField1 = new GridBagConstraints();
		gbc_textField1.gridx = 1;
		gbc_textField1.gridy = 3;
		gbc_textField1.fill=GridBagConstraints.HORIZONTAL;
		gbc_textField1.weightx=1;
		panelOpciones.add(separador, gbc_textField1);

		JPanel panelIdioma = new JPanel(new GridLayout(2,2));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 4;
		gbc_comboBox.gridwidth = 2;
		panelOpciones.add(panelIdioma, gbc_comboBox);
		
		JLabel labelIdioma1 = new JLabel("Traducir de: ");
		JLabel labelIdioma2 = new JLabel("Traducir a: ");
		
		comboBoxIdioma1 = new JComboBox(idiomas);
		comboBoxIdioma1.setSelectedIndex(0);

		comboBoxIdioma2 = new JComboBox(idiomas);
		comboBoxIdioma2.setSelectedIndex(1);
		
		panelIdioma.add(labelIdioma1);
		panelIdioma.add(labelIdioma2);
		panelIdioma.add(comboBoxIdioma1);
		panelIdioma.add(comboBoxIdioma2);
		
		JPanel panelBotones = new JPanel(new GridLayout(1,2));
		GridBagConstraints gbc_panel2 = new GridBagConstraints();
		gbc_panel2.insets=new Insets(5, 5, 5, 5);
		gbc_panel2.gridx=0;
		gbc_panel2.gridy=9;
		gbc_panel2.gridwidth=2;
		gbc_panel2.fill=GridBagConstraints.HORIZONTAL;
		gbc_panel2.weightx=1;
		frame.getContentPane().add(panelBotones,gbc_panel2);	

		from1to2 = new JButton();
		String labelfrom1to2 = getLanguage1().concat(" --> ").concat(getLanguage2());
		from1to2.setText(labelfrom1to2);
		from1to2.setFont(new Font("Dialog", Font.BOLD, 14));
		panelBotones.add(from1to2);

		from2to1 = new JButton();
		String labelfrom2to1 = getLanguage2().concat(" --> ").concat(getLanguage1());
		from2to1.setText(labelfrom2to1);
		from2to1.setFont(new Font("Dialog", Font.BOLD, 14));
		panelBotones.add(from2to1);

	}

	public JTextField getTextFrom() {
		return textFrom;
	}

	public void setTextFrom(JTextField textFrom) {
		this.textFrom = textFrom;
	}

	public JTextField getTextTo() {
		return textTo;
	}

	public void setTextTo(JTextField textTo) {
		this.textTo = textTo;
	}

	public JTextArea getTextUso() {
		return textUso;
	}

	public void setTextUso(JTextArea textUso) {
		this.textUso = textUso;
	}

	public DefaultListModel getListaContextoModel() {
		return listaContextoModel;
	}

	public void setListaContextoModel(DefaultListModel listaContextoModel) {
		this.listaContextoModel = listaContextoModel;
	}

	public JList getListContexto() {
		return listContexto;
	}

	public void setListContexto(JList listContexto) {
		this.listContexto = listContexto;
	}

	public JButton getSave() {
		return save;
	}

	public void setSave(JButton save) {
		this.save = save;
	}

	public JCheckBox getWriteToFileCheck() {
		return writeToFileCheck;
	}

	public void setWriteToFileCheck(JCheckBox writeToFileCheck) {
		this.writeToFileCheck = writeToFileCheck;
	}

	public JCheckBox getIncluirContextoCheck() {
		return incluirContextoCheck;
	}

	public void setIncluirContextoCheck(JCheckBox incluirContextoCheck) {
		this.incluirContextoCheck = incluirContextoCheck;
	}

	public JCheckBox getBorrarTextFromCheck() {
		return borrarTextFromCheck;
	}

	public void setBorrarTextFromCheck(JCheckBox borrarTextFromCheck) {
		this.borrarTextFromCheck = borrarTextFromCheck;
	}

	public JTextField getSeparador() {
		return separador;
	}

	public void setSeparador(JTextField separador) {
		this.separador = separador;
	}

	public JButton getFrom1to2() {
		return from1to2;
	}

	public void setFrom1to2(JButton from1to2) {
		this.from1to2 = from1to2;
	}

	public JButton getFrom2to1() {
		return from2to1;
	}

	public void setFrom2to1(JButton from2to1) {
		this.from2to1 = from2to1;
	}

	public JComboBox getComboBoxIdioma1() {
		return comboBoxIdioma1;
	}

	public void setComboBoxIdioma1(JComboBox comboBoxIdioma1) {
		this.comboBoxIdioma1 = comboBoxIdioma1;
	}

	public JComboBox getComboBoxIdioma2() {
		return comboBoxIdioma2;
	}

	public void setComboBoxIdioma2(JComboBox comboBoxIdioma2) {
		this.comboBoxIdioma2 = comboBoxIdioma2;
	}
	
	public String getLanguage1(){
		return idiomas[comboBoxIdioma1.getSelectedIndex()];
	}
	
	public String getLanguage2(){
		return idiomas[comboBoxIdioma2.getSelectedIndex()];
	}
	
	public String getLanguage1Corto(){
		return idiomasCortos[comboBoxIdioma1.getSelectedIndex()];
	}
	
	public String getLanguage2Corto(){
		return idiomasCortos[comboBoxIdioma2.getSelectedIndex()];
	}

	public void rellenaListaContexto(List<String> lista){
		listaContextoModel.removeAllElements();
		for(String s: lista)
			listaContextoModel.addElement(s);
		listContexto.setSelectedIndex(0);
	}

	public void addActionListener(ActionListener controller){
		from1to2.addActionListener(controller);
		from2to1.addActionListener(controller);
		save.addActionListener(controller);
		comboBoxIdioma1.addActionListener(controller);
		comboBoxIdioma2.addActionListener(controller);
	} 
	
	public void addChangeListener(ChangeListener controller){
		writeToFileCheck.addChangeListener(controller);
		borrarTextFromCheck.addChangeListener(controller);
	}
	
	public void addKeyListener(KeyListener controller){
		textFrom.addKeyListener(controller);
	}
	
	public void addListSelectionListener(ListSelectionListener controller){
		listContexto.addListSelectionListener(controller);
	}
	
}
