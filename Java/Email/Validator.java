package Email;

import java.util.regex.Pattern;

public interface Validator {

    public static final Pattern VALID_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    public boolean checking(String nickName);

}
