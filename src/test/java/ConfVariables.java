import java.util.Optional;

public class ConfVariables {

    public static String getHost() {
        return Optional.ofNullable(System.getenv("host"))
                .orElse((String) ApplicationProperties.getInstance().get("host"));
    }

    public static String getPath() {
        return Optional.ofNullable(System.getenv("path"))
                .orElse((String) ApplicationProperties.getInstance()
                        .get("path"));
    }
}
