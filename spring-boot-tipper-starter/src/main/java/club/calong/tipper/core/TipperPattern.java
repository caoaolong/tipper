package club.calong.tipper.core;

import java.util.regex.Pattern;

public class TipperPattern {

    public static final Pattern moduleNamePattern = Pattern.compile("^module\\s*=\\s*\"(\\w+)\"$");

    public static final Pattern actionNamePattern = Pattern.compile("^action\\s*=\\s*\"(\\w+)\"$");

    public static Pattern tipperNamePattern = Pattern.compile("^tipper\\s*\\(\\s*\"(/\\w+)+\"\\s*\\)\\s*=>");
}
