package js.id_validator;

import picocli.CommandLine;

public class Main implements Runnable {

    @CommandLine.Parameters(index = "0")
    private String ID;

    public static void main(String[] args) {
        CommandLine.run(new Main(), args);
    }

    public void run() {
        Validator idValidator = new ID_Validator();
        idValidator.validate(ID);
    }
}
