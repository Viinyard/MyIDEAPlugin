package com.github.viinyard.myideaplugin.actions;

import com.intellij.execution.actions.ChooseDebugConfigurationPopupAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.xdebugger.XDebuggerManager;
import com.intellij.xdebugger.impl.DebuggerSupport;
import com.intellij.xdebugger.impl.XDebugSessionImpl;
import com.intellij.xdebugger.impl.actions.DebuggerActionHandler;
import com.intellij.xdebugger.impl.actions.XDebuggerActionBase;
import org.jetbrains.annotations.NotNull;

import java.awt.event.KeyEvent;

public class MyDummyAction extends XDebuggerActionBase implements DumbAware {
    @Override
    protected boolean isEnabled(AnActionEvent e) {
        Project project = e.getProject();
        if (project == null) return false;

        XDebugSessionImpl session = (XDebugSessionImpl)XDebuggerManager.getInstance(project).getCurrentSession();
        if (session != null && !session.isStopped()) {
            System.out.println("1 : " + (!session.isReadOnly() && session.isPaused()));
            return !session.isReadOnly() && session.isPaused();
        }
        // disable visual representation but leave the shortcut action enabled
        System.out.println("2 : " + (e.getInputEvent() instanceof KeyEvent));
        return e.getInputEvent() instanceof KeyEvent;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        if (!performWithHandler(e)) {
            Project project = getEventProject(e);
            if (project != null && !DumbService.isDumb(project)) {
                new ChooseDebugConfigurationPopupAction().actionPerformed(e);
            }
        }
    }

    @Override
    @NotNull
    protected DebuggerActionHandler getHandler(@NotNull final DebuggerSupport debuggerSupport) {
        return debuggerSupport.getResumeActionHandler();
    }
}
