package edu.iis.powp.shape.line;

import java.awt.Color;

import edu.kis.powp.drawer.shape.ILine;
import edu.kis.powp.drawer.shape.LineFactory;

public class MyLineFactory extends LineFactory {
	public static ILine getCustomLine(Color c, float thickness, boolean isDotted)
	{
		return new CustomLine(c, thickness, isDotted);
		
	}
}
