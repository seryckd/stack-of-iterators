package stackit;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.function.Supplier;

/**
 * Java conversion of solving stackit.Hamilton problem using
 * Stack of Iterators Pattern
 *
 * from http://garethrees.org/2016/09/28/pattern/
 *
 * An alternative to recursion
 * 1) lists can grow without limit (recursion will ultimately run out of stack)
 * 2) Can return at any point without running back through the recursed functions
 */
public class Hamilton {


    // closure to remember where we were in the iterator
    static <T> Supplier<T> make(Iterator<T> i) {
        return () -> i.hasNext() ? i.next() : null;
    }


    /**
     * Find a path that visits all positions
     *
     * @param start Start Tuple. Must be in positions
     * @param positions List of positions by (x,y) coord
     * @param directions List of directions we can move in
     * @return
     */
    public static Tuple[] findPath(Tuple start, List<Tuple> positions, List<Tuple> directions) {

        Stack<Supplier<Tuple>> stack = new Stack<>();

        Stack<Tuple> path = new Stack<>();
        path.push(start);

        positions.remove(start);

        stack.push(make(directions.iterator()));

        nextPath:
        while (!path.isEmpty()) {

            Tuple coord = path.peek();
            Tuple direction;

            while (!stack.empty() && (direction = stack.peek().get()) != null) {
                Tuple pos = coord.add(direction);

                if (positions.indexOf(pos) != -1) {
                    path.push(pos);
                    positions.remove(pos);
                    stack.push(make(directions.iterator()));
                    if (positions.size() == 0) {
                        return path.toArray(new Tuple[0]);
                    }

                    // We need to exit this loop without executing the next
                    // code block
                    continue nextPath;
                }
            }

            // Execute this when stack is empty or exhausted directions

            positions.add(path.pop());
            stack.pop();
        }

        System.out.println("no path");
        return new Tuple[0];
    }

    public static int main(String[] args) {
        return -1;
    }
}
