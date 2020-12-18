package ui;

import controllers.*;
import controllers.viewport.IViewPort;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SequenceAnalyzer extends JFrame {
    private JPanel mainPanel;

    private JTextField numberOfSequenceField;
    private JLabel numberOfSequenceLabel;
    private JLabel heuristicLabel;
    private JComboBox heuristicComboBox;

    private JLabel enterSequenceLabel;

    private JButton processButton;

    private JTextArea sequenceOutput;
    private JPanel sequenceOutputPanel;
    private JTextArea sequenceInputArea;
    private JLabel errorLabel;
    private JButton process;
    private JButton reset;

    private final IProcessGeneSequenceController controller;

    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;
    private static final String TITLE = "Gene Sequence Analyzer";

    public SequenceAnalyzer(){
        super(TITLE);

        controller = new ProcessGeneSequenceController();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        add(mainPanel);
        setVisible(true);

        process.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numOfSequences = numberOfSequenceField.getText();
                String heuristic = (String)heuristicComboBox.getSelectedItem();
                String sequences = sequenceInputArea.getText();
                IViewPort output = controller.execute(new ProcessGeneSequenceInput(numOfSequences, heuristic, sequences));

                if(output instanceof ProcessGeneSequenceOutput){
                    resetErrorMessage();
                    resetOutputArea();
                    sequenceOutput.append("Sequences that were processed are: \n");
                    sequenceOutput.append(((ProcessGeneSequenceOutput)output).getSequencesViewModel());

                    sequenceOutput.append("------------------------------------- \n");

                    sequenceOutput.append("Heuristic used was: ");
                    sequenceOutput.append(((ProcessGeneSequenceOutput)output).getHeuristic());

                    sequenceOutput.append("\n------------------------------------- \n");

                    sequenceOutput.append("Most similar pairs are: \n");
                    sequenceOutput.append(((ProcessGeneSequenceOutput)output).getPairsViewModel());
                }else{
                    errorLabel.setText(((ProcessGeneSequenceErrorOutput)output).getMessage());
                }

            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetErrorMessage();
                resetOutputArea();
                resetInputForm();
            }
        });
    }

    private void resetErrorMessage() {
        errorLabel.setText("");
    }

    private void resetInputForm() {
        numberOfSequenceField.setText("");
        heuristicComboBox.setSelectedIndex(0);
        sequenceInputArea.setText("");
    }

    private void resetOutputArea() {
        sequenceOutput.setText("");

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
