# DSA Review: Graphs

## Objectives

Fellows will

* Define what Graphs are
* Implement Graphs
* Write pseudo code to build and traverse Graphs
* Explain Big O of Graph Traversal Methods
* Learn about Acyclic Graphs

## Resources

## Lecture

Graph's are one of the classic data structures in computer science. They are non linear structures used to store data which means their data does not follow a specific order like an array or linked list. Trees are a close example of this they start with root and might connect to other points.

![comparison](https://cdn-images-1.medium.com/max/1040/1*rguQ2Y2Z920IYGkO0cHHtQ.jpeg)

Trees are essentially restricted types of graphs simply put a tree is a connected graph without a cycle.

A tree will always be a graph but not all graphs are trees.

Graphs however do not have a root node. Graph nodes can be connected in any way to other nodes. So a graph is a set of values that are related in a pair wise fashion and consists of Nodes/Vertices and Edges, Nodes will contain some kind of data and edges can connect nodes in any possible way.

### Edges

Graphs can have two types of edges, an edge that has a direction or flow or an edge that has no direction or flow meaning directed or undirected edges.

![DirectedUndirected](https://cdn-images-1.medium.com/max/1040/1*cS26jONjjQ5ACImJmHhtqg.jpeg)

### Graph

Representing graphs can get tricky we need to make sure that we can store both information and represent the graphs connections. So we will either use an Adjacency list or an Adjacency Matrix

### Adjacency Matrix

An adjacency matrix is a 2D array that represents which nodes in a graph have edges in between them the matrix serves as a lookup table where a value of 1 represents an edge and 0 represents the lack of one

![Adjacent](http://mathworld.wolfram.com/images/eps-gif/AdjacencyMatrix_1002.gif)

Adjacency matrices are easy to represent and look up insertion and removal of an edge will take O(1) constant time

But its not really space efficient an adjacency matrix will always require O(v^2) space. This isn't necessarily a problem but when a graph is sparce meaning it only has a few edges then we a taking up a lot of space representing 0

```java

public class Graph {
  boolean adjMatrix[][];
  int numVertices;

  public Graph(int numVertices){
    this.numVertices = numVertices;
    adjMatrix = new boolean[numVertices][numVertices];
  }

  public void addEdge(int i , int j){
    adjMatrix[j][i] = true;
    adjMatrix[i][j] = true;
  }
}

```

### Adjacency List

An Adjacency list is an array or linked list that represents a graph and makes it easy to see which vertices are adjacent/neighbors. Basically each vertex is given an index in the list and then its neighboring vertices are stored as a list.

Retrieving a vertex's neighbors will take O(1) run time since if we know the index it takes constant time.

To find a nodes specific neighbor we need to find the vertex X in the adjacency list. Which in the worst case will take O(d) time where d is the degree (number of connections) a node has

The maximum possible value for the degree of any node in the graph will be (V - 1) which will represent a node that has an edge to every other vertex in the graph the minimum value will be 0

And finally the space complexity of a graph will depend on whether it is directed or undirected. If directed the space complexity will be O(E) where E is the total number of edges in the graph. But if the graph is directed then

```java

public class Graph {

  public List<GraphNode> graphNodeList;

  Graph(){
    this.graphNodeList = graphNodeList;
  }
}
```

```java
public class GraphNode {

  public String name;
  public List<GraphNode> neighbors;
  public boolean visited;

  GraphNode(String name) {
    this.name = name;
    neighbors = new ArrayList<>();
    visited = false;
  }
}
```

### Traversal

The process of traversing through a graph structure involves visiting each node in the graph the order they are visited determines what graph traversal we are using

Graph traversal can begin with any node in the graph since there is no concept of root or beginning

### Breadth First Search

Traverses the width of a graph structure by visiting the neighbors of a node before visiting the children and makes use of the queue data structure

The steps are

1. add a node to a queue of nodes to be visited
2. visit the first node in the queue and mark it visited
3. remove the node we are visiting from the queue
4. if that node has any neighbors check to see if they are visited
5. Add any neighbors that still need to be visited into the queue

```java
public void BreadthFirstSearch(GraphNode graphNode){
  Queue<GraphNode> nodesQueue = new LinkedList<>();
  graphNode.visited = true;
  while(!nodesQueue.isEmpty()){
    GraphNode currentNode = queue.remove();
    System.out.println(currentNode.name);
    List<GraphNode> currentNeighbors = currentNode.neighbors;

    for(int i = 0; i < currentNeighbors.size(); i++){
      GraphNode neighborNode = currentNeighbors.get(i);
      if(neighborNode != null && !neighborNode.visited){
        nodesQueue.add(neighborNode);
        neighborNode.visited = true;
      }
    }
  }
}
```

Some important detail you should notice is that we only iterate through the neighbors list once

If the graph is undirected an edge will appear twice in different adjacency lists if the graph is directed an edge would only appear once

Time Complexity

Our time complexity comes from the time needed to visit N number of nodes plus the number of edges in the adjacency list to visit

So the runtime complexity for BFS will be O(V + E)

### Depth First Search

Depth first search will traverse down a single path once child node at a time it will traverse down one single path until it cant go any further and checks one child node at a time

The steps we follow will be

1. Marked the current node as visited
2. checked to see if it had any children — and if it did, we ensured that they had not been visited already,
3. if they haven't been visited call DFS again

```java
public void DFS(GraphNode currentNode){
  List<GraphNode> neighbors = currentNode.neighbors;
  currentNode.visited = true;
  System.out.println(currentNode.name);
  for(int i = 0; i < neighbors.size(); i++){
    GraphNode neighborNode = neighbors.get(i);
    if(neighborNode != null && !neighborNode.visited){
      DFS(neighborNode);
    }
  }
}
```

Visiting every vertex will take only constant time what adds to our runtime complexity will come from checking the outgoing edges from a node.

Our runtime will be the number of vectors in the graph plus the number of edges the graph has so our runtime will be O(V + E)

### Cycles

A cycle in a graph occurs when some vertices are connected to one another in a closed chain. A graph that contains one cycle is known as a cyclic graph. A graph that contains zero cycles will be known as an acyclic graph

now lets define how we know a graph has a cycle.

Backward Edge: An edge that connects a node to an ancestor in the Graph path so it can connect a node back to a parent in the graph traversal

A graph with a backward edge will contain a cycle

![Cycle](https://cdn-images-1.medium.com/max/1040/1*GnMghFkLYP6LGbbGsPYLww.jpeg)

### Directed Acyclic Graph's

A Directed Acyclic Graph is one that is directed but does not contain any cycles known also known as DAGs

![DAG](https://upload.wikimedia.org/wikipedia/commons/4/4b/Directed_acyclic_graph.svg)

DAGs are common they are the backbone of scheduling where tasks need to be organized and processed in a particular order and DAGs are used in dependency graphs (think of dependencies in android studio) and is a concept behind Blockchain's

![Dependency Graph](https://i.stack.imgur.com/izCd0.png)

### DAG and Dagger 2

The acyclic dependencies principle (ADP) is a software design principle that states that "the dependency graph of packages or components should have no cycles"

Cyclic dependencies between components inhibit understanding, testing, and reuse. This makes the system less maintainable because understanding the code is harder. Lack of understanding makes changes harder and more error-prone. If components are in a circular dependency they are more difficult to test because they can not be tested separately.

this the problem that DAGGER 2 tries to solve