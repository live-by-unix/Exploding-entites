# Dimensional Explosive Hits — source bundle

This folder is a **self-contained snapshot** on your Desktop: Gradle project, license, ignore rules, wrapper, and a **prebuilt** Fabric jar for Minecraft **1.21.11**.

## Layout

| Path | Description |
|------|-------------|
| `README.md` | This file |
| `LICENSE` | AGPL-3.0 legal text |
| `.gitignore` | Ignores `.gradle/`, `build/`, IDE files, etc. |
| `dimensional-explosive-hits-1.21.11.jar` | Remapped mod — copy into your `.minecraft/mods` (with Fabric API) |
| `build.gradle`, `settings.gradle`, `gradle.properties` | Gradle / Loom configuration |
| `gradlew`, `gradlew.bat`, `gradle/wrapper/` | Gradle Wrapper (9.3 per `gradle-wrapper.properties`) |
| `src/main/java/.../DimensionalExplosiveHits.java` | Mod logic |
| `src/main/resources/fabric.mod.json` | Mod metadata (`dimexhits`) |

Generated folders **`build/`** and **`.gradle/`** are not shipped in this snapshot; they appear after you run Gradle.

## Requirements to play

- Minecraft **1.21.11**
- **Fabric Loader** 0.18.6+ ([install guide](https://docs.fabricmc.net/players/installing-fabric))
- **Fabric API** jar for 1.21.11 in `mods`
- **Java** 21+

Install: put `dimensional-explosive-hits-1.21.11.jar` next to Fabric API in your `mods` folder.

## Requirements to rebuild

Same Java 21+. From this directory:

```bash
cd ~/Desktop/SOURCE_CODE
./gradlew build
```

The remapped jar is written to `build/libs/dimensional-explosive-hits-1.0.0.jar` (version from `gradle.properties`). You can copy or rename it to match the prebuilt jar name if you like.

Optional: `./gradlew copyToHome` copies that remapped jar to `~/dimensional-explosive-hits-1.21.11.jar` (does **not** run automatically on `build` in this snapshot).

## Behaviour summary

On the **logical server**, when a **non-spectator** player **attacks a living entity**, an explosion is spawned at the target using `World.createExplosion`, with power **3** (Overworld), **6** (Nether), or **7** (End, Wither-scale yield, mob explosion type). Damage uses `DamageSources.explosion(player, player)`. Other dimensions are ignored. **Warning:** very destructive to terrain.

## Versions (see `gradle.properties`)

- Minecraft **1.21.11**
- Yarn **1.21.11+build.4**
- Fabric API **0.141.3+1.21.11**
- Fabric Loom **1.15.5**

## Related copy

An older working tree may also exist at `~/Desktop/dimensional-explosive-hits`. This **SOURCE_CODE** tree is the packaged duplicate you asked for; either folder can be used to develop or build.
