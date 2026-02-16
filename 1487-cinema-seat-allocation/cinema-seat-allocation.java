class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> seats = new HashMap();

        for (int[] booking : reservedSeats) {
            seats.putIfAbsent(booking[0], new ArrayList<>());
            seats.get(booking[0]).add(booking[1]);
        }

        int result = 2 * (n - seats.size());

        for (Map.Entry<Integer, List<Integer>> entry : seats.entrySet()) {
            List<Integer> bookings = entry.getValue();

            boolean isRightAisle = false, isLefttAisle = false, isMiddleAisle = false;

            for (int book : bookings) {
                if (book >= 2 && book <= 5)
                    isLefttAisle = true;
                if (book >= 6 && book <= 9)
                    isRightAisle = true;
                if (book >= 4 && book <= 7)
                    isMiddleAisle = true;

            }

            if (!isLefttAisle)
                result++;

            if (!isRightAisle)
                result++;

            if (isRightAisle && isLefttAisle && !isMiddleAisle)
                result++;

        }

        return result;
    }
}