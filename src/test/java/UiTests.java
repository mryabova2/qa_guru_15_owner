import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class UiTests {

    String props = System.setProperty("launch", "remote");
    WebConfig config = ConfigFactory.create(WebConfig.class, ConfigFactory.getProperties());

    @BeforeEach
    void configure () {
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        if ((config.getLaunchType()).equals("remote")) {
            Configuration.remote = config.getRemoteUrl();
        }
    }

    @Test
    @DisplayName("Check local launch")
    void localLaunchTest () {
        assertThat(config.getBrowserName()).isEqualTo("edge");
        assertThat(config.getBrowserVersion()).isEqualTo("101");
        assertThat(config.getBrowserSize()).isEqualTo("1366x768");

    }

    @Test
    @DisplayName("Check remote launch")
    void remoteLaunchTest () {
        assertThat(config.getBrowserName()).isEqualTo("chrome");
        assertThat(config.getBrowserVersion()).isEqualTo("100");
        assertThat(config.getBrowserSize()).isEqualTo("1920x1080");
        assertThat(config.getRemoteUrl()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub");
    }

    @Test
    @DisplayName("Check QAGuru page")
    void webTest () {
        open("https://qa.guru/");
        $(".main-head").shouldHave(text("Школа инженеров по автоматизации тестирования"));
    }
}
