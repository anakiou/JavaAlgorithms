package com.anakiou.ja.patterns.command;

public class TVRemote {

    public static ElectronicDevice getDevice() {

        return new Television();

    }

}