package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;


public class UnitTest {
    @Test
    public void testChoose() {
        String input = "3";
        InputStream Input = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals(Input,Input);
    }

    @Test
    public void testPayment(){
        int totalPrice = 100;
        final PrintStream originalOut = System.out;
        OutputStream outputStream = System.out;
        System.setOut(new PrintStream(outputStream));
        System.setOut(originalOut);
    }
}
