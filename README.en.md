> **Language:** [Русский](README.md) · English

# Spears (Minecraft 1.21.4 Fabric Port)

![Java 21](https://img.shields.io/badge/Java-21-blue.svg)
![Minecraft](https://img.shields.io/badge/Minecraft-1.21.4-blue.svg)
![Fabric](https://img.shields.io/badge/Loader-Fabric-blue.svg)
![ModMenu](https://img.shields.io/badge/ModMenu-Supported-blue.svg)
![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)

Port and update of the **Spears** (Backported Spears) mod for **Minecraft 1.21.4 (Fabric)** by **byMr712**.

Source: [GitHub: Unknowneth/Backported-Spears](https://github.com/Unknowneth/Backported-Spears).

---

## About

**Spears** introduces a full weapon class — **spears** (wooden, stone, copper, iron, golden, diamond, and netherite) with custom attack and charge mechanics.

---

## Gallery

| Combat & Lunge | Charge Attack | Piercing Strike |
|:---:|:---:|:---:|
| ![Spear Combat](images/spear_combat.gif) | ![Charge Attack](images/spear_charge_attack.gif) | ![Piercing Strike](images/spear_piercing.gif) |

---

## Features

- **Extended Reach**: Spears allow attacking targets from greater distance (2.0 – 4.5 blocks).
- **Charge Attack**: Holding right-click enters a forward charge stance; damage and knockback scale with player or mount (horse) speed, dismounting enemy riders.
- **Stab & Lunge**: Custom stabbing animations and unique sound effects.
- **Enchanting Support**: Full enchantment and combat attribute integration.

---

## Changes in 1.21.4 Port (byMr712)

- **Complete Migration to Minecraft 1.21.4 (Fabric Loader)**:
  - Clean project architecture (Fabric Loom 1.10.1, Yarn `1.21.4+build.7`, Java 21 LTS).
  - Combat logic and registry adaptation for 1.21.4 APIs (`ToolMaterial`, `EntityAttributes.ATTACK_DAMAGE`, `ActionResult`).
  - Network payloads updated via CustomPayload / PayloadTypeRegistry and loot conditions migrated to `LootWorldContext`.
  - Animation and rendering adapted to `BipedEntityRenderState` and `ItemDisplayContext`.
- **Client Item Definitions**:
  - Added `assets/minecraft/items/*.json` using `minecraft:display_context` selectors for flat 2D GUI icons and full 3D in-hand models.
- **Full Localization**:
  - Added Russian (`ru_ru.json`) and English (`en_us.json`) translations for all spears, subtitles, enchantments, and advancements.

---

## Installation

1. Download the latest release from [GitHub Releases](https://github.com/byMr712/Spears-1.21.4-MinecraftMod/releases).
2. Requires:
   - [Fabric API](https://modrinth.com/mod/fabric-api)
3. Place the `.jar` file into your `mods` folder.
4. Launch the game.

---

## Building

1. Requires Java 21 and Fabric Loader for Minecraft 1.21.4.
2. To build the project, run:
   ```bash
   ./gradlew build
   ```
3. The built jar file will be located at `build/libs/Spears-1.21.4-byMr712.jar`.

---

## Credits & License

- Original Author: [Unknowneth](https://github.com/Unknowneth) ([Backported-Spears](https://github.com/Unknowneth/Backported-Spears)).
- Ported and adapted for 1.21.4 by: [Mr712](https://github.com/byMr712).
- Distributed under the [Apache License 2.0](LICENSE).
