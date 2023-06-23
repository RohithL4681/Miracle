package com.example.demo.logger;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class Loggerservice {

private static final Logger log = LoggerFactory.getLogger(Loggerservice.class);

public int logs() {
	log.trace("processing logs");
log.warn("processing logs");
log.info("processing logs");
log.debug("processing logs");

return 0;
}

}