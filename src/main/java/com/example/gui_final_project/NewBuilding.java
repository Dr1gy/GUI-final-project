package com.example.gui_final_project;

import org.jgrapht.*;
import org.jgrapht.graph.*;
import java.util.ArrayList;

public abstract class NewBuilding {
    protected DefaultUndirectedGraph<Integer, DefaultEdge> model;

    public NewBuilding() {
        model = new DefaultUndirectedGraph<>(DefaultEdge.class);
    }

    public abstract void createModel();

    public boolean compareGraph(ArrayList<Cell> cellsToCheck) {
        DefaultUndirectedGraph<Integer, DefaultEdge> graphToCheck = new DefaultUndirectedGraph<>(DefaultEdge.class);
        boolean graphsAreEqual = true;

        for (Cell cell : cellsToCheck) {
            graphToCheck.addVertex(cell.color);
        }

        for (Cell cell1 : cellsToCheck) {
            for (Cell cell2 : cellsToCheck) {
                if (Math.abs(cell1.x - cell2.x) + Math.abs(cell1.y - cell2.y) == 1) {
                    graphToCheck.addEdge(cell1.color, cell2.color);
                }
            }
        }

        for (Integer cell : model.vertexSet()) {
            for (Integer cell1 : model.vertexSet()) {
                if (!(graphToCheck.containsEdge(cell, cell1) == model.containsEdge(cell, cell1))) {
                    graphsAreEqual = false;
                }
            }
        }

        return graphsAreEqual;

    }
}