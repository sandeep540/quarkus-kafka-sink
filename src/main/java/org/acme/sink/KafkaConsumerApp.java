package org.acme.sink;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;


@QuarkusMain
public class KafkaConsumerApp {

    public static void main(String... args) {
        Quarkus.run(args);
    }
}
