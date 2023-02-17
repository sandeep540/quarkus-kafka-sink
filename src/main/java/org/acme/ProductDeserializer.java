package org.acme;

import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ProductDeserializer implements Deserializer<Product> {
    private final Logger logger = LoggerFactory.getLogger(ProductDeserializer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public Product deserialize(String s, byte[] data) {
        try {
            if (data == null){
                logger.error("Null received at deserializing");
                return null;
            }
            //logger.info("Deserializing Product ...");
            return objectMapper.readValue(new String(data, StandardCharsets.UTF_8), Product.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to Product");
        }
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
