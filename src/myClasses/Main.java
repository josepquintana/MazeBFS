/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myClasses;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;
import javax.imageio.ImageIO;

/**
 *
 * @author josep
 */
public class Main {
   
    static BufferedImage image;
    static int cost;
    static int MIN      = 0;
    static int MAX      = 301;
    static int Black    = 0xff000000;
    static int Gray     = 0xff222222;
    static int Green    = 0xff00ff00;
    static int Groc     = 0xffffff00;
    static int Blue     = 0xff0000ff;
    static int Red      = 0xffff0000;
    
    public static void main(String[] args) throws Exception 
    {
        System.out.println("Reading image:");
        image = ImageIO.read(Main.class.getResource("maze.png"));
         
        Pos p = new Pos(1, 0);
        
        BFS_Class bfs = new BFS_Class(image, p);
      /*
        calcCost(p);
        
        
        
        while()
        int d1 = BFS_Class bfs = new BFS_Class(image, p);
        int d1 = BFS_Class bfs = new BFS_Class(image, p);
        int d1 = BFS_Class bfs = new BFS_Class(image, p);
        int d1 = BFS_Class bfs = new BFS_Class(image, p);

*/

    }
    /*
    public boolean TargetFound(Pos p) {
        return (image.getRGB(p.x, p.y) == Main.Groc);
    }         

    public void calcCost(Pos p_ini) {
        
        Pos p = new Pos(p_ini);
        
        while(!TargetFound(p)) {
            
        }
    }*/
    
}
    


