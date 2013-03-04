package org.jdomingo.traductorwr;

import com.baseprogramming.lang.DictionaryTerm;
import com.baseprogramming.lang.Translation;
import com.baseprogramming.lang.WordReference;

import java.util.ArrayList;
import java.util.List;

public class Translator {
	private static String clientId = "TraductorImba";
	private static String clientSecret = "cLaqmaJ3Id3jMbA/S5BGbgmj9XUJRa6k2Np6q7VD46E=";

	private String textFrom;
	List<Traduccion> traduccion = new ArrayList<Traduccion>();

	private String languageFrom = "en";
	private String languageTo = "es";

	private String MyKey = "8c98b";
	private static String LocalLib="$HOME";

	public Translator(){

	}

	public String getTextFrom() {
		return textFrom;
	}
	public void setTextFrom(String textFrom) {
		this.textFrom = textFrom;
	}

	public List<Traduccion> getTraduccion() {
		return traduccion;
	}

	public void setTraduccion(List<Traduccion> traduccion) {
		this.traduccion = traduccion;
	}

	public String getLanguageFrom() {
		return languageFrom;
	}
	public void setLanguageFrom(String languageFrom) {
		this.languageFrom = languageFrom;
	}
	public String getLanguageTo() {
		return languageTo;
	}
	public void setLanguageTo(String languageTo) {
		this.languageTo = languageTo;
	}

	public static String getClientId() {
		return clientId;
	}

	public static void setClientId(String clientId) {
		Translator.clientId = clientId;
	}

	public static String getClientSecret() {
		return clientSecret;
	}

	public static void setClientSecret(String clientSecret) {
		Translator.clientSecret = clientSecret;
	}

	public List<Traduccion> translate(){
		WordReference wr= new WordReference(MyKey);
		wr.setLocalLibrary(LocalLib);
		traduccion.clear();
		try
		{	
			List<Translation> list= new ArrayList<Translation>();
			
			wr.setSourceLanguage(languageFrom);
			wr.setTargetLanguage(languageTo);
			
			list=wr.translate(textFrom);
			
			for(Translation trx : list){
				
		        DictionaryTerm original=trx.getOriginalTerm();
		        DictionaryTerm trans = trx.getFirstTranslation();
		        
		        String termino = textFrom;
		        String terminoTraducido = trans.getTerm();
		        String contexto = original.getSence();
		        String uso = "";//original.getUsage().concat("\n").concat(trans.getUsage());
		        
		        Traduccion t = new Traduccion(termino, terminoTraducido, contexto, uso);
		        
		        traduccion.add(t);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return traduccion;
	}
	
}

