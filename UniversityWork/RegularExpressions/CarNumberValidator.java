package RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNumberValidator {

        private Pattern pattern;
        private Matcher matcher;

        private static final String NUMBER_PATTERN = "[A-Z]{2}[1-9]{4}[A-Z]{2}";

        public CarNumberValidator(){

            pattern = Pattern.compile(NUMBER_PATTERN);

        }

        public boolean validateCarNumber(final String carNumber){

            matcher = pattern.matcher(carNumber);

            return matcher.matches();

        }

}
