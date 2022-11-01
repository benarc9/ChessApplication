package com.ChessBoard;

import android.widget.ImageView;

import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(BoardTile[][] gameBoard, int xCoord, int yCoord, int pieceColor, ImageView iv) {
        super(gameBoard, xCoord, yCoord, pieceColor, iv);
    }

    @Override
    public ArrayList<BoardTile> getValidMoves() {
        return null;
    }

    @Override
    public int getPieceColor() {
        return 0;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }
}
