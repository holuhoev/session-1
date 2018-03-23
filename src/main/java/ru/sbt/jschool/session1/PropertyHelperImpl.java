package ru.sbt.jschool.session1;



import java.io.FileInputStream;
import java.util.Properties;

public class PropertyHelperImpl  implements  PropertyHelper{

    private String      path;
    private String[]    args;

    private String      val;




    public static void main(String[] args){
        String path = "config/mimiFile.ini";
        String nameVarEnv = "XDG_SESSION_DESKTOP";
        String nameVarSys = "java.vm.info";
        String nameVarPath = "wow.mimi";

        PropertyHelperImpl propArgs = new PropertyHelperImpl(args, path);
        PropertyHelperImpl propSys  = new PropertyHelperImpl(args, path);
        PropertyHelperImpl propEnv  = new PropertyHelperImpl(args, path);
        PropertyHelperImpl propPath = new PropertyHelperImpl(args, path);

        System.out.println(propArgs.doubleValue("mim"));
        System.out.println(propSys.stringValue(nameVarEnv));
        System.out.println(propEnv.stringValue(nameVarSys));
        System.out.println(propPath.stringValue(nameVarPath));

    }

    public PropertyHelperImpl(String[] args, String path) {

        this.args = args;
        if (!path.equals("")) {
            this.path = path;
        }

    }


    public String stringValue(String name){

        this.val = varArgs(name);
        if (this.val!=null){
            return val;
        }

        this.val = varEnv(name);
        if (this.val!=null){
            return val;
        }

        this.val = varSysProp(name);
        if (this.val!=null){
            return val;
        }
        this.val = VarPropFile(name);
        if (this.val!=null){
            return val;
        }
        return null;
    }



    public  Integer integerValue(String name){
        return Integer.parseInt(stringValue(name));
    }

    public Double doubleValue(String name){

        return Double.parseDouble(stringValue(name));

    }


    private String varArgs(String name) {
        for (String arg : args) {
            if (arg.startsWith(name + "="))
                return arg.replace(name + "=", "");
        }

        return null;
    }

    private String varSysProp(String name) {
        return System.getProperty(name);
    }

    private String varEnv(String name) {
        return System.getenv(name);
    }

    private String VarPropFile(String name) {

        if (path == null || path.equals("")) {
            System.out.println("rtthtrsh");
            return null;
        }

        try {

            Properties props = new Properties();
            props.load(new FileInputStream(path));
           // props.list(System.out);
            return props.getProperty(name);

        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }



}