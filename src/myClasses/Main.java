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

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author josep
 */
public class Main 
{   
    static BufferedImage image;
    
    public static void main(String[] args) throws Exception 
    {
        printIniMessage();
        readImage();
        ShowPNG sp = new ShowPNG("maze.png"); // since the picture is in the same directory as this class
        printInstr();        
         
        Pos p = new Pos();
        p = getIniPos();
        
        printIniPos(p);
        
        BFS_Class bfs = new BFS_Class(image, p);
    }
    
    private static Pos getIniPos() 
    {
        Pos p = new Pos(-1, -1);
        for (int i = 0; i < image.getWidth(); ++i) {
            for (int j = 0; j < image.getHeight(); ++j) {
                if(image.getRGB(i, j) == BFS_Class.Green) {
                    p = new Pos(i, j);
                    return p;
                }
            }
        }
        return p;
    }
    
    private static void printIniPos(Pos p) 
    {
        System.out.println("Starting position: (" + p.x + ", " + p.y + ")");
    }
    
    private static void printIniMessage() 
    {
        System.out.println("<< SECDOOR >>");
        System.out.println("Compute the cost to get to the security door.");
    }
    
    private static void readImage() throws IOException 
    {
        image = ImageIO.read(Main.class.getResource("maze.png"));
        System.out.println("Image \"maze.png\" read.");
    }
    
    private static void printInstr() 
    {
        System.out.println("Map Legend:");
        System.out.println("  + Grey:   Path   [cost 1]");
        System.out.println("  + Blue:   Camera [cost 2]");
        System.out.println("  + Red:    Guard  [cost 3]");
        System.out.println("  + Black:  Wall   [Not accessible]");
        System.out.println("  + Yellow: Destination");
        System.out.println("\nAlgorithm used: BFS");
    }
    
    
}
