# Multi-Module Android App - Dev Challenge

In this challenge, my primary focus was not on creating an extensive feature list but rather on establishing a solid foundation for future development. 
By implementing a clean, modular architecture and leveraging best practices such as the Single Source of Truth principle and type-safe navigation,
this project is well-prepared to accommodate new features and scale effectively in the future.
---

## Project Setup

To set up and run the project, follow these steps:

1. **Add API Key**:  
   Add your API key to the global `gradle.properties` file:
   ```properties
   FOURSQUARE_API_KEY=YOUR_API_KEY
   ``` 
Replace YOUR_API_KEY with your actual API key to enable API requests.

2. Sync the Project:
Open the project in Android Studio and sync the Gradle files.

3. Run the App:
Build and run the application on an emulator or a physical device.

## Architecture Overview

This application follows a **multi-module architecture**, split into three layers: **Core**, **Data**, and **Feature**.

### Core Layer
The **Core Layer** contains shared modules that provide foundational functionality for the app:

- **Database Module**:  
  Implements Room for local data storage. This allows the app to save data from the endpoint and provide offline support.

- **Navigation Module**:  
  Handles type-safe navigation using Jetpack Compose. The routes are centrally managed for a consistent and safe navigation experience.

- **Network Module**:  
  Uses Ktor for efficient network requests to fetch data from the API.

### Data Layer
The **Data Layer** implements the **Single Source of Truth** principle recommended by the Android team:

- Integrates data sources from the Core Layer (e.g., Room and Ktor).
- Combines remote and local data sources in a repository to prepare and map data for the feature layer.
- Acts as a bridge between the Core modules and the Feature Layer.

### Feature Layer
The **Feature Layer** consists of independent modules, one for each screen:

- Each feature module includes:
  - A **ViewModel** that follows the **MVVM** (Model-View-ViewModel) structure.
  - A **UI Screen** implemented with Jetpack Compose.

## Modern Features and Tools

This project incorporates the following modern tools and practices:

- **Arrow Library**:  
  Used for modern error handling with the **Either pattern**, ensuring a robust and predictable app flow.

- **Build Logic Module**:  
  Provides custom convention plugins for Gradle, simplifying and standardizing build configurations across modules.

---

## Testing

Testing is implemented using:

- **MockK**:  
  A modern mocking library for Kotlin, enabling efficient unit testing of ViewModels, repositories, and other app components.

