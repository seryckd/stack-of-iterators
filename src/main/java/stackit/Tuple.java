package stackit;

public class Tuple {
    private final int x_;
    private final int y_;

    public Tuple(int x, int y) {
        x_ = x;
        y_ = y;
    }

    public int getX() {
        return x_;
    }

    public int getY() {
        return y_;
    }

    @Override
    public boolean equals(Object rhs) {
        return x_ == ((Tuple) rhs).x_ && y_ == ((Tuple) rhs).y_;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", x_, y_);
    }

    public Tuple add(Tuple rhs) {
        return new Tuple(x_ + rhs.x_, y_ + rhs.y_);
    }
}
