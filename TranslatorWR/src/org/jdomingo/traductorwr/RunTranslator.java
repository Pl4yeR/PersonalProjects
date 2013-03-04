package org.jdomingo.traductorwr;

import java.awt.EventQueue;

public class RunTranslator {

	public RunTranslator(){
		GUI view = new GUI();
		
		Translator translator = new Translator();
		
		Controlador controller = new Controlador();
		controller.setView(view);
		controller.setTranslator(translator);

		view.addActionListener(controller);		
		view.addChangeListener(controller);	
		view.addKeyListener(controller);
		view.addListSelectionListener(controller);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new RunTranslator();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}

