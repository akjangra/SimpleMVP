package com.ashok.simplemvp.others;

/**
 * Created by Ashok on 20/04/17.
 */

public interface IPresentation {

    void updateText(String text);

    void updateImage(String url);

    void errorDisplay(String msg);
}
