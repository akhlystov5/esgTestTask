package info.fa;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collection;

public class StringCalculator {

    public int add(String ... numbersAsString) {
        if (numbersAsString.length == 1) {
            if (StringUtils.isBlank(numbersAsString[0])) {
                return 0;
            }
        }
        int sum = Arrays.stream(numbersAsString)
                .map(numberAsString -> Arrays.asList(numberAsString.replaceAll("\\s","").split(",")))
                .flatMap(Collection::stream).mapToInt(Integer::parseInt).sum();

        return sum;
    }
}
