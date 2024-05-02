package info.fa;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    public int add(String ... input) {
        List<Integer> negativeNumbers = new ArrayList<>();
        if (input.length == 1) {
            if (StringUtils.isBlank(input[0])) {
                return 0;
            }
        }

        List<String> arraysOfNumbers = Arrays.stream(input)
                .map(arrayOfStrings -> {
                    List<String> delimiters = Arrays.asList(",");
                    if (arrayOfStrings.startsWith("//")) {
                        int newLineIndex = arrayOfStrings.indexOf("\n");
                        String delimitersString = arrayOfStrings.substring(2, newLineIndex);
                        arrayOfStrings = arrayOfStrings.substring(newLineIndex);
                        delimiters = this.getDelimiters(delimitersString);
                    }
                    String delimiterRegexp = getDelimiterRegexp(delimiters);
                    return Arrays.asList(arrayOfStrings.replaceAll("\\s", "").split(delimiterRegexp));
                })
                .flatMap(Collection::stream).collect(Collectors.toList());
        int sum = arraysOfNumbers.stream().mapToInt(Integer::parseInt).filter(value -> {return value < 1001;}).sum();
        arraysOfNumbers.forEach(value -> {
            int anInt = Integer.parseInt(value);
            if ( anInt < 0 ) {
                negativeNumbers.add(anInt);
            }
        });
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negatives not allowed: " + negativeNumbers);
        }
        return sum;
    }

    String getDelimiterRegexp(List<String> delimiters) {
        if (delimiters.size() == 1) {
            return delimiters.get(0);
        }
        return StringUtils.join(delimiters.stream().map(del -> "("+del + ")").collect(Collectors.toList()), "|");
    }

    List<String> getDelimiters(String delimitersString) {
        List<String> list = Arrays.asList(delimitersString);
        if (delimitersString.startsWith("[") && delimitersString.endsWith("]")) {
            delimitersString = delimitersString.substring(1, delimitersString.length()-1);
            list = Arrays.asList(delimitersString.split("]\\["));
        }
        return list;
    }
}
