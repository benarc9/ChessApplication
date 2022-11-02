package com.ChessBoard;

import android.widget.ImageView;

import java.util.ArrayList;

public class Knight extends Piece{

    ArrayList<BoardTile> validTiles = new ArrayList<BoardTile>();

    public Knight(BoardTile[][] gameBoard, int xCoord, int yCoord, int pieceColor, ImageView iv) {
        super(gameBoard, xCoord, yCoord, pieceColor, iv);
    }

    @Override
    public ArrayList<BoardTile> getValidMoves() {

        validTiles = new ArrayList<BoardTile>();

        if (this.pieceColor == 0) {

            BoardTile tile0 = gameBoard[this.getX() + 1][this.getY() + 2];
            BoardTile tile1 = gameBoard[this.getX() - 1][this.getY() + 2];
            BoardTile tile2 = gameBoard[this.getX() + 1][this.getY() - 2];
            BoardTile tile3 = gameBoard[this.getX() - 1][this.getY() - 2];
            BoardTile tile4 = gameBoard[this.getX() + 2][this.getY() + 1];
            BoardTile tile5 = gameBoard[this.getX() + 2][this.getY() - 1];
            BoardTile tile6 = gameBoard[this.getX() - 2][this.getY() + 1];
            BoardTile tile7 = gameBoard[this.getX() - 2][this.getY() - 1];

            addsValidTile(tile0, 1);
            addsValidTile(tile1, 1);
            addsValidTile(tile2, 1);
            addsValidTile(tile3, 1);
            addsValidTile(tile4, 1);
            addsValidTile(tile5, 1);
            addsValidTile(tile6, 1);
            addsValidTile(tile7, 1);

            return validTiles;

        } else {

            BoardTile tile0 = gameBoard[this.getX() + 1][this.getY() + 2];
            BoardTile tile1 = gameBoard[this.getX() - 1][this.getY() + 2];
            BoardTile tile2 = gameBoard[this.getX() + 1][this.getY() - 2];
            BoardTile tile3 = gameBoard[this.getX() - 1][this.getY() - 2];
            BoardTile tile4 = gameBoard[this.getX() + 2][this.getY() + 1];
            BoardTile tile5 = gameBoard[this.getX() + 2][this.getY() - 1];
            BoardTile tile6 = gameBoard[this.getX() - 2][this.getY() + 1];
            BoardTile tile7 = gameBoard[this.getX() - 2][this.getY() - 1];

            addsValidTile(tile0, 0);
            addsValidTile(tile1, 0);
            addsValidTile(tile2, 0);
            addsValidTile(tile3, 0);
            addsValidTile(tile4, 0);
            addsValidTile(tile5, 0);
            addsValidTile(tile6, 0);
            addsValidTile(tile7, 0);

            return validTiles;
        }
    }

    public void addsValidTile(BoardTile tile, int attackColor) {

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
