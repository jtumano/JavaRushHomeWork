package com.javarush.test.level24.lesson02.home01;

/**
 * Created by jan on 5.12.15.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker
{
    public SelfInterfaceMarkerImpl()
    {
    }

    public boolean isTrue() {
       return false;
    }

    public String name() {
        return "method";
    }
}
