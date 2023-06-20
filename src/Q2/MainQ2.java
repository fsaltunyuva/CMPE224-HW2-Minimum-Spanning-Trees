//-----------------------------------------------------
// Title: Main Class for the second question
// Author: Furkan Safa Altunyuva
// Section: 4
// Assignment: 2
// Description: This class calculates efficient solution for a farmland company by simulating the problem in a graph structure.
//-----------------------------------------------------
package Q2;

import java.util.ArrayList;
import java.util.Scanner;

public class MainQ2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n, m; //Rows (n) and columns (m)
        int test_case_count = 0;

        test_case_count = scanner.nextInt(); //Getting the test case count
        scanner.nextLine(); //Skipping to the next line

        for (int test_case = 0; test_case < test_case_count; test_case++) { //Doing the process for the intended test case count
            n = scanner.nextInt(); //Getting the row count
            m = scanner.nextInt(); //Getting the column count
            scanner.nextLine(); //Skipping to the next line

            EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(n * m); //Creating an edge weighted graph that consists of n x m vertices

            int start_point_x = scanner.nextInt(); //Getting the x value of the starting point
            int start_point_y = scanner.nextInt(); //Getting the y value of the starting point
            int end_point_x = scanner.nextInt(); //Getting the x value of the ending point
            int end_point_y = scanner.nextInt(); //Getting the y value of the ending point

            scanner.nextLine(); //Skipping to the next line

            int[][] values_of_edges = new int[n][m]; //Creating a 2D array to store given values easily and similar way to matrix

            for (int row = 0; row < values_of_edges.length; row++) {
                for (int col = 0; col < values_of_edges[row].length; col++) {
                    values_of_edges[row][col] = scanner.nextInt(); //Storing the given values in 2D array
                }
                scanner.nextLine(); //Skipping to the next line
            }

            ArrayList<Integer> one_dimensional_array_list = new ArrayList<>();

            //Converting 2D array into 1D array using ArrayList
            for (int row = 0; row < values_of_edges.length; row++) {
                for (int col = 0; col < values_of_edges[row].length; col++) {
                    one_dimensional_array_list.add(values_of_edges[row][col]);
                }
            }

            // n = row size
            // m = column size

            int starting_cell_index = start_point_x * n + start_point_y; //Calculating starting cell's index value for the 1D ArrayList
            int ending_cell_index = end_point_x * n + end_point_y; //Calculating ending cell's index value for the 1D ArrayList

            for (int i = 0; i < one_dimensional_array_list.size(); i++) { //Iterating over the one_dimensional_array_list
                //Note: Used empty if conditions to improve readability and avoid confusion
                if (i % m != m - 1 && i + 1 < one_dimensional_array_list.size()) { //If the value is not in the corner of the 2D array and adding one to the current value will not give an exception
                    if ((i == starting_cell_index && i + 1 == ending_cell_index) || (i == ending_cell_index && i + 1 == starting_cell_index)) { //If i or i+1 is not starting or ending cell

                    } else {
                        edgeWeightedGraph.addEdge(new Edge(i, i + 1, one_dimensional_array_list.get(i) ^ one_dimensional_array_list.get(i + 1))); //Add edge between i and i + 1 with weight (ith value xor i+1th value)
                    }
                }

                if (i + m < one_dimensional_array_list.size()) { //If adding the column size to the current value will not give an exception
                    if ((i == starting_cell_index && i + m == ending_cell_index) || (i == ending_cell_index && i + m == starting_cell_index)) { //If i or i+m is not starting or ending cell

                    } else {
                        edgeWeightedGraph.addEdge(new Edge(i, i + m, one_dimensional_array_list.get(i) ^ one_dimensional_array_list.get(i + m))); //Add edge between i and i + m with weight (ith value xor i+mth value)
                    }
                }
            }

            KruskalsMST kruskalsMST = new KruskalsMST(edgeWeightedGraph); //Run Kruskal's Minimum Spanning Tree algorithm on created Edge Weighted Graph

            int result = 0;

            //Calculating the result according to the edges on the Kruskal's MST Algorithm
            for (Edge e : kruskalsMST.edges()) {
                result += e.weight();
            }

            System.out.println(result); //Printing the result
        }

    }

}
