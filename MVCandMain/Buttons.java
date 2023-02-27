package MVCandMain;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Buttons {
    CarController carC;

    public Buttons(CarController carC){
        this.carC = carC;
        connectButtons();
    }

    JSpinner addCarSpinner = new JSpinner();
    String modelName = "Volvo240";
    JLabel addCarLabel = new JLabel("Add car:");
    JSpinner removeCarSpinner = new JSpinner();
    int carIndex = 0;
    JLabel removeCarLabel = new JLabel("Remove Car:");
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton addCarButton = new JButton ("Add Car");
    JButton removeCarButton = new JButton ("Remove Car");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    public JPanel initializeSpinners(){
        JPanel spinners = new JPanel();
        JSpinner gasSpinner = initializeGasSpinner();
        JSpinner addCarSpinner = initializeAddCarSpinner();
        JSpinner removeCarSpinner = initializeRemoveCarSpinner();

        spinners.setLayout(new GridLayout(0, 1));
        spinners.add(gasLabel, BorderLayout.PAGE_START);
        spinners.add(gasSpinner, BorderLayout.PAGE_END);
        spinners.add(addCarLabel, BorderLayout.PAGE_START);
        spinners.add(addCarSpinner, BorderLayout.PAGE_END);
        spinners.add(removeCarLabel, BorderLayout.PAGE_START);
        spinners.add(removeCarSpinner, BorderLayout.PAGE_END);

        return spinners;
    }
    public JSpinner initializeGasSpinner(){
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        return gasSpinner;
    }
    public JSpinner initializeAddCarSpinner(){
        ArrayList<String> models = new ArrayList<>();
        models.add("Volvo240");
        models.add("Saab95");
        models.add("Scania");
        SpinnerModel spinnerModel =
                new SpinnerListModel(models);
        addCarSpinner = new JSpinner(spinnerModel);
        addCarSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                modelName = (String)((JSpinner)e.getSource()).getValue();
            }
        });

        return addCarSpinner;
    }
    public JSpinner initializeRemoveCarSpinner(){
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        Math.max(carC.amountOfCars() - 1, 0), //max
                        1);//step
        removeCarSpinner = new JSpinner(spinnerModel);
        removeCarSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                carIndex = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        return removeCarSpinner;
    }

    public JPanel initializeSpeedPanel(int X){
        JPanel controlPanel = new JPanel();

        controlPanel.setLayout(new GridLayout(2, 2));

        controlPanel.add(addCarButton, 0);
        controlPanel.add(gasButton, 1);
        controlPanel.add(removeCarButton,2);
        controlPanel.add(brakeButton, 3);

        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));

        controlPanel.setBackground(Color.CYAN);
        return controlPanel;
    }

    public JPanel initializeControlPanel(int X) {
        JPanel controlPanel = new JPanel();

        controlPanel.setLayout(new GridLayout(2, 5));

        controlPanel.add(addCarButton, 0);
        controlPanel.add(gasButton, 1);
        controlPanel.add(turboOnButton, 2);
        controlPanel.add(liftBedButton, 3);
        controlPanel.add(initializeStartButton(), 4);
        controlPanel.add(removeCarButton,5);
        controlPanel.add(brakeButton, 6);
        controlPanel.add(turboOffButton, 7);
        controlPanel.add(lowerBedButton, 8);
        controlPanel.add(initializeStopButton(), 9);

        controlPanel.setPreferredSize(new Dimension(X -250, 200));

        controlPanel.setBackground(Color.CYAN);
        return controlPanel;
    }

    public JButton initializeStartButton(){
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        //startButton.setPreferredSize(new Dimension(X/5-15,200));
        return startButton;
    }
    public JButton initializeStopButton(){
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        //stopButton.setPreferredSize(new Dimension(X/5-15,200));
        return stopButton;
    }
    public void connectButtons(){

        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    carC.removeCar(carIndex);
                    SpinnerNumberModel numbers = (SpinnerNumberModel) removeCarSpinner.getModel();
                    numbers.setMaximum(carC.amountOfCars() - 1);
                }
                catch(IndexOutOfBoundsException ignored) {
                }

            }
        });
        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.addCar(modelName);
                SpinnerNumberModel numbers = (SpinnerNumberModel) removeCarSpinner.getModel();
                numbers.setMaximum(carC.amountOfCars() - 1);
            }
        });
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(gasAmount);
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.liftUp();
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.liftDown();
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.startAll();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.stopAll();
            }
        });
    }


}
