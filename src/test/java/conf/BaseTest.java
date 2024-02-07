package conf;

import conf.ConfVariables;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.locks.ReentrantLock;

public abstract class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    private static ReentrantLock lock = new ReentrantLock();
    private static boolean started = false;

    @BeforeAll
    public static void setup() throws FileNotFoundException {
        lock.lock();

        try {
            if (!started) {
                logger.info("Iniciando la configuracion");
                RestAssured.requestSpecification = defaultRequestSpecification();
                logger.info("Configuration exitosa.");
            }
        } finally {
            lock.unlock();
        }
    }

    private static RequestSpecification defaultRequestSpecification() throws FileNotFoundException {

        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());
        filters.add(new AllureRestAssured());

        return new RequestSpecBuilder().setBaseUri(ConfVariables.getHost())
                .setBasePath(ConfVariables.getBasePath())
                .addFilters(filters)
                .setContentType(ContentType.JSON).build();
    }

    private RequestSpecification prodRequestSpecification() {
        return new RequestSpecBuilder().setBaseUri("https://prod.reqres.in")
                .setBasePath("/api")
                .setContentType(ContentType.JSON).build();
    }

    public ResponseSpecification defaultResponseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .expectContentType(ContentType.JSON)
                .build();
    }


}
