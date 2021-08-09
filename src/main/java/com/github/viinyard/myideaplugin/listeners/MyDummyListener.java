package com.github.viinyard.myideaplugin.listeners;

import com.intellij.xdebugger.XDebugProcess;
import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.XDebuggerManagerListener;
import com.intellij.xdebugger.impl.DebuggerSupport;
import com.intellij.xdebugger.impl.XDebuggerSupport;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MyDummyListener implements XDebuggerManagerListener {
    @Override
    public void processStarted(@NotNull XDebugProcess debugProcess) {
        XDebuggerManagerListener.super.processStarted(debugProcess);
        System.out.println("processStarted : " + debugProcess);
    }

    @Override
    public void processStopped(@NotNull XDebugProcess debugProcess) {
        XDebuggerManagerListener.super.processStopped(debugProcess);
        System.out.println("processStopped : " + debugProcess);
    }

    @Override
    public void currentSessionChanged(@Nullable XDebugSession previousSession, @Nullable XDebugSession currentSession) {
        XDebuggerManagerListener.super.currentSessionChanged(previousSession, currentSession);
        System.out.println("currentSessionChanged : " + previousSession + ", " + currentSession);
        if(currentSession != null) {
            currentSession.addSessionListener(new MyDebugSessionListener());
           for(DebuggerSupport debuggerSupport : DebuggerSupport.getDebuggerSupports()) {
               System.out.println(debuggerSupport);
           }
            //debuggerSupport.getResumeActionHandler().isHidden(currentSession.getProject(), null);
        }
    }
}
