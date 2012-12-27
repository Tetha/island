package com.boxgames.island;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.boxgames.island.state.SimulationResult;
import com.boxgames.island.state.dummygenerator.ProjectileDummySimulation;
import com.boxgames.island.ui.SimulationDisplay;

public class Main {
    public static void main(String[] args) {
        final JFrame gameWindow = new JFrame();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setTitle("Island game thing");
        gameWindow.setResizable(false);
        gameWindow.setPreferredSize(new Dimension(500, 500));

        final SimulationResult displayedDummyResult = new ProjectileDummySimulation().generateDummySimulation();
        final SimulationDisplay simulationDisplay = new SimulationDisplay(displayedDummyResult);
        gameWindow.add(simulationDisplay);
        new Timer(16, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                gameWindow.getContentPane().repaint();

            }
        }).start();
        gameWindow.pack();
        gameWindow.setVisible(true);

        simulationDisplay.startSimulation();
    }
}
