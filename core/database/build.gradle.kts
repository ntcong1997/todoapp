plugins {
    id("todoapp.android.library")
    id("todoapp.android.hilt")
    id("todoapp.android.room")
}

android {
    defaultConfig {
        testInstrumentationRunner =
            "com.joblogic.todoapp.core.testing.ToDoAppTestRunner"
    }
    namespace = "com.joblogic.todoapp.core.database"
}
