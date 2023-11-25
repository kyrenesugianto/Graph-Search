package search;

import java.util.List;
import java.util.Stack;

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Stack. This results in a
 * depth-first search.
 * 
 */
public class StackBasedDepthFirstSearcher<T> extends Searcher<T> {
	
	public StackBasedDepthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
	}

	// starts at the root node and explores as far as possible along each branch before backtracking
	@Override
	public List<T> solve() {
		// TODO 
		Stack<T> stack = new Stack<T>(); 
		stack.push(searchProblem.getInitialState());
		visitedStates.add(searchProblem.getInitialState());
		T item = null;
		while (!stack.isEmpty()) {
			item = getNextUnvisitedNeighbor(stack.peek());
			if (searchProblem.isGoalState(item)) {
				stack.push(item);
				return stack;
			}
			if (item == null) {
				stack.pop();
			}
			else {
				visitedStates.add(item);
				stack.push(item);
			}
		}
		return stack;
	}

	private T getNextUnvisitedNeighbor(T item) {
		for(T node : searchProblem.getSuccessors(item)) {
			if(!visitedStates.contains(node)) {
				return node;
			}
		}
		return null;
	}


}
