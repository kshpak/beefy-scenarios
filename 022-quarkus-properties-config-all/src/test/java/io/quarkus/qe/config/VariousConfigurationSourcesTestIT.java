package io.quarkus.qe.config;

import org.junit.jupiter.api.Disabled;

import io.quarkus.test.junit.NativeImageTest;

@Disabled("TODO: Can't add configsource.properties because of https://github.com/quarkusio/quarkus/issues/17653")
@NativeImageTest
public class VariousConfigurationSourcesTestIT extends VariousConfigurationSourcesTest {

    // Execute the same tests but in native mode.
}