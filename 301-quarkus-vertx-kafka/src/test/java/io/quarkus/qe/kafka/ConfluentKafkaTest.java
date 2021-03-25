package io.quarkus.qe.kafka;

import io.quarkus.qe.kafka.resources.ConfluentTestProfile;
import io.quarkus.test.junit.DisabledOnNativeImage;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.concurrent.CompletionStage;

@QuarkusTest
@DisabledOnNativeImage // Non an HTTP req. Doc: https://quarkus.io/guides/building-native-image#excluding-tests-when-running-as-a-native-executable
@TestProfile(ConfluentTestProfile.class)
public class ConfluentKafkaTest extends StockPriceProcessedTest{

    @Incoming("test-confluent-sink-stock-price")
    public CompletionStage consume(Message<StockPrice> stockPrice) {
        received.add(stockPrice.getPayload());
        return stockPrice.ack();
    }
}