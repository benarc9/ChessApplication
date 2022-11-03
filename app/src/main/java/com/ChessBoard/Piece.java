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

    //i need to move the position of imageView in move() so that when a piece moves the image does too
    public void setPosition(int[] position) {
        iv.setX(position[0]);
        iv.setY(position[1]);
    }

    //if king is checked
        //(move king) or (block the king from being checked) or (take the thing that checked king)
    public boolean isKingChecked() {

        boolean check = false;
        BoardTile fromCurrentTile;

        if (gameBoard[xCoord][yCoord].getChessPiece().toString() == "King") {
            //can I do this by checking validMoves on king in the directions of Pawn, Rook, Knight, Bishop, Queen
            //then the first tile that it comes into contact with it will check if it is the respective piece on it.
            //if it is then the king has to move or another piece has interrupt the tunnel vision of the piece.
            fromCurrentTile = gameBoard[xCoord][yCoord];
            if (fromCurrentTile.getChessPiece().getPieceColor() == 0) {



                if (pawnChecks(fromCurrentTile) || rookChecks(fromCurrentTile) || knightChecks(fromCurrentTile) || bishopChecks(fromCurrentTile) || queenChecks(fromCurrentTile)) {
                    check = true;
                } else {
                    check = false;
                }
            }


        }

        return check;
    }



    private boolean pawnChecks(BoardTile tile) {

        int spotColor = tile.getChessPiece().getPieceColor();

        if (spotColor == 0) {
            tile = gameBoard[this.getX() - 1][this.getY() - 1];
            if (tile.spotTaken() || (tile.getChessPiece().getPieceColor() != spotColor &&
                    tile.getChessPiece().toString() == "Pawn")) {

                return true;
            }

            tile = gameBoard[this.getX() + 1][this.getY() - 1];
            if (tile.spotTaken() && (tile.getChessPiece().getPieceColor() != spotColor &&
                    tile.getChessPiece().toString() == "Pawn")) {

                return true;
            }
            return false;
        } else {
            tile = gameBoard[this.getX() + 1][this.getY() + 1];
            if (tile.spotTaken() || (tile.getChessPiece().getPieceColor() != spotColor &&
                    tile.getChessPiece().toString() == "Pawn")) {

                return true;
            }

            tile = gameBoard[this.getX() - 1][this.getY() + 1];
            if (tile.spotTaken() && (tile.getChessPiece().getPieceColor() != spotColor &&
                    tile.getChessPiece().toString() == "Pawn")) {

                return true;
            }
            return false;
        }

    }


    private boolean rookChecks(BoardTile tile) {

        int spotColor = tile.getChessPiece().getPieceColor();

        for (int count = 0; count < 4; count++) {
            for (int i = 1; i < 8; i++) {

                if (count == 0) {

                    tile = gameBoard[this.getX() + i][this.getY()];
                } else if (count == 1) {

                    tile = gameBoard[this.getX()][this.getY() + i];
                } else if (count == 2) {

                    tile = gameBoard[this.getX()][this.getY() - i];
                } else if (count == 3) {

                    tile = gameBoard[this.getX() - i][this.getY()];
                }
                if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                    if (tile.spotTaken() && tile.getChessPiece().getPieceColor() != spotColor  &&
                            tile.getChessPiece().toString() == "Rook") {

                        return true;
                    }
                }
            }
        }
        return false;
    }


    private boolean knightChecks(BoardTile currentTile) {

            BoardTile tile0 = gameBoard[this.getX() + 1][this.getY() + 2];
            BoardTile tile1 = gameBoard[this.getX() - 1][this.getY() + 2];
            BoardTile tile2 = gameBoard[this.getX() + 1][this.getY() - 2];
            BoardTile tile3 = gameBoard[this.getX() - 1][this.getY() - 2];
            BoardTile tile4 = gameBoard[this.getX() + 2][this.getY() + 1];
            BoardTile tile5 = gameBoard[this.getX() + 2][this.getY() - 1];
            BoardTile tile6 = gameBoard[this.getX() - 2][this.getY() + 1];
            BoardTile tile7 = gameBoard[this.getX() - 2][this.getY() - 1];

            //whichever piece returned true then that is the one that needs to be placed in front of to block or whatnot.
            return (knHelper(currentTile, tile0) || knHelper(currentTile, tile1) || knHelper(currentTile, tile2) ||
                    knHelper(currentTile, tile3) || knHelper(currentTile, tile4) || knHelper(currentTile, tile5) ||
                    knHelper(currentTile, tile6) || knHelper(currentTile, tile7));

    }

    public boolean knHelper(BoardTile currentTile, BoardTile tile) {

        int spotColor = currentTile.getChessPiece().getPieceColor();

        if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {
            if (tile.spotTaken() && (tile.getChessPiece().getPieceColor() != spotColor &&
                                    tile.getChessPiece().toString() == "Knight")) {
                return true;
            }
        }
        return false;
    }


    private boolean bishopChecks(BoardTile tile) {

        int spotColor = tile.getChessPiece().getPieceColor();


            for (int count = 0; count < 4; count++) {

                for (int i = 1; i < 8; i++) {

                    if (count == 0) {

                        tile = gameBoard[this.getX() + i][this.getY() + i];
                    } else if (count == 1) {

                        tile = gameBoard[this.getX() + i][this.getY() - i];
                    } else if (count == 2) {

                        tile = gameBoard[this.getX() - i][this.getY() + i];
                    } else if (count == 3) {

                        tile = gameBoard[this.getX() - i][this.getY() - i];
                    }
                    if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {

                        if (tile.spotTaken() && tile.getChessPiece().getPieceColor() != spotColor &&
                                tile.getChessPiece().toString() == "Bishop") {

                            return true;
                        }
                    }
                }
            }
            return false;

    }


    private boolean circleChecks(BoardTile currentTile) {

        BoardTile tile0 = gameBoard[this.getX() - 1][this.getY() - 1];
        BoardTile tile1 = gameBoard[this.getX()][this.getY() - 1];
        BoardTile tile2 = gameBoard[this.getX() + 1][this.getY() - 1];
        BoardTile tile3 = gameBoard[this.getX() + 1][this.getY()];
        BoardTile tile4 = gameBoard[this.getX() + 1][this.getY() + 1];
        BoardTile tile5 = gameBoard[this.getX()][this.getY() + 1];
        BoardTile tile6 = gameBoard[this.getX() - 1][this.getY() + 1];
        BoardTile tile7 = gameBoard[this.getX() - 1][this.getY()];

        return (ccHelper(currentTile, tile0) || ccHelper(currentTile, tile1) || ccHelper(currentTile, tile2) ||
                ccHelper(currentTile, tile3) || ccHelper(currentTile, tile4) || ccHelper(currentTile, tile5) ||
                ccHelper(currentTile, tile6) || ccHelper(currentTile, tile7));
    }

    public boolean ccHelper(BoardTile currentTile, BoardTile tile) {

        int spotColor = currentTile.getChessPiece().getPieceColor();

        if (tile.getX() < 8 && tile.getX() >= 0 && tile.getY() >= 0 && tile.getY() < 8) {
            if (tile.spotTaken() || (tile.getChessPiece().getPieceColor() != spotColor &&
                    tile.getChessPiece().toString() == "King")) {
                return true;
            }
        }
        return false;
    }



    private boolean queenChecks(BoardTile fromCurrentTile) {

        if (rookChecks(fromCurrentTile) || bishopChecks(fromCurrentTile) || circleChecks(fromCurrentTile)) {
            return true;
        }
        return false;
    }


}




//before moving a piece and after/during moving a piece have to check if the king is checked on the persons
//turn of moving. should not allow to place a piece if checked or if it will make the king checked.

//king has to move or piece has to take or has to use piece to block(cant do that if knight/pawn is checking)

//also have two check the CHECK in advance for if you can take the piece that is check the current piece or not
//(if not that means another piece is protecting it)




