package js.id_validator;

import picocli.CommandLine;


public class Main implements Runnable{

    @CommandLine.Option(names = {"-id", "--id_number"}, required = true, description = "The user's ID number")
    String idNumber;

    public void run() {

        ID_Validator my_id_validator = new ID_Validator();
        my_id_validator.validate(idNumber);

    }

    public static void main(String... args) {
        CommandLine.run(new Main(), System.err, args);
    }


}
