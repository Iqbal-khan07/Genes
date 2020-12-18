package controllers;

import controllers.viewport.IViewPort;

public class ProcessGeneSequenceErrorOutput implements IViewPort {
    private String message;

    public String getMessage() {
        return message;
    }

    public ProcessGeneSequenceErrorOutput(String message){
        this.message = message;
    }
}
