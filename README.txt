UraniumSnack - source project (NeoForge 1.21.1)
================================================

What you need (one time):
  1. JDK 21        -> https://adoptium.net  (pick "Temurin 21")
  2. IntelliJ IDEA Community (free) -> https://www.jetbrains.com/idea/download

Build steps:
  1. Unzip this folder somewhere (e.g. Desktop/uraniumsnack).
  2. Open IntelliJ -> Open -> select the file "build.gradle" -> "Open as Project".
  3. Wait for the bottom bar to finish syncing (first time downloads NeoForge,
     can take several minutes). If it asks which JDK to use, pick 21.
  4. Open the "Gradle" tab on the right -> uraniumsnack -> Tasks -> build -> double-click "build".
  5. Your mod is at:  build/libs/uraniumsnack-1.0.0.jar
  6. Put that jar in your mods folder.
  7. DELETE edibleuranium-1.0.1.jar (the old InsaneLib one) - you don't need it any more.

Result: Mekanism Raw Uranium = raw steak food value (3 hunger / 1.8 saturation),
        Mekanism Uranium Ingot = 2x cooked steak (16 hunger / 25.6 saturation).
        Both can be eaten even when full.

If the build fails, copy the red error text and send it to me.
