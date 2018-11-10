package DataStructures.ArraysAndStrings.Exercises;

public class CheckPermutation {

    private boolean checkPermutation(String one, String two) {
        one = one.toLowerCase();
        two = two.toLowerCase();
        if (one == null || two == null || one.length() != two.length()) {
            return false;
        }

        if (one.contains(two)) {
            return true;
        }

        for (int i = 0; i < one.length(); i++) {
            String substring = one.substring(i, i + 1);
            if (two.contains(substring)) {
                int index = two.indexOf(substring);
                two = two.substring(0, index) + two.substring(index + 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String one = "qwerty";
        String two = "qywtey";
        CheckPermutation permutation = new CheckPermutation();
        System.out.println(permutation.checkPermutation(one, two));
    }
}
