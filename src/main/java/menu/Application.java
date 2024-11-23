package menu;

import menu.controller.SystemController;

public class Application {
    public static void main(String[] args) {
        SystemController systemController = new SystemController();
        systemController.start();
    }
}
