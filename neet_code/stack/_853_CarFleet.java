package neet_code.stack;

import java.util.Arrays;

public class _853_CarFleet {
    public static void main(String[] args) {
        System.out.println(carFleet(12, new int[]{10, 8, 0, 5, 10, 3}, new int[]{2, 4, 1, 1, 1, 3}));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        int[][] cars = new int[length][2];
        int fleetCount = 0;
        float currentTimeToDestination = -1;

        for (int i = 0; i < length; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        for (int[] car : cars) {
            float timeToDestination = (float) (target - car[0]) / car[1];
            if (timeToDestination > currentTimeToDestination) {
                currentTimeToDestination = timeToDestination;
                fleetCount++;
            }
        }

        return fleetCount;
    }

    // faster if positions are dense, if they're sparse then slower than sorting algo above
    public static int carFleet_(int target, int[] position, int[] speed) {
        float[] rounds = new float[target];
        for (int i = 0; i < position.length; i++) {
            rounds[position[i]] = ((float)(target - position[i]) / speed[i]);
        }

        int fleets = 0;
        float run = 0.0f;
        for (int i = rounds.length - 1; i > -1; i--) {
            if (rounds[i] > run) {
                run = rounds[i];
                fleets++;
            }
        }

        return fleets;
    }
}
