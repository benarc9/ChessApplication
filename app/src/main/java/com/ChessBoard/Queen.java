package com.ChessBoard;

import android.widget.ImageView;

import java.util.ArrayList;

public class Queen extends Piece{

    ArrayList<BoardTile> validTiles = new ArrayList<BoardTile>();

    public Queen(BoardTile[][] gameBoard, int xCoord, int yCoord, int pieceColor, ImageView iv) {
        super(gameBoard, xCoord, yCoord, pieceColor, iv);
    }

    @Override
    public ArrayList<BoardTile> getValidMoves() {

        validTiles = new ArrayList<BoardTile>();
        BoardTile tile;

        if (this.pieceColor == 0) {
            //bishops moves
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

            //kings moves
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

            //rooks moves
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

            for (int j = 1; j < 8; j++) {

                tile = gameBoard[this.getX() - j][this.getY()];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 1) {

                        validTiles.add(tile);
                    }

                }

                tile = gameBoard[this.getX()][this.getY() - j];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 1) {

                        validTiles.add(tile);
                    }

                }

            }
            return validTiles;
        } else {
            //bishops moves
            for (int i = 1; i < 8; i++) {
                //sets tile diagonal bottom right one spot
                tile = gameBoard[this.getX() + i][this.getY() + i];
                //checks if that bottom-right spot is in bounds of the board
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {
                    //checks if the tile is taken in the spot to the right 1
                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 0) {

                        validTiles.add(tile);
                    }
                }
                //sets tile down one spot from current spot that it is at
                tile = gameBoard[this.getX() - i][this.getY() - i];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 0) {

                        validTiles.add(tile);
                    }
                }

                //sets tile down one spot from current spot that it is at
                tile = gameBoard[this.getX() + i][this.getY() - i];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 0) {

                        validTiles.add(tile);
                    }
                }

                //sets tile down one spot from current spot that it is at
                tile = gameBoard[this.getX() - i][this.getY() + i];
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (!tile.spotTaken() || tile.getChessPiece().getPieceColor() == 0) {

                        validTiles.add(tile);
                    }
                }

            }

            //kings moves
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

            //rooks moves
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
