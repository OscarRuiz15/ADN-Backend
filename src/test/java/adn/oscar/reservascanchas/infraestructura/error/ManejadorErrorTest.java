package adn.oscar.reservascanchas.infraestructura.error;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class ManejadorErrorTest {

    private static final HttpStatus STATUS_CODE_OK_VALUE = HttpStatus.OK;
    private static final int STATUS_CODE_OK = 200;
    private static final HttpStatus STATUS_CODE_BAD_REQUEST_VALUE = HttpStatus.BAD_REQUEST;
    private static final int STATUS_CODE_REQUEST_VALUE = 400;

    @Test
    public void httpResponseOk() {
        // arrage
        ResponseEntity<Error> responseEntity;

        // act
        responseEntity = new ResponseEntity<>(HttpStatus.OK);

        // assert
        assertEquals(STATUS_CODE_OK_VALUE, responseEntity.getStatusCode());
        assertEquals(STATUS_CODE_OK, responseEntity.getStatusCodeValue());
    }

    @Test
    public void httpResponseBadRequest() {
        // arrage
        ResponseEntity<Error> responseEntity;

        // act
        responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        // assert
        assertEquals(STATUS_CODE_BAD_REQUEST_VALUE, responseEntity.getStatusCode());
        assertEquals(STATUS_CODE_REQUEST_VALUE, responseEntity.getStatusCodeValue());
    }
}