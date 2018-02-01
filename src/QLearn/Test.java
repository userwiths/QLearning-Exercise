/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLearn;

import java.util.*;

public class Test {
    public static void PredefineTable(){
        int[][] maze=new int[][]{
                                { 0, 0, 0,-1, 0},
                                {-1,-1, 0, 0, 0},
                                { 0, 0, 0,-1,-1},
                                {-1, 0,-1,-1,-1},
                                {-1, 0, 0, 0, 1}
                                };
        Mind brain=new Mind();
        brain.SetSquareTable(maze);
        brain.MatrixForm();
        //Start of tests.
        brain.ForceSuccess();
        for(int i=0;i<5;i++){
            brain.SetVariable("epsilon",1.0/((i+1)*10));
            brain.StartGeneral(0,100);
            brain.Status();
        }
    }
    
    public static void main(String[] arg){
        Scanner in=new Scanner(System.in);
        int size=100;
        
        Mind brain=new Mind();
        brain.RandomTable(size, 0.13, 10);
        brain.MatrixForm();
        brain.ForceSuccess();
        
        for(int i=0;i<1000;i++){
            brain.SetVariable("epsilon",1.0/(i+1));
            brain.StartRandom(1000);
            if(brain.Use("win") == 1000){
                System.out.println("After "+((i+1)*1000)+" generations: ");
                brain.Status();
                break;
            }
            if(i==0){
                System.out.println("Results after 1000 generations: ");
                brain.Status();
            }
            brain.SetVariable("win", 0.0);
            brain.SetVariable("lost", 0.0);
        }
        //PredefineTable();
    }
}