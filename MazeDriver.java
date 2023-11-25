package mazes;

import java.util.List;

import search.Solver;

import search.QueueBasedBreadthFirstSearcher;
import search.RecursiveDepthFirstSearcher;
import search.StackBasedDepthFirstSearcher;
import search.Searcher;


public class MazeDriver {
    public static void main(String[] args) {
        MazeGenerator mg = new MazeGenerator(24, 8, 0);
        //MazeGenerator mg = new MazeGenerator(100, 100, 123);
        Maze m = mg.generateDFS();
        System.out.println(m.toString());
        Solver<Cell> s = new Solver<Cell>(m);
        
        /*List<Cell> r = s.solveWithRecursiveDFS();
        for (Cell cell : r) {
            System.out.println(cell);
        }
        System.out.println(r.size());
        System.out.println("--------"); */
        
        
        /*List<Cell> d = s.solveWithIterativeDFS();
        for (Cell cell : d) {
            System.out.println(cell);
        }
        System.out.println(d.size());
        System.out.println("--------"); */

        List<Cell> q = s.solveWithBFS();
		//List<Cell> q = s.solveWithRecursiveDFS();
		//List<Cell> q = s.solveWithIterativeDFS();
        for (Cell cell : q) {
            System.out.println(cell);
        }
        System.out.println(q.size());
        System.out.println("--------"); 


        Searcher<Cell> check = new QueueBasedBreadthFirstSearcher<Cell>(m);
		//Searcher<Cell> check = new RecursiveDepthFirstSearcher<Cell>(m);
		//Searcher<Cell> check = new StackBasedDepthFirstSearcher<Cell>(m);
        System.out.println(check.isValid(q));
    }
}
