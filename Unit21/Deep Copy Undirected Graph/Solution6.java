import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  //use a hashmap to store mapping relations of original node and copied node to avoid duplications. 
	  public List<GraphNode> copy(List<GraphNode> graph) {
	    //define a hash map to store the mapping relations
	    Map<GraphNode, GraphNode> map = new HashMap<>();
	    //define an arraylist to return the result.
	    List<GraphNode> res = new ArrayList<>();
	    for(GraphNode node : graph) {
	      copy(node, map, res);
	    }
	    return res;
	  }
	  public GraphNode copy (GraphNode node, Map<GraphNode, GraphNode> map, List<GraphNode> res) {
	    //base case;
	    if (node == null) {
	      return null;
	    }
	    if (map.containsKey(node)) {
	      return map.get(node); 
	    }
	    //create a new node.
	    GraphNode newNode = new GraphNode(node.key);
	    map.put(node, newNode);
	    res.add(newNode);
	    //get all copied neigbors for newNode.
	    for(GraphNode nei: node.neighbors) {
	      newNode.neighbors.add(copy(nei, map, res));
	    }
	    return newNode;
	  }
	  //Time Complexity: O(E + V); 
	  //Space Complexity: O(V); HashMap`s size;
	  
	   class GraphNode {
		     public int key;
		     public List<GraphNode> neighbors;
		     public GraphNode(int key) {
		       this.key = key;
		      this.neighbors = new ArrayList<GraphNode>();
		     }
		   }
}
