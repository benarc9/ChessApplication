package com.ChessBoard;

import android.widget.ImageView;

import java.util.ArrayList;

public class Rook extends Piece{

    ArrayList<BoardTile> validTiles = new ArrayList<BoardTile>();

    public Rook(BoardTile[][] gameBoard, int xCoord, int yCoord, int pieceColor, ImageView iv) {
        super(gameBoard, xCoord, yCoord, pieceColor, iv);
    }

    @Override
    public String toString() {
        return "Rook";
    }

    @Override
    public ArrayList<BoardTile> getValidMoves() {

        validTiles = new ArrayList<BoardTile>();
        BoardTile tile;

        if (this.pieceColor == 0) {

            //checks all spots horizontally to the right and will check all vertically down
            for (int i = 1; i < 8; i++) {
                //sets tile to the right one spot of current spot that it is at
                tile = gameBoard[this.getX() + i][this.getY()];
                //checks if that spot to the right of that current spot is in bounds at all sides
                // (I have to check for bounds because it is a for loop)
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {
                    //checks if the tile is taken in the spot to the right 1
                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 1) {
                        validTiles.add(tile);
                    }
                }

                tile = gameBoard[this.getX()][this.getY() + i];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 1) {

                        validTiles.add(tile);
                    }
                }
            }

            for (int i = 1; i < 8; i++) {

                tile = gameBoard[this.getX() - i][this.getY()];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 1) {

                        validTiles.add(tile);
                    }

                }

                tile = gameBoard[this.getX()][this.getY() - i];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 1) {

                        validTiles.add(tile);
                    }

                }

            }
            return validTiles;

        } else {

            for (int i = 1; i < 8; i++) {
                //sets tile to the right one spot of current spot that it is at
                tile = gameBoard[this.getX() + i][this.getY()];
                //checks if that spot to the right of that current spot is in bounds at all sides
                // (I have to check for bounds because it is a for loop)
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {
                    //checks if the tile is taken in the spot to the right 1
                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 0) {
                        validTiles.add(tile);
                    }
                }

                tile = gameBoard[this.getX()][this.getY() + i];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 0) {

                        validTiles.add(tile);
                    }
                }
            }

            for (int j = 1; j < 8; j++) {

                tile = gameBoard[this.getX() - j][this.getY()];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 0) {

                        validTiles.add(tile);
                    }

                }

                tile = gameBoard[this.getX()][this.getY() - j];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 0) {

                        validTiles.add(tile);
                    }

                }

            }
            return validTiles;

        }

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
