> **Language:** [Русский](README.md) · English

# Spears (Minecraft 1.21.4 Fabric Port)

Port and update of the **Spears** (Backported Spears) mod for **Minecraft 1.21.4 (Fabric)** by **byMr712**.

Source: [GitHub: Unknowneth/Backported-Spears](https://github.com/Unknowneth/Backported-Spears).

---

## About the Mod

**Spears** introduces a full weapon class — **spears** (wooden, stone, copper, iron, golden, diamond, and netherite) with distinct combat mechanics:

### Features:
- **Extended Attack Reach**: Spears allow attacking targets at increased reach (2.0 – 4.5 blocks).
- **Charge Attack**: Holding right-click readies the spear for a kinetic charge; damage and knockback scale with player or mount movement speed, and dismount riding enemies.
- **Stab & Lunge**: Custom stabbing animation, particle effects, and audio feedback.
- **Enchantments**: Full support for enchantments and combat modifiers.

---

## Changes in 1.21.4 Port (byMr712)

- **Full Minecraft 1.21.4 (Fabric Loader) Migration**:
 - Streamlined single-module Fabric structure (Fabric Loom 1.10.1, Yarn `1.21.4+build.7`, Java 21 LTS).
 - Adapted combat math and item definitions to 1.21.4 registries (`ToolMaterial`, `EntityAttributes.ATTACK_DAMAGE`, `ActionResult`).
 - Updated networking (CustomPayload / PayloadTypeRegistry) and loot conditions to `LootWorldContext`.
 - Adapted rendering pipeline and animations to `BipedEntityRenderState` and `ItemDisplayContext`.
- **Client Item Definitions**:
 - Added `assets/minecraft/items/*.json` using `minecraft:display_context` selector for flat 2D sprite rendering in GUI/inventories and 3D weapon rendering in hands.
- **Full Bilingual Localization**:
 - English (`en_us.json`) and Russian (`ru_ru.json`) translations for all spears, sound subtitles, enchantments, and advancements.
- **Apache 2.0 License**:
 - Licensed under the Apache License 2.0.

---

## Build & Installation

1. Requires **Java 21** and **Fabric Loader** for Minecraft 1.21.4.
2. To build from source, run:
 ```bash
 ./gradlew build
 ```
3. The resulting mod jar is located at `build/libs/Spears-1.21.4-byMr712.jar`.

---

## License

Licensed under the **Apache License 2.0**. See the [LICENSE](LICENSE) file for details.
