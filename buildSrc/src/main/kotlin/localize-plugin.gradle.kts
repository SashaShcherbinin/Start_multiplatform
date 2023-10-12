import task.localisation.LocalisationTask
import task.localisation.TASK_GROUP
import task.localisation.UpdateJsonTask

plugins {
    id("com.android.library")
}

tasks.register<LocalisationTask>("translateString") {
    group = TASK_GROUP
    resourcePrefix = android.resourcePrefix ?: ""
}

tasks.register<UpdateJsonTask>("updateJson") {
    group = TASK_GROUP
    resourcePrefix = android.resourcePrefix ?: ""
}