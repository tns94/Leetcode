package october;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3508/
 */
public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        List<Double> list = new ArrayList<>();
        list.add((double) poured);

        while (query_row-- > 0) {
            List<Double> temp = new ArrayList<>();
            temp.add(Math.max(0, list.get(0) - 1) / 2);
            for (int i = 1; i < list.size(); i++) {
                temp.add(Math.max(0, (list.get(i - 1) - 1) / 2) + Math.max(0, (list.get(i) - 1) / 2));
            }
            temp.add(temp.get(0));
            list = temp;
        }

        return Math.min(1, list.get(query_glass));
    }
}
