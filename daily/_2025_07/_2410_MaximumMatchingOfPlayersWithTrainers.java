package daily._2025_07;

import java.util.Arrays;

public class _2410_MaximumMatchingOfPlayersWithTrainers {
    public static void main(String[] args) {

    }

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int m = players.length;
        int n = trainers.length;
        int count = 0;

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count;
    }
}
