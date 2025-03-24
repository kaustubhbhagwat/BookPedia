<img width="415" alt="Screenshot 2025-03-24 at 8 34 49 PM" src="https://github.com/user-attachments/assets/3967ab72-2ce6-4ed6-b4d2-62953aa6b7d0" />BookPedia demonstrates modern Android development with Compose Multiplatform  using Koin, Coroutines, Flow, Jetpack (Room, ViewModel), and Material Design based on MVVM architecture
This is a Kotlin Multiplatform project targeting Android and iOS.

**Features** :
* Display and Search books
* Book Details
* Save favorite books


**Screenshots** :
 <table align="center">
  <H1>Search Result and Favorites</H1>
  <tr>
  <td><img width="416" alt="Screenshot 2025-03-24 at 8 33 56 PM" src="https://github.com/user-attachments/assets/46e0f2a9-6041-4b60-ace7-7c51bb1a04a6" /></td> 
  <td><img width="417" alt="Screenshot 2025-03-24 at 8 34 23 PM" src="https://github.com/user-attachments/assets/e5cfd64a-e5b7-4409-9320-17ca3f7bad4f" /></td>
  <td> <img width="415" alt="Screenshot 2025-03-24 at 8 34 49 PM" src="https://github.com/user-attachments/assets/e9243182-9029-42fc-8077-f856efa88f02" /></td>
  </tr>
 </table>


* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

