package com.ChessBoard;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    private State state = State.ENTRY;

    private ImageButton[][] gameButtons = new ImageButton[8][8];
    private Board board;


    private boolean whiteTurn = true;
    private int round;

    //private ArrayList<>
    private ImageButton CurrentPlace;
    private ImageButton NewPlace;
    private TextView player1Text;
    private TextView player2Text;
    private boolean SelectedMove = false;


    private BoardTile firstSpot;
    private BoardTile secondSpot;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1Text = findViewById(R.id.player1points);
        player2Text = findViewById(R.id.player2points);



        for (int i = 0; i < gameButtons.length; i++) {
            for (int j = 0; j < gameButtons.length; j++) {
                String btnid = "btn" + i + j;
                //resource id, has to pass this to findViewById (we don't use findViewById though --->), this is to create it dynamically in the nested loop
                int resID = getResources().getIdentifier(btnid, "id", getPackageName());
                //will fit perfectly based on i, j. Gets references to all buttons without having to design 1 by 1.
                gameButtons[i][j] = findViewById(resID);
                Log.e(MainActivity.class.getName(), String.valueOf(gameButtons[i][j] == null));


                final int getI = i;
                final int getJ = j;



                gameButtons[i][j].setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {


                        switch (state) {
                            case ENTRY:

                                BoardTile clickedTile = board.getTiles()[getI][getJ];



                                if (!clickedTile.spotTaken()) {
                                    break;
                                } else {

                                    firstSpot = clickedTile;
                                    state = State.SELECTEDCLICK;

                                    for (BoardTile tile: clickedTile.getChessPiece().getValidMoves()) {
                                        board.getTiles()[getI][getJ].addHighLight();

                                    }

                                }

                                break;
                            case SELECTEDCLICK:

                                state = State.ENTRY;
                                int x = board.getTiles()[getI][getJ].getX();
                                int y = board.getTiles()[getI][getJ].getY();

                                boolean clickedValidMove = false;
                                for (BoardTile tile: firstSpot.getChessPiece().getValidMoves()) {
                                    if (tile.getX() == x && tile.getY() == y) {
                                        clickedValidMove = true;
                                        firstSpot.getChessPiece().move(tile);
                                        break;
                                    }
                                }
                                if (!clickedValidMove) {

                                    for (BoardTile tile: firstSpot.getChessPiece().getValidMoves()) {
                                        board.getTiles()[getI][getJ].removeHighLight();
                                    }
                                }

                                break;
                        }

                    }
                });
            }
        }

        board = new Board(this, gameButtons);


//        Button resignButton = findViewById(R.id.Resign);
//        resignButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });


    }

    private enum State {
        ENTRY,
        SELECTEDCLICK
    }








    /*@Override
    public void onClick(View v) {
        //how can I now check if the spot at this button is a Pawn, or any other piece.
        //how can I give each button their own Pieces in the beginning of the game?


        int resID = v.getId();

        //get v.getId()

            //get the id that would correlate to the gameBoard

            //then mess with gameBoard based on the id that was clicked

        //Finally update the buttons gameboard to see visual representation

    }*/



}




























