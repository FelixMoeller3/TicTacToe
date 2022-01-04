public enum GameIcon {
  EMPTY,
  CROSS,
  CIRCLE;

  @Override
  public String toString() {
    switch(this){
      case EMPTY: return "-";
      case CROSS: return "X";
      case CIRCLE: return "O";
      default: throw new IllegalArgumentException();
    }
  }
}
