import java.time.LocalDateTime;

public class Logger {

    private LogState state = LogState.IDLE;

    public LogState getState() {
        return state;
    }

    public void setState(LogState newState) {
        this.state = newState;
    }

    public void log(String msg) {
        switch(state) {
            case IDLE:
                System.out.println("[IDLE]\t" + msg);
                break;
            case START:
                System.out.println("[START]\t" + msg + " at " + LocalDateTime.now());
                break;
            case PROCESSING_ORDER:
                System.out.println("[ORDER]\t" + msg);
                break;
            case PROCESSING_ITEM:
                System.out.println("[ITEM]\t" + msg);
                break;
            case END:
                System.out.println("[END]\t" + msg + " at " + LocalDateTime.now());
                break;
        }
    }

}
