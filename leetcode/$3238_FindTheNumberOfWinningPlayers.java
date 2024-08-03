package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class $3238_FindTheNumberOfWinningPlayers {
    public int winningPlayerCount(int n, int[][] pick) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < pick.length; i++) {
            set.add(pick[i][0]);
        }
        ArrayList<Integer> players = new ArrayList<>();
        for (Integer player : set) {
            players.add(player);
        }
        for (int i = 0; i < players.size(); i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int xi = players.get(i);
            for (int j = 0; j < pick.length; j++) {
                if (pick[j][0] == xi) {
                    list.add(pick[j][1]);
                }
            }
            list.sort(Comparator.naturalOrder());
            System.out.println("List: " + list);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int k = 0; k < list.size(); k++) {
                int game = list.get(k);
                map.put(game, map.getOrDefault(game, 0) + 1);
            }

            int maxCount = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                }
            }
            System.out.println("maxCount: " + maxCount);
            System.out.println("map: " + map);
            if (maxCount >= xi + 1) {
                count++;
            }
        }
        return count;
    }
}
