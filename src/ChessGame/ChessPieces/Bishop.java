package ChessGame.ChessPieces;
import ChessGame.ChessBoard;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }


    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine && column == toColumn) {
            return false;
        }

        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }
        if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(getColor())) {
            return false;
        }

        int directionX = (toColumn - column) > 0 ? 1 : -1;
        int directionY = (toLine - line) > 0 ? 1 : -1;
        for (int i = 1; i < Math.abs(toLine - line); i++) {
            if (chessBoard.board[line + i * directionY][column + i * directionX] != null) {
                return false; // На пути другая фигура
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
