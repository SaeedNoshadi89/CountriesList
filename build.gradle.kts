
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies{
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.44.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    }

}
plugins {
    id ("com.android.application").version("7.4.0").apply(false)
    id ("com.android.library").version("7.4.0").apply(false)
    id ("org.jetbrains.kotlin.android").version("1.7.21").apply(false)
    id ("com.google.dagger.hilt.android").version("2.44.2").apply(false)
}
