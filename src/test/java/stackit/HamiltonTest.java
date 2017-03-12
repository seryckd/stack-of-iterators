package stackit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2017-03-02.
 */
public class HamiltonTest {

    @Test
    public void path() throws Exception {

        List<Tuple> gridDirections = new ArrayList<>();
        gridDirections.add(new Tuple(0,1));
        gridDirections.add(new Tuple(1,0));
        gridDirections.add(new Tuple(0,-1));
        gridDirections.add(new Tuple(-1,0));

        List<Tuple> box = new ArrayList<>();
        box.add(new Tuple(0,0));
        box.add(new Tuple(0,1));
        box.add(new Tuple(0,2));

        box.add(new Tuple(1,0));
        box.add(new Tuple(1,1));
        box.add(new Tuple(1,2));

        box.add(new Tuple(2,0));
        box.add(new Tuple(2,1));
//        box.add(new Tuple(2,2));

        Tuple[] result = Hamilton.findPath(new Tuple(1,1), box, gridDirections);

        System.out.println(Arrays.toString(result));
    }


}