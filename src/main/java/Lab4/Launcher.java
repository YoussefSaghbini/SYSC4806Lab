package Lab4;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public void launch() {
        String[] contextPaths = new String[] {"context.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }

    public static void main(String[] args) {
        new Launcher().launch();
    }
}
