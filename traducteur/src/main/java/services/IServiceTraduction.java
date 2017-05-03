package services;

public interface IServiceTraduction {
	
	/**
	 * Decode un texte
	 * @param text
	 * @return
	 */
	public String decode (final String text);
	
	/**
	 * Encode un texte
	 * @param text
	 * @return
	 */
	public String encode (final String text);
}
