/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myClasses;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;


/**
 *
 * @author josep
 */
public final class BFS_Class 
{  
    BufferedImage image;
    boolean[][] visited;
    Queue<Pos> Q;
    Queue<Integer> cQ;
    static int cost;
    
    static int MIN      = 0;
    static int MAX      = 301;
    
    static int Black    = 0xff000000;
    static int Gray     = 0xff222222;
    static int Green    = 0xff00ff00;
    static int Groc     = 0xffffff00;
    static int Blue     = 0xff0000ff;
    static int Red      = 0xffff0000;
    
    
    public BFS_Class(BufferedImage img, Pos cpos) 
    {
        image = img;
        visited = new boolean[MAX][MAX];
        Q = new LinkedList();
        cQ = new LinkedList();
        
        // BFS method
        BFS_Class.cost = calcBFS(cpos);
        printCostToSecDoor();
        
    }
    
    private void printCostToSecDoor() {
        System.out.println("Cost to SECDOOR: " + cost + "."); 
    }
    
    public int getColorPixel(Pos pos) 
    {
        int color_dec = image.getRGB(pos.x, pos.y);
        return color_dec;
    }
    
    public boolean isAccessible(Pos pos) 
    {
        if(pos.x < MIN || pos.x >= MAX) {
            return false;
        }
        if(pos.y < MIN || pos.y >= MAX) {
            return false;
        }
        if(BFS_Class.Black == this.getColorPixel(pos)) {
            return false;
        }
        return true;
    }
    
    public int getCostPos(Pos pos) 
    {
        if(BFS_Class.Groc   == this.getColorPixel(pos)) { return 0; }  // Target
        if(BFS_Class.Gray   == this.getColorPixel(pos)) { return 1; }  // Path
        if(BFS_Class.Blue   == this.getColorPixel(pos)) { return 2; } // Camera
        if(BFS_Class.Red    == this.getColorPixel(pos)) { return 3; } // Guard
        return -1;  //Error
    }
    
    public boolean isGoal(Pos pos) 
    {
        return (BFS_Class.Groc == this.getColorPixel(pos));
    }
    
    public void iniMat() 
    {
    for (int i = 0; i < MAX; ++i) {
            for (int j = 0; j < MAX; ++j) {
                visited[i][j] = false;
            }
        }
    }
    
    public int calcBFS(Pos cpos) 
    {        
        if (this.isAccessible(cpos) && (this.getColorPixel(cpos) == BFS_Class.Groc)) { return 0; }
        
        iniMat();
        visited[cpos.x][cpos.y] = true; 
        Q.add(cpos);
        cQ.add(0);
        
        while(!Q.isEmpty())
        {    
            int dist;
            Pos act = Q.peek();
            visited[act.x][act.y] = true;
                                  
            Pos pn = new Pos();
            pn = act.displPos("NORTH");
            if(this.isAccessible(pn) && !visited[pn.x][pn.y]) {   
                dist = cQ.peek() + this.getCostPos(pn);
                if(isGoal(pn)) { return dist+1; }
                cQ.add(dist);
                Q.add(pn);
            }
            
            Pos pe = new Pos();
            pe = act.displPos("EAST");
            if(this.isAccessible(pe) && !visited[pe.x][pe.y]) {
                dist = cQ.peek() + this.getCostPos(pe);
                if(isGoal(pe)) { return dist+1; }
                cQ.add(dist);
                Q.add(pe);
            }
            
            Pos ps = new Pos();
            ps = act.displPos("SOUTH");
            if(this.isAccessible(ps) && !visited[ps.x][ps.y]) {
                dist = cQ.peek() + this.getCostPos(ps);
                if(isGoal(ps)) { return dist+1; }
                cQ.add(dist);
                Q.add(ps);                
            }   
            
            Pos pw = new Pos();
            pw = act.displPos("WEST");
            if(this.isAccessible(pw) && !visited[pw.x][pw.y]) {
                dist = cQ.peek() + this.getCostPos(pw);
                if(isGoal(pw)) { return dist+1; }
                cQ.add(dist);
                Q.add(pw);
            } 

            Q.remove();
            cQ.remove();
        }
        return -1; 
    }
}
    


