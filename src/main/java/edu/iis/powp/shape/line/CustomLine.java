package edu.iis.powp.shape.line;

import java.awt.Color;

import edu.kis.powp.drawer.shape.line.AbstractLine;

public class CustomLine extends AbstractLine {

	public CustomLine(Color c, float thickness, boolean isDotted) {
		super();
	    color = c;
	    this.thickness = thickness;
	    dotted = isDotted;
	}
}
