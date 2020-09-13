package com.example.demo.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.*;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author robert
 */
@Slf4j
@SpringBootTest
class TimeUtilsTest {

    @Test
    void testTime() {
        LocalDate now = LocalDate.of(2020, 1, 23);
        TemporalField fieldISO = WeekFields.of(Locale.FRANCE).dayOfWeek();
        System.out.println(now.with(fieldISO,1)); // 2020-01-20（星期一）

        TemporalField fieldUS = WeekFields.of(Locale.US).dayOfWeek();
        System.out.println(now.with(fieldUS,1)); // 2020-01-19（星期日）

        /* 不知道为什么中国的也是星期日 */
        TemporalField fieldZH = WeekFields.of(Locale.CHINESE).dayOfWeek();
        System.out.println(now.with(fieldZH,1)); // 2020-01-19（星期日）

        System.out.println(DateTime.now().withDayOfWeek(1).withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0));
        System.out.println(DateTime.now().dayOfWeek().withMinimumValue().toString("yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    void testLocalDate2Timestamp() {
        /* LocalDate转时间戳 */
        LocalDate localDate = LocalDate.now();
        long timestamp1 = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        /* LocalDateTime转时间戳 */
        LocalDateTime localDateTime = LocalDateTime.now();
        long timestamp2 = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

    @Test
    void testTimestamp2LocalDate() {
        /* 时间戳转LocalDateTime(LocalDate) */
        long timestamp = System.currentTimeMillis();
        LocalDate localDate = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDateTime localDateTime = Instant.ofEpochMilli(timestamp).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Test
    public void testConvertToJsonCase3() throws JsonParseException, IOException {
        JsonParser jp = new JsonFactory().createParser("{ \"foo\": \"bar\" }");
        String result = convertToJson(jp);
        assertNull(result);
    }

    @Test
    public void testConvertToJsonCase4() {
        Object mockItem = mock(Object.class);
        when(mockItem.toString()).thenReturn(mockItem.getClass().getName());
        String result = convertToJson(mockItem);
        assertNull(result);
    }

    public static String convertToJson(Object response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(response);
        } catch (JsonGenerationException e) {
            log.error("convertToJson JsonGenerationException Occured" + e);
        } catch (JsonMappingException e) {
            log.error("convertToJson JsonMappingException Occured" + e);
        } catch (IOException e) {
            log.error("convertToJson IOException Occured" + e );
        } catch (Exception e) {
            log.error("convertToJson Exception Occured" + e );
        }
        return null;
    }
}