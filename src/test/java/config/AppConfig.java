package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:local.properties")
public interface AppConfig extends Config {
    @Key("browser")
    @DefaultValue("CHROME")
    String browser();
    @Key("browser_size")
    @DefaultValue("1920x1080")
    String browser_size();
    @Key("browser_version")
    @DefaultValue("121")
    String browser_version();
    @Key("base_url")
    @DefaultValue("https://demoqa.com/")
    String base_url();
    @Key("is_hold_browser_open")
    @DefaultValue("false")
    Boolean is_hold_browser_open();
    @Key("timeout")
    @DefaultValue("5000")
    Integer timeout();
    @Key("page_load_timeout")
    @DefaultValue("10000")
    Integer pageLoadTimeout();
}
