# Graph-Search


In this project, I implemented depth-first and breadth-first search algorithms for a maze-solving problem. 
The primary goals were to find a complete solution, i.e., a path from the initial state to the goal, and implement a solution validator. 
The project involved the following key steps:

Step 1: Solution Validation
Implemented the isValid method in the Searcher class to validate the correctness of the found solution.
Step 2: Recursive Depth-First Search
Reviewed the provided RecursiveDepthFirstSearcher and understood its approach of maintaining a list of explored states.
Recognized that the approach used in recursive search might not be suitable for iterative implementations.
Considered alternative approaches, such as maintaining explicit predecessors of each state.
Step 3: Iterative Search Implementations
Completed the implementations of both StackBasedDepthFirstSearcher and QueueBasedBreadthFirstSearcher.
Adapted the chosen approach for maintaining predecessors to ensure correctness in iterative searches.
