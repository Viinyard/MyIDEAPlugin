package com.github.viinyard.myideaplugin.services

import com.github.viinyard.myideaplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
