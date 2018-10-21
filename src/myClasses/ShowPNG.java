/*
 * Copyright (c) 2018 josep.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    josep - initial API and implementation and/or initial documentation
 */
package myClasses;

/**
 *
 * @author josep
 */
import java.awt.*; 
import javax.swing.*; 

public class ShowPNG extends JFrame
{    
    protected ShowPNG(String arg){
      arg = "maze.png";     
      JPanel panel = new JPanel(); 
      panel.setSize(400,400);
      panel.setBackground(Color.CYAN); 
      ImageIcon icon = new ImageIcon(arg); 
      JLabel label = new JLabel(); 
      label.setIcon(icon); 
      panel.add(label);
      this.getContentPane().add(panel); 
    }
}
