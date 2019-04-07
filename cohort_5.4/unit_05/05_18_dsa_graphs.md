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

### Adjacency List

An Adjacency list is an array or linked list that represents a graph and makes it easy to see which vertices are adjacent/neighbors. Basically each vertex is given an index in the list and then its neighboring vertices are stored as a list.

Retrieving a vertex's neighbors will take O(1) run time since if we know the index it takes constant time.

To find a nodes specific neighbor we need to find the vertex X in the adjacency list. Which in the worst case will take O(d) time where d is the degree (number of connections) a node has

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
  public List<GraphNode> graphAdjacency;

  GraphNode(String name) {
    this.name = name;
    graphAdjacency = new ArrayList<>();
  }
}
```


### Adjacency Matrix

### Breadth First Search

### Depth First Search

### Cycles

### Directed Graph's

### Directed Acyclic Graph's

### Topological Ordering

### DAG and Dagger 2