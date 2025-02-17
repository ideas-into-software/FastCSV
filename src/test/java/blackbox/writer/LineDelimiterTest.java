package blackbox.writer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.siegmar.fastcsv.writer.LineDelimiter;

class LineDelimiterTest {

    @Test
    void test() {
        assertEquals("\n", LineDelimiter.LF.toString());
        assertEquals("\r", LineDelimiter.CR.toString());
        assertEquals("\r\n", LineDelimiter.CRLF.toString());
        assertEquals(System.lineSeparator(), LineDelimiter.PLATFORM.toString());
    }

    @Test
    void testOf() {
        assertEquals(LineDelimiter.CRLF, LineDelimiter.of("\r\n"));
        assertEquals(LineDelimiter.LF, LineDelimiter.of("\n"));
        assertEquals(LineDelimiter.CR, LineDelimiter.of("\r"));

        final IllegalArgumentException e =
            assertThrows(IllegalArgumentException.class, () -> LineDelimiter.of(";"));
        assertEquals("Unknown line delimiter: ;", e.getMessage());
    }

}
