interface Task {

    void execute();

    public static void main(String[] args) {

        OutTask outTask = new OutTask("Hello World!");

        RandomOutTask randomOutTask = new RandomOutTask();

        for (int i = 1; i <= 3; i++) {
            CounterOutTask counterOutTask = new CounterOutTask();
        }
    }
}
