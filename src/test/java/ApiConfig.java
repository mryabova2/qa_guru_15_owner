import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/secret.properties",
        "classpath:properties/api.properties"
})

public interface ApiConfig extends Config {

    @Key("token")
    String getToken();
}
