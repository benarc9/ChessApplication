package com.ChessBoard;

//Board --> Button --> Tile --> Piece

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

//hard to think of everything that has to do with the board
//its creating all the pieces, whose turn it is (black or white),
public class Board {

    private boolean turn;
    private Context c;
    ImageButton[][] gameButtons;


    private BoardTile[][] tiles;
    private Piece[] chessPieces;
    private String[] BoardLetter = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private int[] BoardNumber = {1, 2, 3, 4, 5, 6, 7, 8};


    public Board(Context c, ImageButton[][] gameButtons) {
        this.c = c;
        this.gameButtons = gameButtons;
        setUpTiles();
        createPieces();
    }

    public BoardTile[][] setUpTiles() {

        int bJuicers = 0;
        int bPawns = 8;
        int wPawns = 16;
        int wJuicers = 24;

        this.tiles = new BoardTile[8][8];


        for(int i = 0; i < 8; i++) {
            //juicers
            if (i == 0) {
                createTiles(i, bJuicers);
                //pawns
            } else if (i == 1) {

                createTiles(i, bPawns);
                //pawns
            } else if (i == 6) {

                createTiles(i, wJuicers);
                //juicers
            } else if (i == 7) {

                createTiles(i, wPawns);
            } else {

                for (int j = 0; j < tiles.length; j++) {

                    createTiles(i, j);
                }

            }

        }

        return tiles;
    }

    public BoardTile[][] getTiles() {
        return tiles;
    }

    public void createTiles(int i, int juicers) {
        for(int j = 0; j < 8; j++) {
            if (i % 2 == 0) {
                if (j % 2 == 0) {
                    tiles[i][j] = new BoardTile(i, j, gameButtons[i][j], R.color.white);
                } else {
                    tiles[i][j] = new BoardTile(i, j, gameButtons[i][j], R.color.black);
                }
            } else {
                if (j % 2 == 0) {
                    tiles[i][j] = new BoardTile(i, j, gameButtons[i][j], R.color.black);
                } else {
                    tiles[i][j] = new BoardTile(i, j, gameButtons[i][j], R.color.white);
                }
            }
        }
    }



    private void createPieces() {



        chessPieces =   new Piece[] {   new Rook(tiles, 0, 0, 1, createImageView(R.drawable.brook)), new Knight(tiles, 0, 1, 1, createImageView(R.drawable.bknight)),
                new Bishop(tiles, 0, 2, 1, createImageView(R.drawable.bbishop)), new Queen(tiles, 0, 3, 1, createImageView(R.drawable.bqueen)),
                new King(tiles, 0, 4, 1, createImageView(R.drawable.bking)), new Bishop(tiles, 0, 5, 1, createImageView(R.drawable.bbishop)),
                new Knight(tiles, 0, 6, 1, createImageView(R.drawable.bknight)), new Rook(tiles, 0, 7, 1, createImageView(R.drawable.brook)),
                new Pawn(tiles, 1, 0, 1, createImageView(R.drawable.bpawn)), new Pawn(tiles, 1, 1, 1, createImageView(R.drawable.bpawn)),
                new Pawn(tiles, 1, 2, 1, createImageView(R.drawable.bpawn)), new Pawn(tiles, 1, 3, 1, createImageView(R.drawable.bpawn)),
                new Pawn(tiles, 1, 4, 1, createImageView(R.drawable.bpawn)), new Pawn(tiles, 1, 5, 1, createImageView(R.drawable.bpawn)),
                new Pawn(tiles, 1, 6, 1, createImageView(R.drawable.bpawn)), new Pawn(tiles, 1, 7, 1, createImageView(R.drawable.bpawn)),
                new Pawn(tiles, 6, 0, 0, createImageView(R.drawable.wpawn)), new Pawn(tiles, 6, 1, 0, createImageView(R.drawable.wpawn)),
                new Pawn(tiles, 6, 2, 0, createImageView(R.drawable.wpawn)), new Pawn(tiles, 6, 3, 0, createImageView(R.drawable.wpawn)),
                new Pawn(tiles, 6, 4, 0, createImageView(R.drawable.wpawn)), new Pawn(tiles, 6, 5, 0, createImageView(R.drawable.wpawn)),
                new Pawn(tiles, 6, 6, 0, createImageView(R.drawable.wpawn)), new Pawn(tiles, 6, 7, 0, createImageView(R.drawable.wpawn)),
                new Rook(tiles, 7, 0, 0, createImageView(R.drawable.wrook)), new Knight(tiles, 7, 1, 0, createImageView(R.drawable.wkknight)),
                new Bishop(tiles, 7, 2, 0, createImageView(R.drawable.wbishop)), new Queen(tiles, 7, 3, 0, createImageView(R.drawable.wqueen)),
                new King(tiles, 7, 4, 0, createImageView(R.drawable.wking)), new Bishop(tiles, 7, 5, 0, createImageView(R.drawable.wbishop)),
                new Knight(tiles, 7, 6, 0, createImageView(R.drawable.wkknight)), new Rook(tiles, 7, 7, 0, createImageView(R.drawable.wrook))};



        int index = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Log.e(Board.class.getSimpleName(), "x: " + i + " y: " + j);
                Log.e(Board.class.getSimpleName(), "Index: " + index);
                if (i == 0) {
                    tiles[i][j].setChessPiece(chessPieces[index]);
                    index++;
                } else if (i == 1) {
                    tiles[i][j].setChessPiece(chessPieces[index]);
                    index++;
                } else if (i == 6) {
                    tiles[i][j].setChessPiece(chessPieces[index]);
                    index++;
                } else if (i == 7) {
                    tiles[i][j].setChessPiece(chessPieces[index]);
                    index++;
                }

            }
        }


    }




    private ImageView createImageView(int draw) {

        FrameLayout fl = ((MainActivity)c).findViewById(R.id.framelo);
        ImageView iv = new ImageView(c);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(50, 50);
        iv.setLayoutParams(params);

        iv.setBackgroundResource(draw);
        iv.setElevation(5);
        fl.addView(iv);

        return iv;
    }
}
