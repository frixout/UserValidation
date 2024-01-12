public class BannedUser extends Exception{
    BannedUser(){
        super();
    }
    BannedUser(String message){
        super(message);
    }
}
