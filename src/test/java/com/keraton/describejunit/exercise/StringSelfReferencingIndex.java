package com.keraton.describejunit.exercise;

public class StringSelfReferencingIndex {

    public int[] index(String input) {
        if (null == input || input.isEmpty()) {
            return new int[0];
        }

        int[] output = initOutputAndFirstValut(input);

        for (int i=2; i<input.length(); i++) {
            calculateIndex(input, output, i);
        }
        return output;
    }

    int[] initOutputAndFirstValut(String input) {
        int[] output = new int[input.length()];
        output[0] = -1;
        return output;
    }

    void calculateIndex(String input, int[] output, int index) {
        if (output.length > index) {
            if (input.charAt(index -1) == input.charAt(output[index -1])) {
                output[index] = output[index -1]+1;
            }
        }
    }
}
