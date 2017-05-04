package services.impl;

import org.apache.commons.lang3.ArrayUtils;

import services.IServiceTraduction;

public class ServiceTraductionJavanais implements IServiceTraduction{

	final private static char[] LISTE_VOYELLES={'A','E','I','O','U','Y'};
	
	final private static String SYLLABLE_PARASITAIRE="av";
	
	/**
	 * Decode un texte depuis du javanais
	 * - Si le mot commence par "av"+voyelle, il faut retirer le "av"
	 * - Si "av" est interposé entre une consonne et une voyelle, il faut le retirer
	 */
	@Override
	public String decode(String textJavanais) {
		StringBuilder textTraduit = new StringBuilder();
		if(textJavanais!=null && textJavanais.length()>0){
			int pos=0;
			//Si le mot commence par "av" suivi d'une voyelle, il faut retirer le "av"
			if(textJavanais.toUpperCase().startsWith(SYLLABLE_PARASITAIRE.toUpperCase()) &&
					textJavanais.length()>=pos+3 &&
					estVoyelle(textJavanais.toCharArray()[pos+2])){
				pos=pos+2;
			}
			while(pos<textJavanais.length()){
				//Ajout du caractère lu
				final char c = textJavanais.toCharArray()[pos];
				textTraduit.append(c);
				//Si un "av" est interposé entre une consonne et une voyelle, il faut retirer le "av"
				if(!estVoyelle(c) && 
						textJavanais.length()>=pos+4 &&
						 SYLLABLE_PARASITAIRE.toUpperCase().equals(textJavanais.substring(pos+1, pos+3).toUpperCase()) &&
						estVoyelle(textJavanais.toCharArray()[pos+3])){
					pos=pos+2;
				}
				//increment de la position
				pos++;
			}
		}
		return textTraduit.toString();
	}

	/**
	 * Encode un texte en javanais :
	 * - Dans un mot, “av” est ajouté entre chaque consonne suivie d’une voyelle.
	 * - Si le mot commence par une voyelle, “av” est ajouté devant cette voyelle.
	 */
	@Override
	public String encode(String text) {
		StringBuilder textJavanais = new StringBuilder();
		if(text!=null && text.length()>0){
			//Parcours des lettres du texte fourni en entrée 
			int pos=0;
			for(final char c : text.toCharArray()){
				//Cas du premier caractère : 
				if(pos==0){
					//Si le mot commence par une voyelle
					if(estVoyelle(c)){
						//Dans ce cas, ajout du prefix "av"
						textJavanais.append(SYLLABLE_PARASITAIRE);
					}
				}
				//Dans tout les cas :
				//Ajout du caractère lu
				textJavanais.append(c);
				//S'il s'agit d'une consonne(= n'est pas une voyelle) suivie d’une voyelle
				if(!estVoyelle(c) && 
					pos+1<text.length() &&
					estVoyelle(text.toCharArray()[pos+1])){
						//Alors, ajout du prefix "av"
						textJavanais.append(SYLLABLE_PARASITAIRE);
				}
				//increment de la position
				pos++;
			}
		}
		return textJavanais.toString();
	}
	
	
	/**
	 * retourne vrai si le caractere est une voyelle. 
	 */
	protected boolean estVoyelle(char c){
		return ArrayUtils.contains(LISTE_VOYELLES, Character.toUpperCase(c));
	}

}

