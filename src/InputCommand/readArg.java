package InputCommand;

import constants.errors;

public class readArg implements ArgStrategy{
    @Override
    public boolean matchArg(String arg) {
        return arg.equals("read");
    }

    @Override
    public void execCmd(String arg) {
        String[] cmdArgs = arg.split(" ");
//        if (CurrentDb != null) {
//            if (cmdArgs.length == 1) {
//                CurrentDb.readData();
//            } else {
//                CurrentDb.readData(cmdArgs[1]);
//            }
//        } else {
//            System.out.println(errors.NO_DATABASE_SELECTED);
//        }
    }
}
