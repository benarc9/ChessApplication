package com.ChessBoard;

import android.widget.ImageView;

import java.util.ArrayList;

public class King extends Piece {

    ArrayList<BoardTile> validTiles = new ArrayList<BoardTile>();

    public King(BoardTile[][] gameBoard, int xCoord, int yCoord, int pieceColor, ImageView iv) {
        super(gameBoard, xCoord, yCoord, pieceColor, iv);
    }

    @Override
    public String toString() {
        return "King";
    }

    @Override
    public ArrayList<BoardTile> getValidMoves() {

        validTiles = new ArrayList<BoardTile>();
        BoardTile tile;

        // i think bounds need to be checked because yeah the user wont click a spot that
        // is out of bounds but the method has to check every single available one around
        // themselves (current pieces), right? yk?

        if (this.pieceColor == 0) {

            BoardTile tile0 = gameBoard[this.getX() - 1][this.getY() - 1];
            BoardTile tile1 = gameBoard[this.getX()][this.getY() - 1];
            BoardTile tile2 = gameBoard[this.getX() + 1][this.getY() - 1];
            BoardTile tile3 = gameBoard[this.getX() + 1][this.getY()];
            BoardTile tile4 = gameBoard[this.getX() + 1][this.getY() + 1];
            BoardTile tile5 = gameBoard[this.getX()][this.getY() + 1];
            BoardTile tile6 = gameBoard[this.getX() - 1][this.getY() + 1];
            BoardTile tile7 = gameBoard[this.getX() - 1][this.getY()];

            addsValidMoves(tile0, 1);
            addsValidMoves(tile1, 1);
            addsValidMoves(tile2, 1);
            addsValidMoves(tile3, 1);
            addsValidMoves(tile4, 1);
            addsValidMoves(tile5, 1);
            addsValidMoves(tile6, 1);
            addsValidMoves(tile7, 1);

            return validTiles;

        } else {
            BoardTile tile0 = gameBoard[this.getX() - 1][this.getY() - 1];
            BoardTile tile1 = gameBoard[this.getX()][this.getY() - 1];
            BoardTile tile2 = gameBoard[this.getX() + 1][this.getY() - 1];
            BoardTile tile3 = gameBoard[this.getX() + 1][this.getY()];
            BoardTile tile4 = gameBoard[this.getX() + 1][this.getY() + 1];
            BoardTile tile5 = gameBoard[this.getX()][this.getY() + 1];
            BoardTile tile6 = gameBoard[this.getX() - 1][this.getY() + 1];
            BoardTile tile7 = gameBoard[this.getX() - 1][this.getY()];

            addsValidMoves(tile0, 0);
            addsValidMoves(tile1, 0);
            addsValidMoves(tile2, 0);
            addsValidMoves(tile3, 0);
            addsValidMoves(tile4, 0);
            addsValidMoves(tile5, 0);
            addsValidMoves(tile6, 0);
            addsValidMoves(tile7, 0);

            return validTiles;
        }





    }


    public void addsValidMoves(BoardTile tile, int attackColor) {
        if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {
            if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == attackColor) {
                validTiles.add(tile);
            }
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
