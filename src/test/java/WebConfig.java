import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${launch}.properties"
//         -Dlaunch=local
//        -Dlaunch=remote
})

public interface WebConfig extends Config{

    @Key("launch")
    String getLaunchType();

    @Key("browserName")
    String getBrowserName();

    @Key("browserSize")
    String getBrowserSize();

    @Key("browserVersion")
    @DefaultValue("101")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();

}
