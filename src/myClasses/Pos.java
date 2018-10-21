/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myClasses;

/**
 *
 * @author josep
 */
public class Pos {

    public int x;
    public int y;

    public Pos() {
        x = 0;
        y = 0;
    }

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pos(Pos p) {
        this.x = p.x;
        this.y = p.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void printPos() {
        System.out.println("-> Pos.x = " + this.x + " Pos.y = " + this.y);
    }
    
    public Pos displPos(String dir) 
    {
        Pos p = new Pos(-1,-1);
        if ("NORTH".equals(dir)) {
            p.x = this.x;
            p.y = this.y - 1;
        }
        if ("EAST".equals(dir))  {
            p.x = this.x + 1;
            p.y = this.y;
        }
        if ("SOUTH".equals(dir))  {
            p.x = this.x;
            p.y = this.y + 1;
        }
        if ("WEST".equals(dir))  {
            p.x = this.x - 1;
            p.y = this.y;
        }
        
        return p;
    }
}
