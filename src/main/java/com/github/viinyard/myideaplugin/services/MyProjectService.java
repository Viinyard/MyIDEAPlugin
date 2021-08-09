package com.github.viinyard.myideaplugin.services;

import com.github.viinyard.myideaplugin.MyBundle;
import com.github.viinyard.myideaplugin.listeners.MyDummyListener;
import com.intellij.openapi.project.Project;
import com.intellij.util.messages.MessageBusConnection;
import com.intellij.xdebugger.XDebuggerManager;
import com.intellij.xdebugger.XDebuggerManagerListener;
import com.intellij.xdebugger.impl.XDebugSessionImpl;
import org.jetbrains.annotations.NotNull;

public class MyProjectService {

    public MyProjectService(Project project) {
        System.out.println(MyBundle.message("projectService", project));

        MessageBusConnection myConnection = project.getMessageBus().connect();
        myConnection.subscribe(XDebuggerManager.TOPIC, new MyDummyListener());

        XDebugSessionImpl session = (XDebugSessionImpl) XDebuggerManager.getInstance(project).getCurrentSession();
        if (session != null && !session.isStopped()) {
            System.out.println("1 : " + (!session.isReadOnly() && session.isPaused()));
        }
    }
}
