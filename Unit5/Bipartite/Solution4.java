import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import generator.GraphNode;
public class Solution4 {

	public static void main(String[] args) {
		List<GraphNode> input  = new ArrayList<GraphNode>();
		System.out.println(isBipartite(input));
	}
	//what: Bipartite is to find each pointer`s neighbors whether they belong to different group with the pointer. 
	public static boolean isBipartite(List<GraphNode> graph) {
		//how: 1. corner case
		if (graph == null) {
			return true;
		}
		//2. create a hashMap to record each value.
		Map<GraphNode, Integer> visited = new HashMap<GraphNode,Integer>();
		//3. traverse each visited node
		for (GraphNode node: graph) {
			if (!isBip(node,visited)) {
				return false;
			}
		}
		return true;
	}
	private static boolean isBip(GraphNode node, Map<GraphNode, Integer> visited) {
		//3.1 base case to avoid computation.
		if (visited.containsKey(node)) {
			return true;
		}
		//3.2 create a queue to do BFS
		Queue<GraphNode> que = new LinkedList<GraphNode>();
		que.add(node);
		visited.put(node, 0);
		while (!que.isEmpty()) {
			//3.3 get current group number and the neighbor will have different group number.
			GraphNode cur = que.poll();
			int groupCur = visited.get(cur);
			int groupNei = groupCur == 1 ? 0 : 1;
			for(GraphNode nei: cur.neighbors) {
				if(!visited.containsKey(nei)) {
					visited.put(nei, groupNei);
					que.offer(nei);
				} else if (visited.get(nei)!= groupNei){
					return false;
				}
			}
		}
		return true;
	}
	//Time Complexity: O(n);
	//Space Complexity: O(n);
}
