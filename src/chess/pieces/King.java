package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position pos){
        ChessPiece p = (ChessPiece)getBoard().piece(pos);
        return p== null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);
        //acima
        p.setValues(position.getRows() - 1 ,position.getColumns());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        // abaixo
        p.setValues(position.getRows() + 1, position.getColumns());
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        // esquerda
        p.setValues(position.getRows(), position.getColumns() - 1 );
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        // direita
        p.setValues(position.getRows(), position.getColumns() + 1 );
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        // diagonal direita superior
        p.setValues(position.getRows() - 1, position.getColumns() + 1 );
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        // diagonal esquerda superior
        p.setValues(position.getRows() - 1, position.getColumns() - 1 );
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        // diagonal direita inferior
        p.setValues(position.getRows() + 1, position.getColumns() + 1 );
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }

        // diagonal esquerda inferior
        p.setValues(position.getRows() + 1, position.getColumns() - 1 );
        if(getBoard().positionExists(p) && canMove(p)){
            mat[p.getRows()][p.getColumns()] = true;
        }


        return mat;
    }
}
