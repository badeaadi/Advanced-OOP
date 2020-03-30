public class OutTask implements Task {

    private String mesaj;
    OutTask(String newMesaj) {
        mesaj = newMesaj;
        execute();
    }
    @Override
    public void execute() {
        System.out.println(mesaj);
    }
}
