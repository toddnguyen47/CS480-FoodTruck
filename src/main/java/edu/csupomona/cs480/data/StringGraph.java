package edu.csupomona.cs480.data;

import java.util.Set;

import com.google.common.graph.EndpointPair;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.MutableGraph;

public class StringGraph
{
   private MutableGraph<String> graph;
   
   public StringGraph()
   {
      graph = GraphBuilder.undirected().allowsSelfLoops(true).build();
      buildGraph();
   }
   
   private void buildGraph()
   {
      graph.putEdge("Arcane Focus", "Deep Wisdom");
      graph.putEdge("Deep Wisdom", "Heart and Soul");
      graph.putEdge("Deep Wisdom", "Occultist's Dominion");
      graph.putEdge("Deep Wisdom", "Practical Application");
      graph.putEdge("Heart and Soul", "Occultist's Dominion");
      graph.putEdge("Lord of the Dead", "Occultist's Dominion");
      graph.putEdge("Occultist's Dominion", "Practical Application");
      graph.putEdge("Start", "Deep Wisdom");
      graph.putEdge("Start", "Occultist's Dominion");
   }
   
   public String getNodeNames()
   {
      
      Set<String> allNodes = graph.nodes();
      String nodes = allNodes.toString();
      return "Nodes: " + nodes;
   }
   
   public String getEdgeNames()
   {
      Set<EndpointPair<String>> allEdges = graph.edges();
      String edges = allEdges.toString();
      return "Edges: " + edges;
   }
   
   public String getSuccessorsList()
   {
      Set<String> allNodes = graph.nodes();
      String s = "";
      for (String e : allNodes)
      {
         s += e + "'s successors: " + graph.successors(e).toString();
      }
      return s;
   }
}
