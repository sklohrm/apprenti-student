package learn.unexplained.ui;

public enum MenuOption {
    EXIT("Exit"),
    DISPLAY_ALL("Display All Encounters"),
    ADD("Add An Encounter"),
    DISPLAY_BY_TYPE("Display Encounters by Type"),
    UPDATE("Update Encounter"),
    DELETE("Delete Encounter")
    ;

    private String message;

    MenuOption(String name) {
        this.message = name;
    }

    public String getMessage() {
        return message;
    }
}
