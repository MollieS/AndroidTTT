# TicTacToe

Tic Tac Toe game for Android

## Requirements

* Android Studio 2.1.3
* Gradle 2+
* Android Debug Bridge (usually included in Android Studio)

## How to run

### Phone/Emulator Requirements

* This project is built for Android 6 and 7 and tested on a Nexus 6P

### Via Android Studio

* Open the project with Android Studio
* Run by using Run > Run 'app'
* If there is no emulator available, you will be prompted to create one.
* Create one using the Android Studio Emulator wizard.
* Once the emulator has been created or connected, the app will load

### Via the Command Line

* You will need a running Android emulator with Android 6 or 7
* Open the project in Android Studio
* You will need to generate an .apk file using Android Studio by using Build > Generate Signed APK... The wizard will guide you through the steps needed
* Copy the .apk to the sdk build tools directory. On a mac this will be Library/Android/sdk/build-tools
* Within that directory, run the command `adb install [.apk name]`
* If the emulator is running, the app will install and run

### Via an Android Phone

* Either connect your phone to Android Studio and run as with the emulator
* Or generate an .apk as with the command line and install on your phone

## How to test

* Acceptance tests are written using the espresso testing framework which requires an emulator.
* To run from the command line, from within the TicTacToe directory, run `./gradlew connectedCheck`
* To run in Android Studio, right click the test directory and select "run"




