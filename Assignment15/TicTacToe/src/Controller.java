import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller 
{
    boolean gameState = false; //false is X, True is O.
    int turnsPassed = 0; //keeps track of how many spots remain
    boolean gameEnd = false;
    //All the labels and buttons
    @FXML
    private Label winConLabel;
    @FXML
    private Label gameStateLabel;
    @FXML
    private Button btnPos01;
    @FXML
    private Button btnPos02;
    @FXML
    private Button btnPos03;
    @FXML
    private Button btnPos04;
    @FXML
    private Button btnPos05;
    @FXML
    private Button btnPos06;
    @FXML
    private Button btnPos07;
    @FXML
    private Button btnPos08;
    @FXML
    private Button btnPos09;
    @FXML
    private Button btnPos10;
    @FXML
    private Button btnPos11;
    @FXML
    private Button btnPos12;
    @FXML
    private Button btnPos13;
    @FXML
    private Button btnPos14;
    @FXML
    private Button btnPos15;
    @FXML
    private Button btnPos16;
    @FXML
    private Button btnPos17;
    @FXML
    private Button btnPos18;
    @FXML
    private Button btnPos19;
    @FXML
    private Button btnPos20;
    @FXML
    private Button btnPos21;
    @FXML
    private Button btnPos22;
    @FXML
    private Button btnPos23;
    @FXML
    private Button btnPos24;
    @FXML
    private Button btnPos25;

    @FXML
    private void updateGameState(ActionEvent action)
    {
        Button btn = (Button) action.getSource();
        
        if(gameEnd == true)
        {
            restart();
        }
        else
        {
            if(gameState == false)
            {
                if(btn.getText() == "")
                {
                    btn.setText("X");
                    gameState = true;
                    gameStateLabel.setText("O's turn.");
                    turnsPassed += 1;
                }
                else
                {
                    gameStateLabel.setText("That spot is already taken, pick another.");
                }
            }
            else
            {
                if(btn.getText() == "")
                {
                    btn.setText("O");
                    gameState = false;
                    gameStateLabel.setText("X's turn.");
                    turnsPassed += 1;
                }
                else
                {
                    gameStateLabel.setText("That spot is already taken, pick another.");
                }
            }

            gameEnd = checkWinCon();

            if(turnsPassed == 25)
            {
                winConLabel.setText("The game is over: Draw.");
                gameStateLabel.setText("Press any button to restart.");
                gameEnd = true;
            }
        }
        
         
        
    }

    private boolean checkWinCon() 
    {
        if(checkHorizontal() == true || checkVertical() == true || checkDiagonal() ==  true)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    private boolean checkVertical() {
        if(btnPos01.getText() != "" && btnPos01.getText().equals(btnPos02.getText()) && btnPos02.getText().equals(btnPos03.getText())
        && btnPos03.getText().equals(btnPos04.getText()) && btnPos04.getText().equals(btnPos05.getText()))
        {
            String winner = btnPos01.getText();
            winConLabel.setText(winner + " wins!");
            gameStateLabel.setText("Press any button to restart.");
            return true;
        }
        else if(btnPos06.getText() != "" && btnPos06.getText().equals(btnPos07.getText()) && btnPos07.getText().equals(btnPos08.getText())
        && btnPos08.getText().equals(btnPos09.getText()) && btnPos09.getText().equals(btnPos10.getText()))
        {
            String winner = btnPos06.getText();
            winConLabel.setText(winner + " wins!");
            gameStateLabel.setText("Press any button to restart.");
            return true;
        }
        else if(btnPos11.getText() != "" && btnPos11.getText().equals(btnPos12.getText()) && btnPos12.getText().equals(btnPos13.getText())
        && btnPos13.getText().equals(btnPos14.getText()) && btnPos14.getText().equals(btnPos15.getText()))
        {
            String winner = btnPos11.getText();
            winConLabel.setText(winner + " wins!");
            gameStateLabel.setText("Press any button to restart.");
            return true;
        }  
        else if(btnPos16.getText() != "" && btnPos16.getText().equals(btnPos17.getText()) && btnPos17.getText().equals(btnPos18.getText())
        && btnPos18.getText().equals(btnPos19.getText()) && btnPos19.getText().equals(btnPos20.getText()))
        {
            String winner = btnPos16.getText();
            winConLabel.setText(winner + " wins!");
            gameStateLabel.setText("Press any button to restart.");
            return true;
        }
        else if(btnPos21.getText() != "" && btnPos21.getText().equals(btnPos22.getText()) && btnPos22.getText().equals(btnPos23.getText())
        && btnPos23.getText().equals(btnPos24.getText()) && btnPos24.getText().equals(btnPos25.getText()))
        {
            String winner = btnPos21.getText();
            winConLabel.setText(winner + " wins!");
            gameStateLabel.setText("Press any button to restart.");
            return true;
        }
        else
        {
        return false;
        }
    }

    private boolean checkDiagonal() 
    {
        if(btnPos01.getText() != "" && btnPos01.getText().equals(btnPos07.getText()) && btnPos07.getText().equals(btnPos13.getText())
        && btnPos13.getText().equals(btnPos19.getText()) && btnPos19.getText().equals(btnPos25.getText()))
        {
            String winner = btnPos01.getText();
            winConLabel.setText(winner + " wins!");
            gameStateLabel.setText("Press any button to restart.");
            return true;
        }
        else if(btnPos05.getText() != "" && btnPos05.getText().equals(btnPos09.getText()) && btnPos09.getText().equals(btnPos13.getText())
        && btnPos13.getText().equals(btnPos17.getText()) && btnPos17.getText().equals(btnPos21.getText()))
        {
            String winner = btnPos05.getText();
            winConLabel.setText(winner + " wins!");
            gameStateLabel.setText("Press any button to restart.");
            return true;
        }
        else
        {
            return false;
        }
        
    }

    private boolean checkHorizontal()
    {
        if(btnPos01.getText() != "" && btnPos01.getText().equals(btnPos06.getText()) && btnPos06.getText().equals(btnPos11.getText())
        && btnPos11.getText().equals(btnPos16.getText()) && btnPos16.getText().equals(btnPos21.getText()))
        {
            String winner = btnPos01.getText();
            winConLabel.setText(winner + " wins!");
            gameStateLabel.setText("Press any button to restart.");
            return true;
        }
        else if(btnPos02.getText() != "" && btnPos02.getText().equals(btnPos07.getText()) && btnPos07.getText().equals(btnPos12.getText())
        && btnPos12.getText().equals(btnPos17.getText()) && btnPos17.getText().equals(btnPos22.getText()))
        {
            String winner = btnPos02.getText();
            winConLabel.setText(winner + " wins!");
            gameStateLabel.setText("Press any button to restart.");
            return true;
        }
        else if(btnPos03.getText() != "" && btnPos03.getText().equals(btnPos08.getText()) && btnPos08.getText().equals(btnPos13.getText())
        && btnPos13.getText().equals(btnPos18.getText()) && btnPos18.getText().equals(btnPos23.getText()))
        {
            String winner = btnPos03.getText();
            winConLabel.setText(winner + " wins!");
            gameStateLabel.setText("Press any button to restart.");
            return true;
        }  
        else if(btnPos04.getText() != "" && btnPos04.getText().equals(btnPos09.getText()) && btnPos09.getText().equals(btnPos14.getText())
        && btnPos14.getText().equals(btnPos19.getText()) && btnPos19.getText().equals(btnPos24.getText()))
        {
            String winner = btnPos04.getText();
            winConLabel.setText(winner + " wins!");
            gameStateLabel.setText("Press any button to restart.");
            return true;
        }
        else if(btnPos05.getText() != "" && btnPos05.getText().equals(btnPos10.getText()) && btnPos10.getText().equals(btnPos15.getText())
        && btnPos15.getText().equals(btnPos20.getText()) && btnPos20.getText().equals(btnPos25.getText()))
        {
            String winner = btnPos05.getText();
            winConLabel.setText(winner + " wins!");
            gameStateLabel.setText("Press any button to restart.");
            return true;
        }
        else
        {
            return false;
        }
    }

    private void restart() 
    {
        turnsPassed = 0;
        gameStateLabel.setText("");
        winConLabel.setText("");
        btnPos01.setText("");
        btnPos02.setText("");
        btnPos03.setText("");
        btnPos04.setText("");
        btnPos05.setText("");
        btnPos06.setText("");
        btnPos07.setText("");
        btnPos08.setText("");
        btnPos09.setText("");
        btnPos10.setText("");
        btnPos11.setText("");
        btnPos12.setText("");
        btnPos13.setText("");
        btnPos14.setText("");
        btnPos15.setText("");
        btnPos16.setText("");
        btnPos17.setText("");
        btnPos18.setText("");
        btnPos19.setText("");
        btnPos20.setText("");
        btnPos21.setText("");
        btnPos22.setText("");
        btnPos23.setText("");
        btnPos24.setText("");
        btnPos25.setText("");
        gameState = false;
        gameEnd = false;
    }
}
