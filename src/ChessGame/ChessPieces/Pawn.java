package ChessGame.ChessPieces;
import ChessGame.ChessBoard;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
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
        // Проверяем, не выходит ли пешка за пределы доски
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }

        if (getColor().equals("White")) {
            if (toLine > line) {
                if (line == 1 && toLine == 3 && column == toColumn) {
                    return true;
                }
                return toLine == line + 1 && column == toColumn;
            } else {
                return false;
            }
        } else {
            if (toLine < line) {
                if (line == 6 && toLine == 4 && column == toColumn) {
                    return true;
                }
                return toLine == line - 1 && column == toColumn;
            } else {
                return false;
            }
        }

    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
