package HRMS.HRMS.Project.core.utilities.results;

public class Result {
    //super type class
    private boolean success;
    private String message;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String message) {
        this(success);
        //Tek parametreli yapıcı bloğu çağırdık.
        this.message = message;
    }
    public boolean isSuccess(){
        return this.success;
    }
    public String getMessage(){
        return this.message;
    }
}
