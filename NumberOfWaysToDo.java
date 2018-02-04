public class NumberOfWaysToDo {

  public static void main(String[] args) {
    NumberOfWaysToDo todo = new NumberOfWaysToDo();

    System.out.println(todo.numberOfSteps(10));
    System.out.println(todo.numberOfStepsExtraSpace(10));
    System.out.println(todo.numberOfStepsDP(10));
  }


  private int numberOfSteps(int totalSteps) {
    if ( totalSteps < 0) {
      return 0;
    }else if (totalSteps == 0 ) {
      return 1;
    }else {
      return numberOfSteps(totalSteps -1) + numberOfSteps(totalSteps -2) + numberOfSteps(totalSteps -3);
    }
  }

  private long numberOfStepsExtraSpace(int steps) {
    return numberOfStepsExtraSpace(steps, new long[steps + 1]);
  }
  private long numberOfStepsExtraSpace(int totalSteps, long[] memo) {
    if ( totalSteps < 0) {
      return 0;
    }else if (totalSteps == 0 ) {
      return 1;
    }else {
      if (memo[totalSteps] == 0) {
        memo[totalSteps] =  numberOfStepsExtraSpace(totalSteps -1, memo) +
        numberOfStepsExtraSpace(totalSteps -2,memo) + numberOfStepsExtraSpace(totalSteps -3, memo);
      }
      return memo[totalSteps];
    }
  }

  private long numberOfStepsDP(int totalSteps) {
    long[] paths = new long[3];

    paths[0] = 1;
    paths[1] = 1;
    paths[2] = 2;

    for (int i = 3; i <= totalSteps; i++) {
      long count = paths[0] + paths[1] + paths[2];
      paths[0] = paths[1];
      paths[1] = paths[2];
      paths[2] = count;
    }
    return paths[2];

  }
}
