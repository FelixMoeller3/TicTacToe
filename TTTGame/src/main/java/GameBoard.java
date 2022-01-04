public class GameBoard {
  private GameIcon[][] board;

  public GameBoard() {
    this.board = new GameIcon[3][3];
    for(int i=0; i<3; i++) {
      for(int j=0; j<3; j++) {
        board[i][j] = GameIcon.EMPTY;
      }
    }
  }

  public boolean setToken(int position, GameIcon token) {
    if(position < 1 || position > 9) {
      return false;
    }
    int row = (position - 1) / 3;
    int column = (position-1) % 3;
    if(board[row][column] != GameIcon.EMPTY) {
      return false;
    }
    board[row][column] = token;
    return true;
  }

  public boolean gameWon() {
    // check rows
    for(int i = 0; i < 3; i++){
      if(rowEquals(i)) {
        return true;
      }
    }

    //check columns
    for(int i = 0; i < 3; i++){
      if(columnEquals(i)) {
        return true;
      }
    }

    return checkDiagonals();
  }

  private boolean checkDiagonals() {
    if (board[2][2] == GameIcon.EMPTY) {
      return false;
    }
    return (board[1][1] == board[2][2] && board[2][2] == board [3][3])
            || (board [1][3] == board[2][2] && board[2][2] == board[3][1]);
  }

  private boolean rowEquals(int rownum) {
    if(rownum < 0 || rownum > 2) {
      return false;
    }
    if(board[rownum][0] == GameIcon.EMPTY) {
      return false;
    }
    return board[rownum][0] == board[rownum][1] && board[rownum][1] == board[rownum][2];
  }

  private boolean columnEquals(int colnum) {
    if(colnum < 0 || colnum > 2) {
      return false;
    }
    if(board[0][colnum] == GameIcon.EMPTY) {
      return false;
    }
    return board[0][colnum] == board[1][colnum] && board[1][colnum] == board[2][colnum];
  }

  public GameIcon[][] getBoard() {
    return this.board;
  }

  public String linetoString(int index) {
    if(index < 0 || index > 2) {
      throw new IllegalArgumentException();
    }
    return board[index][0].toString() + "|" + board[index][1].toString() +  "|" + board[index][2].toString();
  }

  @Override
  public String toString(){
    String rowSeparator = "______";
    String newLine = System.getProperty("line.separator");
    return new StringBuilder()
            .append(linetoString(0))
            .append(newLine)
            .append(linetoString(1))
            .append(newLine)
            .append(linetoString(2))
            .toString();
  }

}
