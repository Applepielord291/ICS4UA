import java.text.DecimalFormat;

public class App {
    public static void main(String[] args) throws Exception {
        DecimalFormat df = new DecimalFormat("#.#####");
        String latitude = df.format(Math.random() * 90);
        String longitude = df.format(Math.random() * 90);
    }
}
