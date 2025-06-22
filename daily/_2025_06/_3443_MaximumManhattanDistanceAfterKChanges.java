package daily._2025_06;

public class _3443_MaximumManhattanDistanceAfterKChanges {
    public static void main(String[] args) {
    }

    public static int maxDistanceEnhanced(String s, int k) {
        int verticalDist = 0, horizontalDist = 0;
        int result = 0;
        char[] moves = s.toCharArray();

        for (int i = 0; i < moves.length; i++) {
            switch (moves[i]) {
                case 'N':
                    verticalDist++;
                    break;
                case 'S':
                    verticalDist--;
                    break;
                case 'E':
                    horizontalDist++;
                    break;
                case 'W':
                    horizontalDist--;
                    break;
            }
            result = Math.max(result, Math.min(
                    Math.abs(verticalDist) + Math.abs(horizontalDist) + 2 * k,
                    i + 1
            ));
        }

        return result;
    }

    public static int maxDistance(String s, int k) {
        int north = 0, south = 0, east = 0, west = 0;
        int result = 0;

        for (char move : s.toCharArray()) {
            switch (move) {
                case 'N':
                    north++;
                    break;
                case 'S':
                    south++;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    west++;
                    break;
            }
            int verticalChangeCount = Math.min(Math.min(north, south), k);
            int horizontalChangeCount = Math.min(Math.min(east, west), k - verticalChangeCount);

            result = Math.max(result, Math.abs(north - south) + Math.abs(east - west) + 2 * (verticalChangeCount + horizontalChangeCount));
        }
        return result;
    }
}