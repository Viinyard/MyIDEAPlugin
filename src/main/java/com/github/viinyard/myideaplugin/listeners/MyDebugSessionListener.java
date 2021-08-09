package com.github.viinyard.myideaplugin.listeners;

import com.intellij.xdebugger.XDebugSessionListener;

public class MyDebugSessionListener implements XDebugSessionListener {
    @Override
    public void sessionPaused() {
        XDebugSessionListener.super.sessionPaused();
        System.out.println("sessionPaused");
    }

    @Override
    public void sessionResumed() {
        XDebugSessionListener.super.sessionResumed();
        System.out.println("sessionResumed");
    }

    @Override
    public void sessionStopped() {
        XDebugSessionListener.super.sessionStopped();
        System.out.println("sessionStopped");
    }

    @Override
    public void stackFrameChanged() {
        XDebugSessionListener.super.stackFrameChanged();
        System.out.println("stackFrameChanged");
    }

    @Override
    public void beforeSessionResume() {
        XDebugSessionListener.super.beforeSessionResume();
        System.out.println("beforeSessionResume");
    }

    @Override
    public void settingsChanged() {
        XDebugSessionListener.super.settingsChanged();
        System.out.println("settingsChanged");
    }
}
