package com.ChessBoard;

import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public abstract class Piece {

    protected int xCoord;
    protected int yCoord;
    protected int pieceColor;
    protected BoardTile[][] gameBoard;
    private ImageView iv;



    public Piece(BoardTile[][] gameBoard, int xCoord, int yCoord, int pieceColor, ImageView iv) {

        this.pieceColor = pieceColor;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.gameBoard = gameBoard;
        this.iv = iv;

    }

    public abstract String toString();

    public abstract ArrayList<BoardTile> getValidMoves();

    public abstract int getPieceColor();

    public abstract int getX();

    public abstract int getY();

    /*
    * remove from current Tile
    * add to next Tile
    * remove piece that is at attacked Tile
    * swap x and y
    * set position of ImageView to the new Tile
    *
    * */
    public void move(BoardTile tile) {
        BoardTile currentTile = gameBoard[xCoord][yCoord];
        currentTile.removePiece();
        if (tile.getChessPiece().getPieceColor() != pieceColor) {
            tile.removePiece();
        }
        tile.setChessPiece(this);
        xCoord = tile.getX();
        yCoord = tile.getY();

        //0 is x
        //1 is y
        iv.setX(tile.getButtonPosition()[0]);
        iv.setY(tile.getButtonPosition()[1]);

    }

    public void pieceKilled() {
        gameBoard[xCoord][yCoord].removePiece();
        //or
        //this.piece = null;
    }

    public void setPosition(int[] position) {
        iv.setX(position[0] + 25);
        iv.setY(position[1] - 275);
    }

}
