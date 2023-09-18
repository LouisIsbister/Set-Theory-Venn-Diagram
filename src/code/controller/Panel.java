package code.controller;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Collection;
import java.util.Set;

import javax.swing.JPanel;

import code.binarytree.BuildTree;
import code.binarytree.Coordinate;
import code.binarytree.SetNode;

/**
 * panel that displays the Venn diagrams
 */
public class Panel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * all the coordinates that are part of the 
	 * data set. 
	 */
	private Set<Coordinate> coords;

	/**
	 * all the sets in the expression
	 */
	private Collection<SetNode> setNodes;
	
	public Panel(Set<Coordinate> coords, Collection<SetNode> setNodes) {
		this.coords = coords;
		this.setNodes = setNodes;
		setPreferredSize(new Dimension(500, 500));
	}
	
	/**
	 * draw the diagrams
	 * @param g
	 */
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		// draw the shaded coordinates
		g2D.setColor(Color.green);
		for(Coordinate c : coords) {
			g2D.drawLine(c.x(), c.y(), c.x(), c.y());
		}
		
		// draw the outlines of the set "regions"
		g2D.setColor(Color.black);
		for(SetNode sn : setNodes) {
			g2D.drawOval(sn.center().x() - SetNode.DIAMETER/2, sn.center().y() - SetNode.DIAMETER/2, 
						SetNode.DIAMETER, SetNode.DIAMETER);
			g2D.drawRect(0, 0, 2 * BuildTree.START_X, 2 * BuildTree.START_Y);
			g2D.drawString(sn.toString(), sn.stringPosition().x(), sn.stringPosition().y());
		}
	}
}
