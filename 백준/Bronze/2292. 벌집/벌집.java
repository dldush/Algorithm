import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());

        int layer = 1;
        int end = 1;

        while (target > end) {
            end = end + layer * 6;
            layer++;

        }

        System.out.println(layer);
    }
}
