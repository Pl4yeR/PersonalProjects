package org.jdomingo.traductorwr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controlador 
implements ActionListener, ChangeListener, KeyListener, ListSelectionListener{

	private GUI view;
	private Translator translator;

	private List<Traduccion> traducciones = new ArrayList<Traduccion>();

	private String path;
	private String name;

	private boolean from1to2 = true;

	public Controlador(){
		path = System.getProperty("user.home").concat("/Desktop/");
		name = "translation.txt";
	}

	public GUI getView() {
		return view;
	}

	public void setView(GUI view) {
		this.view = view;
	}

	public Translator getTranslator() {
		return translator;
	}

	public void setTranslator(Translator translator) {
		this.translator = translator;
	}

	//Controlador que cambia la traducción mostrada según el elemento de la lista seleccionado.
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {
			int index = view.getListContexto().getSelectedIndex();
			if (index == -1) {
				view.getSave().setEnabled(false);
			} else {
				view.getSave().setEnabled(true);
				view.getTextTo().setText(traducciones.get(index).getTraduccion());
				view.getTextUso().setText(traducciones.get(index).getUso());            
			}
		}

	}

	//Controlador para los checks. Modifica la visibilidad del botón de guardado y borra el texto original.
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==view.getWriteToFileCheck())
			view.getSave().setVisible(view.getWriteToFileCheck().isSelected());				
	}

	//Controlador de los botones. Traduce y guarda el fichero.
	public void actionPerformed(ActionEvent evt) {
		if(evt.getSource()==view.getFrom1to2()){ 
			from1to2 = true;
			name=(view.getLanguage1()).concat("To").concat(view.getLanguage2()).concat(".txt");
			translator.setTextFrom(view.getTextFrom().getText());
			translator.setLanguageFrom(view.getLanguage1Corto());
			translator.setLanguageTo(view.getLanguage2Corto());
			translate();
		}else if(evt.getSource()==view.getFrom2to1()){
			from1to2 = false;
			name=(view.getLanguage2()).concat("To").concat(view.getLanguage1()).concat(".txt");
			translator.setTextFrom(view.getTextFrom().getText());
			translator.setLanguageFrom(view.getLanguage2Corto());
			translator.setLanguageTo(view.getLanguage1Corto());
			translate();			
		}else if(evt.getSource()==view.getSave()){
			guardarTraduccion(view.getListContexto().getSelectedIndex());
			view.getTextFrom().grabFocus();
			view.getTextFrom().requestFocusInWindow();
		}else if(evt.getSource()==view.getComboBoxIdioma1() || evt.getSource()==view.getComboBoxIdioma2()){
			String newLabel1to2 = view.getLanguage1().concat(" --> ").concat(view.getLanguage2());
			view.getFrom1to2().setText(newLabel1to2);
			String newLabel2to1 = view.getLanguage2().concat(" --> ").concat(view.getLanguage1());
			view.getFrom2to1().setText(newLabel2to1);
		}else{
			view.getTextTo().setText("Ha ocurrido un error de comando inesperado.\n");
		}

		//Make sure the new text is visible, even if there
		//was a selection in the text area.
		view.getTextTo().setCaretPosition(view.getTextTo().getDocument().getLength());
	}

	//Controlador para mostrar la traducción pulsando ENTER en el inputText original.
	public void keyPressed(KeyEvent evt) {
		if(evt.getKeyCode() == KeyEvent.VK_ENTER){
			if(from1to2){
				name=(view.getLanguage1()).concat("To").concat(view.getLanguage2()).concat(".txt");
				translator.setTextFrom(view.getTextFrom().getText());
				translator.setLanguageFrom(view.getLanguage1Corto());
				translator.setLanguageTo(view.getLanguage2Corto());
				translate();
			}else{
				name=(view.getLanguage2()).concat("To").concat(view.getLanguage1()).concat(".txt");
				translator.setTextFrom(view.getTextFrom().getText());
				translator.setLanguageFrom(view.getLanguage2Corto());
				translator.setLanguageTo(view.getLanguage1Corto());
				translate();			
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {}


	public void keyTyped(KeyEvent arg0) {}

	public void writeFile(String textFrom, String contexto, String separador, String textTo){
		boolean sucess = true;

		String linea;
		do{
			try{
				String fichero = path.concat(name);
				File f = new File(fichero);
				FileWriter w = new FileWriter(f, true);

				BufferedWriter bw = new BufferedWriter(w);

				textFrom = textFrom.replaceAll("\\r|\\n", "");
				contexto = contexto.replaceAll("\\r|\\n", "");
				textTo= textTo.replaceAll("\\r|\\n", "");

				if("".equals(contexto)){
					if("".equals(separador))
						linea = String.format("%-15s %s", textFrom,textTo);
					else
						linea = String.format("%-15s %-8s %s",textFrom, separador, textTo);
				}else{
					/*Fijamos la longitud máxima de la palabra origen*/
					String fromcontext = textFrom.concat(" (").concat(contexto).concat(")");
					if(fromcontext.length()>39)
						fromcontext = fromcontext.substring(0, 39);
					
					if("".equals(separador))
						linea = String.format("%-40s %s", fromcontext, textTo);
					else
						linea = String.format("%-40s %-8s %s",fromcontext, separador, textTo);
				}
				
				bw.append(linea);
				bw.append("\r\n");
				bw.close();
				w.close();

				sucess = true;
			}catch(IOException e){
				sucess = false;
				path = System.getProperty("user.home").concat("/Escritorio/");
				e.printStackTrace();
			};
		}while(!sucess);

	}

	private void guardarTraduccion(int index){
		if(view.getWriteToFileCheck().isSelected()){
			String from = traducciones.get(index).getTermino();
			String contexto = "";
			if(view.getIncluirContextoCheck().isSelected())
				contexto = traducciones.get(index).getContexto();
			String separador = view.getSeparador().getText();
			String to = traducciones.get(index).getTraduccion();
			writeFile(from, contexto, separador, to);
		}
	}

	private void translate(){
		traducciones.clear();
		traducciones = translator.translate();

		if(traducciones != null && !traducciones.isEmpty()){
			view.getTextTo().setText(traducciones.get(0).getTraduccion());
			view.getTextUso().setText(traducciones.get(0).getUso());
			List<String> lista = new ArrayList<String>();

			for(Traduccion t : traducciones)
				lista.add(t.getContexto());

			view.rellenaListaContexto(lista);

			if(view.getBorrarTextFromCheck().isSelected())
				view.getTextFrom().setText("");

		}else{
			view.getTextTo().setText("Translation not found.\n");
		}
	}
}