package utils;

public class Config {

    private Config() {
    }

    private static String get(String key, String defaultValue) {
        String sys = System.getProperty(key);
        if (sys != null && !sys.isBlank())
            return sys;

        String env = System.getenv(key);
        if (env != null && !env.isBlank())
            return env;

        return defaultValue;
    }

    // Keep your BaseURL param too, but this gives a fallback
    public static String baseUrl() {
        return get("BASE_URL", "https://openlibrary.org/account/login");
    }

    public static String validEmail() {
        return get("OL_VALID_EMAIL", "");
    }

    public static String validPassword() {
        return get("OL_VALID_PASSWORD", "");
    }

    // Optional: if you want a known invalid email for negative tests
    public static String invalidEmail() {
        return get("OL_INVALID_EMAIL", "not-a-real-user-qa@example.com");
    }

    public static boolean hasValidCreds() {
        return !validEmail().isBlank() && !validPassword().isBlank();
    }
}
