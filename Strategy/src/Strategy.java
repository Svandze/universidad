interface Movement {
    void move();
}

class IAMovement implements Movement {
    @Override
    public void move() {
        System.out.println("IA Movement");
    }
}

class RandomMovement implements Movement {
    @Override
    public void move() {
        System.out.println("Random movement");
    }
}

class GamePlayer {
    private Movement movement;

    void setMovement(Movement movement) {
        this.movement = movement;
    }

    void doBestMove() {
        movement.move();
    }
}
