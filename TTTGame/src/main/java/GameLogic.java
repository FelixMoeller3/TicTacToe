public class GameLogic {
  private final GameBoard board;
  private boolean playerOneTurn;
  private boolean gameOver;
  private int move;
  private GameWinner winner;

  public GameLogic() {
    this.board = new GameBoard();
    this.playerOneTurn = true;
    this.gameOver = false;
    this.move=1;
  }

  public boolean newMove(int position) {
    if(!setToken(position)) {
      return false;
    }
    setWinner();
    if(winner == null) {
      move ++;
      playerOneTurn = !playerOneTurn;
    }
    return true;
  }

  private boolean setToken(int position) {
    if(gameOver) {
      return false;
    }
    GameIcon token = playerOneTurn ? GameIcon.CROSS : GameIcon.CIRCLE;
    return board.setToken(position, token);
  }

  private void setWinner() {
    gameOver = board.gameWon();
    if(move == 9) {
      gameOver = true;
      winner = GameWinner.TIE;
      return;
    }
    if(gameOver) {
        winner = playerOneTurn ? GameWinner.P1: GameWinner.P2;
    }
  }

  public void printBoard() {
    System.out.print(board.toString());
  }
}
