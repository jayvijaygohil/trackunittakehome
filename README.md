# Mobile Store
Welcome to the README file for the "Mobile Store" Android app. This app showcases a list of orders, fetched from JSON endpoint.

## Libraries Used

To build this app, I've harnessed the capabilities of the following libraries:

- **Orbit MVI**: Powering the app with the Model-View-Intent architecture for organized and predictable data flow.
- **Coroutines**: Employed for managing asynchronous operations in a concise and structured manner.
- **Retrofit + Okhttp + Kotlin Serialization**: The trio that enables seamless network communication and data parsing.
- **Koin**: Utilized for dependency injection, promoting modularity and maintainability.
- **Epoxy**: Streamlining the process of building complex and dynamic UI layouts.

## Architectural Approach

This app adopts a hybrid architectural approach by integrating Clean Architecture with Model-View-Intent (MVI) design. While typically favored for larger projects, this choice was made deliberately to highlight my proficiency in architectural practices.

### Advantages

Here's why the combination of Clean Architecture and MVI enhances the app's quality:

- **Clear Separation of Concerns**: Clean Architecture enforces a structured separation of responsibilities. Future modifications or replacements can be executed without undue impact on the entire codebase.
- **Code Structure**: The synthesis of Clean Architecture and MVI establishes a uniform and comprehensible code structure, simplifying navigation and comprehension.
- **Enhanced Testing**: Thanks to Clean Architecture's division and MVI's unidirectional data flow, unit testing becomes more efficient and comprehensive by allowing individual layers to be tested in isolation.
- **Future Adaptability**: The incorporation of Clean Architecture ensures that business logic remains independent of UI frameworks. Consequently, the app remains prepared for seamless migration to new platforms or frameworks.

### Potential Impacts

While this architectural approach offers numerous benefits, it's essential to be aware of the potential trade-offs:

- **Initial Development Pace**: The integration of Clean Architecture and MVI might lead to a slower initial development pace. However, this investment pays dividends in the long run by fostering code quality and maintainability.
- **Complexity and Documentation**: The amalgamation of these patterns can introduce complexity, potentially necessitating thorough documentation to aid team comprehension.
- **Boilerplate Code**: Implementing Clean Architecture and MVI may increase the presence of boilerplate code. This trade-off aims to improve maintainability while potentially adding verbosity to the codebase.

## How to Run

### Prerequisites

Before you dive into the app, ensure that you have the following set up:

- **Android Studio Iguana | 2023.2.1 Beta 2**
- **An Emulated Device**: Create one using Android Studio's virtual device manager.

### Running the App

1. **Download and Extract**: Download the project files and extract them. Open the project in Android Studio.
2. **Build the App**: Execute `./gradlew :app:assemble` in the terminal to build the app.
3. **Run the App**: Run `./gradlew :app:installDebug` in the terminal to install and launch the app.
4. **Unit Tests**: Run unit tests using `./gradlew test` in the terminal.