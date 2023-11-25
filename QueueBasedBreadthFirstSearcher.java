package search;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Queue. This results in a
 * breadth-first search.
 * 
 */
public class QueueBasedBreadthFirstSearcher<T> extends Searcher<T> {
	private final List<T> states;
	private final List<T> predecessors;

	public QueueBasedBreadthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
		states = new ArrayList<T>();
		predecessors = new ArrayList<T>();

	}

	@Override
	public List<T> solve() {
        // TODO
		if (solution != null) {
			return solution;
		}

		final T initialState = searchProblem.getInitialState();
		// add the initial state to the list of states and predecessors
		states.add(initialState);
		// initially it is marked as its own predecessor, but this is updated
		// in the recursive helper
		predecessors.add(initialState);

		// store the goal that was found (if any) in current
		T current = getBFSGoal(initialState);
		final List<T> path = new ArrayList<T>();

		// if a goal was found
		if (current != null) {
			// build a path by looking up each predecessor, starting from
			// the goal state
			path.add(current);
			while (!current.equals(searchProblem.getInitialState())) {
				final T predecessor = predecessors.get(states.indexOf(current));
				path.add(predecessor);
				current = predecessor;
			}

			// the path is in reverse order (goal-to-initial), so we reverse
			// it into the correct order
			Collections.reverse(path);
		}
		if (path.size() > 0) {
			if (!isValid(path)) {
				throw new RuntimeException(
						"searcher should never find an invalid solution!");
			}
		}
		return path;
	}

	private T getBFSGoal(T state) {
		T item = state;
		Queue<T> queue = new LinkedList<T>();

		queue.add(item);

		while(!queue.isEmpty()) {
			item = queue.poll();
			if (searchProblem.isGoalState(item)) {
				return item;
			}
			if(item == null) {
				queue.poll();
			}
			else {
				for(T neighbor : searchProblem.getSuccessors(item)) {
					//if this neighbor hasn't been seen before
					if(!states.contains(neighbor)) {
						// add it to the list of states and queue
						states.add(neighbor);
						queue.add(neighbor);
						// and set its predecessor to itself
						predecessors.add(neighbor);
						//set the neightbor's predecessor correct
						predecessors.set(states.indexOf(neighbor), item);
					}


				}
			}
		}
		return null;
	}
}
