# Expo Brownfield integration Project

This project is a "brownfield" integration example using Expo within an existing native Android application. It is structured as a monorepo to facilitate development and build reproduction scenarios.

## Project Structure

- `expo_app/`: The Expo application acting as the React Native module.
- `target/`: The native "host" Android application consuming the Expo module.

## How to Reproduce

To reproduce this scenario, follow the steps below:

### Prerequisites
- Have **MavenLocal** properly configured on your machine.

### In the `expo_app` directory
1. Install dependencies:
   ```bash
   bun install
   ```
2. Run the Android prebuild:
   ```bash
   bunx expo prebuild -p android
   ```
3. Generate the release build for Brownfield to be published to MavenLocal:
   ```bash
   bun build:android
   ```

### In the `target` directory (Native App)
1. Generate the release package:
   ```bash
   ./gradlew assembleRelease
   ```

## Known Issues and Solutions

### JNI Library Conflict (`libworklets.so`)
During the release build (`assembleRelease`), a duplication error for the `libworklets.so` file may occur between `react-native-reanimated` and `expo-modules`.

**Solution:**
The `target/app/build.gradle.kts` file already contains the following configuration to resolve the conflict:

```kotlin
android {
    packaging {
        jniLibs {
            pickFirsts.add("**/libworklets.so")
        }
    }
}
```

## Contributing
This project serves as an MRE (Minimal Reproducible Example) for issues related to `expo-brownfield`.
