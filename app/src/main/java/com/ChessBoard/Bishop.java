package com.ChessBoard;

import android.widget.ImageView;

import java.util.ArrayList;

public class Bishop extends Piece{

    ArrayList<BoardTile> validTiles = new ArrayList<BoardTile>();

    public Bishop(BoardTile[][] gameBoard, int xCoord, int yCoord, int pieceColor, ImageView iv) {
        super(gameBoard, xCoord, yCoord, pieceColor, iv);
    }

    @Override
    public ArrayList<BoardTile> getValidMoves() {
        validTiles = new ArrayList<BoardTile>();
        BoardTile tile;

        if (this.pieceColor == 0) {

            //checks all spots down-right diagonally from current spot

            for (int i = 1; i < 8; i++) {
                //sets tile diagonal bottom right one spot
                tile = gameBoard[this.getX() + i][this.getY() + i];
                //checks if that bottom-right spot is in bounds of the board
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {
                    //checks if the tile is taken in the spot to the right 1
                    if (!tile.spotTaken()) {
                        validTiles.add(tile);
                    }
                    if (tile.getChessPiece().getPieceColor() == 1) {
                        validTiles.add(tile);
                    }
                }
                //sets tile down one spot from current spot that it is at
                tile = gameBoard[this.getX() - i][this.getY() - i];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken()) {
                        validTiles.add(tile);
                    }
                    if (tile.getChessPiece().getPieceColor() == 1) {
                        validTiles.add(tile);
                    }
                }

                //sets tile down one spot from current spot that it is at
                tile = gameBoard[this.getX() + i][this.getY() - i];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken()) {
                        validTiles.add(tile);
                    }
                    if (tile.getChessPiece().getPieceColor() == 1) {
                        validTiles.add(tile);
                    }
                }

                //sets tile down one spot from current spot that it is at
                tile = gameBoard[this.getX() - i][this.getY() + i];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken()) {
                        validTiles.add(tile);
                    }
                    if (tile.getChessPiece().getPieceColor() == 1) {
                        validTiles.add(tile);
                    }
                }

            }

        }
        return validTiles;
    }

    @Override
    public int getPieceColor() {
        return this.pieceColor;
    }

    @Override
    public int getX() {
        return xCoord;
    }

    @Override
    public int getY() {
        return yCoord;
    }
}
