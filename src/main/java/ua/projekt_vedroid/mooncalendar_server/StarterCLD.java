package ua.projekt_vedroid.mooncalendar_server;

class StarterCLD {

    private static CurrentLunarDay ldg = null;

    static void start() {
        if (ldg != null) {
            if (!ldg.isAlive()) {
                System.out.println("StarterCLD ::: Thread restarted.");
                ldg = new CurrentLunarDay();
                ldg.setDaemon(true);
                ldg.start();
            }
        } else {
            System.out.println("StarterCLD ::: Thread started.");
            ldg = new CurrentLunarDay();
            ldg.setDaemon(true);
            ldg.start();
        }
    }
}
