import org.junit.Test;

public class TestMAINTransport {

    public static void main(String[] args) {
        testMainTransport();
    }

    public static void testMainTransport() {

        String[] args = {
                "LNHTM1",
                "LXMTA0"
        };

        MainTransport.main(args);
    }
}