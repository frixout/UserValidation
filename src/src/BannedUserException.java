public class BannedUserException extends Exception{
    BannedUserException(){
        super();
    }
    BannedUserException(String message){
        super(message);
    }
}
