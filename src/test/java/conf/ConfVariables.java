package conf;

import java.util.Optional;

public class ConfVariables {

    public static String getHost() {
        return Optional.ofNullable(System.getenv("host"))
                .orElse((String) ApplicationProperties.getInstance().get("host"));
    }

    public static String getBasePath() {
        return Optional.ofNullable(System.getenv("basePath"))
                .orElse((String) ApplicationProperties.getInstance()
                        .get("basePath"));
    }
}
