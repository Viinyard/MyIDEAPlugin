package com.github.viinyard.myideaplugin.services;

import com.intellij.xdebugger.impl.DebuggerSupport;
import com.intellij.xdebugger.impl.breakpoints.ui.BreakpointPanelProvider;
import org.jetbrains.annotations.NotNull;

public class MyDummyService extends DebuggerSupport {
    @Override
    public @NotNull BreakpointPanelProvider<?> getBreakpointPanelProvider() {
        return null;
    }
}
