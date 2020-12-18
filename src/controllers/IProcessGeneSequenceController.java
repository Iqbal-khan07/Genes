package controllers;

import controllers.viewport.IViewPort;

public interface IProcessGeneSequenceController {
    IViewPort execute(ProcessGeneSequenceInput input);
}
