plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
}

android {
  namespace = "me.saket.squiggles.sample"

  defaultConfig {
    applicationId = namespace
    minSdk = 31
    compileSdk = libs.versions.compileSdk.get().toInt()
    versionCode = 1
    versionName = "1.0"
  }
  buildFeatures {
    compose = true
  }
  buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }
  composeOptions {
    kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
  }
  java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(11))
  }
  lint {
    abortOnError = true
  }
}

dependencies {
  implementation(projects.library)
  implementation(libs.androidx.appcompat)
  implementation(libs.androidx.activity)
  implementation(libs.compose.foundation)
  implementation(libs.compose.ui)
  implementation(libs.compose.materialIcons)
  implementation(libs.blurhash)
}
