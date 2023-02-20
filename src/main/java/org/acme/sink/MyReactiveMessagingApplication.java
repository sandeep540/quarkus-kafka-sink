package org.acme.sink;

import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class MyReactiveMessagingApplication {

    private final Logger logger = LoggerFactory.getLogger(MyReactiveMessagingApplication.class);

    @Incoming("product")
    @RunOnVirtualThread
    public void sink(Record<String, Product> record) {
        logger.info("Message ------- >> " + record.value().toString());
    }
}
