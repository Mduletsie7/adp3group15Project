package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Painter;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class PainterFactoryTest {
    Painter painter = new Painter();
        // i. Object Equality Test
        @Test
        public void test_PainterEquality() {
            Painter painter1 = PainterFactory.createPainter("","","","");
            String painterId = painter.getPainterId().toString();
            assertEquals(painter1.getPainterId(), painterId);
        }

        // ii. Object Identity Test
        @Test
        public void test_ObjectIdentity() {
            Painter painter1 = PainterFactory.createPainter("","","","");
            Painter painter2 = painter1;
            Painter painter3 = PainterFactory.createPainter("","","","");

            assertSame(painter1, painter3);
        }

        // iii. Product build Failing TEST
        @Test
        public void test_fail() {
            Painter painter1 = PainterFactory.createPainter("","","","");
            assertNotNull(painter1);
            System.out.println(painter1.toString());
        }

        // iv. Timeout Test
        @Test
        void test_TimeOut() {
            assertTimeout(Duration.ofMillis(100), () -> {
                Thread.sleep(2000);

                System.out.println("Execution exceeded timeout duration!");
            });
        }

        // v. Disabling Test
        @Disabled("TODO: Still need to code this method")
        @Test
        public void test_productInTransit() {
        }
    }