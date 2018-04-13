package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test
* 
* @author Andreas Horn
* @version$Id$
* @since 0.1
*/
public class CalculateTest{
	/*
	* Test echo
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName(){
		String inputName = "Andreas Horn";
		String expected = "Echo echo echo: Andreas Horn";
		Calculate myCalc = new Calculate();
		String result = myCalc.echo(inputName);
		assertThat(result, is(expected) );
	}
}