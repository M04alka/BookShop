package ua.od.BookSeller;
import org.eclipse.jetty.server.Server;
import ua.od.BookSeller.configs.AppConfig;

public class AppStarter {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new AppConfig().getHandlersConfig());
        server.start();
        server.join();
    }
}
