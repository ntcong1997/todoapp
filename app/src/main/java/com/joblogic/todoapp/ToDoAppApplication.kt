package com.joblogic.todoapp

import android.app.Application
import com.joblogic.todoapp.sync.work.initializers.Sync
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by TC on 04/03/2023.
 */

@HiltAndroidApp
class ToDoAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Sync.initialize(this)
    }
}