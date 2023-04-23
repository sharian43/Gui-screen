import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PersonEntry extends JFrame
{
    private JTextField  txtName;       //name
    private JTextField  txtAge;        //age
    private JButton     cmdSave;
    private JButton     cmdClose;
    private JCheckBox   cmdCheckBox;
    private JButton     cmdClearAll;

    private JPanel      pnlCommand;
    private JPanel      pnlDisplay;
    private PersonEntry      entry;
    private PersonListing   perListing; //1b
  
    public PersonEntry(PersonListing perListing)
    {
        this.perListing = perListing; //c
        setTitle("Entering new person");
        pnlCommand = new JPanel();
        pnlDisplay = new JPanel();
        pnlDisplay.add(new JLabel("Name:")); 
        txtName = new JTextField(20);
        pnlDisplay.add(txtName);
        pnlDisplay.add(new JLabel("Age:"));
        txtAge = new JTextField(3);
        pnlDisplay.add(txtAge);

        pnlDisplay.add(new JLabel("Will Publish?")); //2a, adding/displaying new label 
        cmdCheckBox = new JCheckBox(); //2a 
        pnlDisplay.add(cmdCheckBox); //2a adding/displaying checkbox

        pnlDisplay.setLayout(new GridLayout(3,4));
       
        cmdSave      = new JButton("Save");
        cmdClose   = new JButton("Close");     

        cmdSave.addActionListener(new SaveButtonListener()); //2c
        cmdClose.addActionListener(new CloseButtonListener()); //2b

        pnlCommand.add(cmdSave);
        pnlCommand.add(cmdClose);
        add(pnlDisplay, BorderLayout.CENTER);
        add(pnlCommand, BorderLayout.SOUTH);
        pack();
        setVisible(true);

    }

    private class CloseButtonListener implements ActionListener //2b
    {
        public void actionPerformed(ActionEvent e) //2b
        {
            entry.setVisible(false); //2b, //Visibility of the button
        }

    }

    private class SaveButtonListener implements ActionListener //2c
    {
        public void actionPerformed(ActionEvent e) //2c
        {
            int age = 9999;
            String name1 = "";
            boolean errorFree = false;
            try
            {
                //String name = txtName.getText(); or getName() //2c
                //String age1 = txtAge.getText();
                String[] nameParts= txtName.getText().split(" "); // getting name and spliting a it 
                if (nameParts.length == 2)
                {
                    name1 = nameParts[0] + nameParts[1];
                }
                age = Integer.parseInt(txtAge.getText());
                errorFree = true;
            }
            catch(NumberFormatException nfe) //2c exception 
            {}
            catch(ArrayIndexOutOfBoundsException hne)
            {}
            finally
            {
                if (errorFree == true)
                {
                    perListing.addPerson(new Person(txtName.getText(), age, cmdCheckBox.isSelected()));
                    entry.setVisible(false); //Visibility of the button
                }
                
            }
            
        }
        
    }

}