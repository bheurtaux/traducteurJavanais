package services.impl;

import org.junit.Assert;
import org.junit.Test;

public class TestServiceTraductionJavanais {

	private ServiceTraductionJavanais serviceTraductionJavanais = new ServiceTraductionJavanais();
	
	@Test
	public void testEncode(){
		Assert.assertEquals("bavonjavour", serviceTraductionJavanais.encode("bonjour"));
		Assert.assertEquals("chavantave", serviceTraductionJavanais.encode("chante"));
		Assert.assertEquals("mavoyen", serviceTraductionJavanais.encode("moyen"));
		Assert.assertEquals("avexavemplave", serviceTraductionJavanais.encode("exemple"));
		Assert.assertEquals("avau", serviceTraductionJavanais.encode("au"));
		
		Assert.assertEquals("bavavavonjavavavour", serviceTraductionJavanais.encode("bavonjavour"));
	}
	
	@Test
	public void testDecode(){
		Assert.assertEquals("bonjour", serviceTraductionJavanais.decode("bonjour"));
		Assert.assertEquals("chante", serviceTraductionJavanais.decode("chante"));
		Assert.assertEquals("moyen", serviceTraductionJavanais.decode("moyen"));
		Assert.assertEquals("exemple", serviceTraductionJavanais.decode("exemple"));
		Assert.assertEquals("au", serviceTraductionJavanais.decode("au"));

		Assert.assertEquals("bonjour", serviceTraductionJavanais.decode("bavonjavour"));
		Assert.assertEquals("chante", serviceTraductionJavanais.decode("chavantave"));
		Assert.assertEquals("moyen", serviceTraductionJavanais.decode("mavoyen"));
		Assert.assertEquals("exemple", serviceTraductionJavanais.decode("avexavemplave"));
		Assert.assertEquals("au", serviceTraductionJavanais.decode("avau"));
		
		Assert.assertEquals("le", serviceTraductionJavanais.decode("lave"));
		Assert.assertEquals("ja", serviceTraductionJavanais.decode("java"));
		Assert.assertEquals("jav", serviceTraductionJavanais.decode("jav"));
		Assert.assertEquals("oine", serviceTraductionJavanais.decode("avoine"));
		Assert.assertEquals("avril", serviceTraductionJavanais.decode("avril"));
	}
	
	@Test
	public void testEstVoyelle(){
		Assert.assertTrue(serviceTraductionJavanais.estVoyelle('A'));
		Assert.assertTrue(serviceTraductionJavanais.estVoyelle('a'));
		Assert.assertFalse(serviceTraductionJavanais.estVoyelle('B'));
		Assert.assertFalse(serviceTraductionJavanais.estVoyelle('b'));

	}
	
}
