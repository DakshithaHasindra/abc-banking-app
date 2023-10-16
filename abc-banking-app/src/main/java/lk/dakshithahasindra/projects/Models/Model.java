package lk.dakshithahasindra.projects.Models;

import lk.dakshithahasindra.projects.Views.ViewFactory;

public class Model {
    private final ViewFactory viewFactory;
    private static  Model instance;


    private  Model(){
        this.viewFactory = new ViewFactory();
    }

    public static synchronized Model getInstance(){
        return (instance==null)?instance=new Model():instance;
    }

    public ViewFactory getViewFactory() {
    return viewFactory;
    }
}
