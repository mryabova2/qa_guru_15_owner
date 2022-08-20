import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UiTests {


    @Test
    @DisplayName("Check local launch")
    void localLaunchTest () {

        System.setProperty("launch", "local");
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        assertThat(config.getBrowserName()).isEqualTo("edge");
        assertThat(config.getBrowserVersion()).isEqualTo("101");
        assertThat(config.getBrowserSize()).isEqualTo("1366x768");

    }

    @Test
    @DisplayName("Check remote launch")
    void remoteLaunchTest () {

        System.setProperty("launch", "remote");
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());

        assertThat(config.getBrowserName()).isEqualTo("chrome");
        assertThat(config.getBrowserVersion()).isEqualTo("100");
        assertThat(config.getBrowserSize()).isEqualTo("1920x1080");
        assertThat(config.getRemoteUrl()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub");
    }


}
