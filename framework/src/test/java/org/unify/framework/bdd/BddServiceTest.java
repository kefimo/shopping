package org.unify.framework.bdd;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.*;

import static io.cucumber.core.options.Constants.*;
import static org.junit.jupiter.api.Assertions.assertNull;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters({
        @ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:target/cucumber/cucumber.json"),
        @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.unify.framework.bdd"),
        @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @Disabled"),
        @ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
})
public class BddServiceTest {
    @Test
    void scontextLoads()
    {
        assertNull(null);
    }
}
