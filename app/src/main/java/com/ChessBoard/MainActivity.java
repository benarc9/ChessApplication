package com.ChessBoard;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
    //should be int
    private TextView player1Text;
    private TextView player2Text;
    private boolean SelectedMove = false;


    private BoardTile firstSpot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        player1Text = findViewById(R.id.player1points);
        player2Text = findViewById(R.id.player2points);


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String btnid = "btn" + i + j;
                //resource id, has to pass this to findViewById (we don't use findViewById though --->), this is to create it dynamically in the nested loop
                int resID = getResources().getIdentifier(btnid, "id", getPackageName());
                //will fit perfectly based on i, j. Gets references to all buttons without having to design 1 by 1.
                gameButtons[i][j] = findViewById(resID);

                final int getI = i;
                final int getJ = j;

                gameButtons[i][j].post(new Runnable() {
                    @Override
                    public void run() {
                        if (getI == 7 && getJ == 7){
                            board = new Board(MainActivity.this, gameButtons);
                        }
                    }
                });

                gameButtons[i][j].setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {

                        //if whiteTurn, then can ONLY click the white pieces (public BoardTile availableTiles()?)

                        switch (state) {

                            case ENTRY:

                                BoardTile clickedTile = board.getTiles()[getI][getJ];


                                if (whiteTurn) {
                                    //can I do this for the rotation of the screen or will this now mess
                                    //up the aligning of the FrameLayout and LinearLayout views of ImageButtons?
                                    // Should I just keep it at the fixed position that it is at and it not rotate?

                                    if (!(clickedTile.getChessPiece().getPieceColor() == 0)) {
                                        //will this now let the current person click a tile again, right?
                                        //if this works how I think it does then I wouldnt have to check the if
                                        //not condition since it will always be black since its checking it in the first one^
                                        break;
                                    }
                                } else {

                                }



                                if (!clickedTile.spotTaken()) {

                                    break;
                                } else {

                                    state = State.SELECTEDCLICK;
                                    firstSpot = clickedTile;

                                    for (BoardTile tile: clickedTile.getChessPiece().getValidMoves()) {
                                        board.getTiles()[getI][getJ].addHighLight();
                                    }

                                }

                                break;
                            case SELECTEDCLICK:
                                //I dont have to check for white turn in here I just have to change the whiteTurn boolean
                                //so that black goes next since validMoves handles it I believe

                                state = State.ENTRY;
                                int x = board.getTiles()[getI][getJ].getX();
                                int y = board.getTiles()[getI][getJ].getY();

                                boolean clickedValidMove = false;
                                for (BoardTile tile : firstSpot.getChessPiece().getValidMoves()) {
                                    if (tile.getX() == x && tile.getY() == y) {
                                        clickedValidMove = true;
                                        //get the points text to update
                                        setPlayerPoints(player1Text, tile.getChessPiece());
                                        setPlayerPoints(player2Text, tile.getChessPiece());
                                        firstSpot.getChessPiece().move(tile);
                                        round++;
                                        whiteTurn = false;
                                        break;
                                    }
                                }
                                if (!clickedValidMove) {

                                    for (BoardTile tile : firstSpot.getChessPiece().getValidMoves()) {
                                        tile.removeHighLight();
                                    }
                                }

                                break;
                        }

                    }
                });
            }
        }


        }


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void setPlayerPoints(TextView playerText, Piece piece) {
        //sets the points depending on if the piece they took from the tile they move to is black or white.
        if (piece.getPieceColor() == 0) {
            //how can i check what kind of piece the piece is with equals (can I do this?)
            if (piece.toString() == "Pawn") {
                playerText.setText(playerText.getText() + "1");
            } else if (piece.toString() == "Rook") {
                playerText.setText(playerText.getText() + "5");
            } else if (piece.toString() == "Knight") {
                playerText.setText(playerText.getText() + "3");
            } else if (piece.toString() == "Bishop") {
                playerText.setText(playerText.getText() + "3");
            } else if (piece.toString() == "Queen") {
                playerText.setText(playerText.getText() + "11");
            }
        } else if (piece.getPieceColor() == 1) {
            //how can i check what kind of piece the piece is with equals (can I do this?)
            if (piece.toString() == "Pawn") {
                playerText.setText(playerText.getText() + "1");
            } else if (piece.toString() == "Rook") {
                playerText.setText(playerText.getText() + "5");
            } else if (piece.toString() == "Knight") {
                playerText.setText(playerText.getText() + "3");
            } else if (piece.toString() == "Bishop") {
                playerText.setText(playerText.getText() + "3");
            } else if (piece.toString() == "Queen") {
                playerText.setText(playerText.getText() + "11");
            }
        }
    }

    private enum State {
        ENTRY,
        SELECTEDCLICK
    }

}


//either pop up if there is time or send back to screen full of games to join.
//        Button resignButton = findViewById(R.id.Resign);
//        resignButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });











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
































