package ChessGame.ChessPieces;
import ChessGame.ChessBoard;

public class Queen extends ChessPiece {
    public Queen(String color) {
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

        if ((line == toLine && column != toColumn) || (line != toLine && column == toColumn) || (Math.abs(toLine - line) == Math.abs(toColumn - column))) {
            if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(getColor())) {
                return false;
            }


            if (line == toLine) {
                for (int i = Math.min(column, toColumn) + 1; i < Math.max(column, toColumn); i++) {
                    if (chessBoard.board[line][i] != null) {
                        return false;
                    }
                }
            } else if (column == toColumn) {
                for (int i = Math.min(line, toLine) + 1; i < Math.max(line, toLine); i++) {
                    if (chessBoard.board[i][column] != null) {
                        return false;
                    }
                }
            } else {
                int directionX = (toColumn - column) > 0 ? 1 : -1;
                int directionY = (toLine - line) > 0 ? 1 : -1;
                for (int i = 1; i < Math.abs(toLine - line); i++) {
                    if (chessBoard.board[line + i * directionY][column + i * directionX] != null) {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
