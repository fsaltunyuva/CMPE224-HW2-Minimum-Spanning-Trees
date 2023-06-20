//-----------------------------------------------------
// Title: Main class for the first question
// Author: Furkan Safa Altunyuva
// Section: 4
// Assignment: 2
// Description: This class simulates taxi rides in directed graph structure and checks if the structe can be kept in a tree structure or not
//-----------------------------------------------------
package Q1;

import java.util.*;

public class MainQ1 {
    public static void main(String[] args) {
        int taxi_pickups, taxi_rides;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of taxi pickups:");
        taxi_pickups = scanner.nextInt(); //Getting the integer input and assigning to the pickups value

        System.out.println("Enter the number of taxi rides:");
        taxi_rides = scanner.nextInt(); //Getting the integer input and assigning to the rides value

        System.out.println("Enter the taxi rides:");
        String line = scanner.nextLine(); //Used nextLine to prevent input problem

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(); //Creating a linked hash set to store the locations
        ArrayList<String> lines = new ArrayList<>(); //Creating an ArrayList to store given lines

        for (int i = 0; i < taxi_rides; i++) {
            line = scanner.nextLine(); //Reading the line and assigning to the "line"
            lines.add(line); //Adding read value to "lines" to use it in the next for-each loop

            String[] line_words = line.split(" "); //Storing the words in the "line" in the "line_words"
            linkedHashSet.add(line_words[0]); //Adding the first word (location) to the linked hash set
            linkedHashSet.add(line_words[1]); //Adding the second word (location) to the linked hash set
        }

        ArrayList<String> locations = new ArrayList<>(linkedHashSet); //Creating another ArrayList to store distinct locations with indexes (LinkedHashSet does not allow indexes)

        DirectedGraph directedGraph = new DirectedGraph(taxi_pickups); //Creating a directed graph with the pickup count

        for(String line_value: lines) { //Iterating in "lines" ArrayList
            String[] line_words = line_value.split(" "); //Storing the words in the line in "line_words" array

            int index_1 = locations.indexOf(line_words[0]); //Assigning index_1 to index of the given word in the locations ArrayList
            int index_2 = locations.indexOf(line_words[1]); //Assigning index_2 to index of the given word in the locations ArrayList

            directedGraph.addEdge(index_1, index_2); //Adding the edges of given locations
        }


        for (int i = 0; i < directedGraph.getV(); i++) {
            Iterable<Integer> temp = directedGraph.adj(i); //Storing adjacent vertices of the ith vertex in the "temp"
            ArrayList<Integer> indexes_of_adjacent_locations = new ArrayList<>(); //Creating an ArrayList to store indexes of adjacent locations
            ArrayList<String> names_of_adjacent_locations = new ArrayList<>(); //Creating an ArrayList to store names of adjacent locations

            for(Integer value : temp){ //Iterating over in the adjacent vertices of the ith vertex
                indexes_of_adjacent_locations.add(value); //Adding the index names of the vertices to indexes_of_adjacent_locations
            }

            for (Integer value : indexes_of_adjacent_locations){ //Iterating over in the indexes_of_adjacent_locations
                names_of_adjacent_locations.add(locations.get(value)); //Adding the name of certain index to the names_of_adjacent_locations by looking to the locations ArrayList
            }
            //Printing the locations
            System.out.print(locations.get(i) + ":    ");
            Collections.reverse(names_of_adjacent_locations);
            System.out.println(names_of_adjacent_locations);
        }

        DirectedDFS dfs = new DirectedDFS(directedGraph, 0); //Starting depth first search from the first vertex
        Cycle cycle = new Cycle(directedGraph); //Creating a cycle object to detect cycle

        //Checking the conditions for tree structure
        boolean is_graph_connected = dfs.isConnected(); //Checking the graph connectivity
        boolean is_vertex_minus_one_equals_edge = taxi_pickups - 1 == taxi_rides; //Checking the vertex and edge count condition
        boolean is_there_any_cycle_in_graph = cycle.hasCycle(); //Checking if there are any cycles

        if(is_graph_connected && is_vertex_minus_one_equals_edge && !is_there_any_cycle_in_graph){
            System.out.println("This ride network can be kept in a tree structure.");
        }
        else {
            System.out.println("This ride network cannot be kept in a tree structure.");
        }

    }
}
