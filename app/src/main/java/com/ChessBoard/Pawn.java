package com.ChessBoard;

import android.widget.ImageView;

import java.util.ArrayList;


//not including en pessant
public class Pawn extends Piece {

    ArrayList<BoardTile> validTiles = new ArrayList<BoardTile>();



    public Pawn(BoardTile[][] gameBoard, int xCoord, int yCoord, int pieceColor, ImageView iv) {
        super(gameBoard, xCoord, yCoord, pieceColor, iv);
    }

    @Override
    public int getPieceColor() {
        return this.pieceColor;
    }

    @Override
    public int getX() {
        return this.xCoord;
    }

    @Override
    public int getY() {
        return this.yCoord;
    }


    public ArrayList<BoardTile> getValidMoves() {

        validTiles = new ArrayList<BoardTile>();

        BoardTile tile;
        //if the piece is white
        if (this.pieceColor == 0) {

            //if the x coord is 1 at any point of the game
            if (this.getX() == 6) {

                //if the tile up one from current piece is null
                tile = gameBoard[this.getX()][this.getY() - 1];
                if (!tile.spotTaken()) {

                    //adds a move to validTiles (up 1)
                    validTiles.add(tile);

                    //if the tile up two from current piece is null
                    tile = gameBoard[this.getX()][this.getY() - 2];
                    if (!tile.spotTaken()) {
                        //adds a move to validTiles (up 2)
                        validTiles.add(tile);

                    }
                }
            //if pawn is not at starting position (6)
            } else {
                //adds a move to validTiles (up 1)
                tile = gameBoard[this.getX()][this.getY() - 1];
                validTiles.add(tile);

            }

            tile = gameBoard[this.getX() - 1][this.getY() - 1];
            if (tile.spotTaken()) {
                //if that piece is black
                if (tile.getChessPiece().getPieceColor() == 1) {
                    //adds a move to validTiles (diagonal up left)
                    validTiles.add(tile);
                }
            }

            tile = gameBoard[this.getX() + 1][this.getY() - 1];
            if (tile.spotTaken()) {
                //if that piece is black
                if (tile.getChessPiece().getPieceColor() == 1) {
                    //adds a move to validTiles (diagonal up left)
                    validTiles.add(tile);
                }
            }
            return validTiles;
        } else {
            if (this.getX() == 1) {

                //if the tile up one from current piece is null
                tile = gameBoard[this.getX()][this.getY() + 1];
                if (!tile.spotTaken()) {

                    //adds a move to validTiles (up 1)
                    validTiles.add(tile);

                    //if the tile up two from current piece is null
                    tile = gameBoard[this.getX()][this.getY() + 2];
                    if (!tile.spotTaken()) {
                        //adds a move to validTiles (up 2)
                        validTiles.add(tile);

                    }
                }
                //if pawn is not at starting position (6)
            } else {
                //adds a move to validTiles (up 1)
                tile = gameBoard[this.getX()][this.getY() + 1];
                validTiles.add(tile);

            }

            tile = gameBoard[this.getX() - 1][this.getY() + 1];
            if (tile.spotTaken()) {
                //if that piece is black
                if (tile.getChessPiece().getPieceColor() == 0) {
                    //adds a move to validTiles (diagonal up left)
                    validTiles.add(tile);
                }
            }

            tile = gameBoard[this.getX() + 1][this.getY() + 1];
            if (tile.spotTaken()) {
                //if that piece is black
                if (tile.getChessPiece().getPieceColor() == 0) {
                    //adds a move to validTiles (diagonal up left)
                    validTiles.add(tile);
                }
            }

            return validTiles;
        }


    }


}