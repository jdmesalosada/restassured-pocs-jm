package conf;

public enum Endpoints {

    REGISTER("register"),
    USERS("users/{userId}");

    private final String path;

    Endpoints(String path){
        this.path = path;
    }

    public String path(){
        return path;
    }

}
