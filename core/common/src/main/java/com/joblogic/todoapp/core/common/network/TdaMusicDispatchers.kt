package com.joblogic.todoapp.core.common.network

import javax.inject.Qualifier
import kotlin.annotation.AnnotationRetention.RUNTIME

@Qualifier
@Retention(RUNTIME)
annotation class Dispatcher(val toDoAppDispatchers: ToDoAppDispatchers)

enum class ToDoAppDispatchers {
    IO
}

@Qualifier
@Retention(RUNTIME)
annotation class ApplicationScope
