# 🐍 Snake Game

A classic Snake Game built with **Java Swing** featuring a clean dark interface, smooth gameplay, keyboard controls, score tracking, high score management, collision detection, and restart functionality.

## ✨ Features

* 🎮 Arrow Key and WASD controls
* 🐍 Classic Snake gameplay
* 🍎 Random apple generation
* 🚫 Apple does not spawn inside the snake
* 💥 Wall collision detection
* 💀 Self-collision detection
* 🏆 High score tracking
* 🔄 Restart after Game Over
* ⌨️ Space key to start and restart
* 🎨 Professional dark-themed interface
* ✨ Anti-aliased graphics
* 👀 Snake head with directional eyes
* 📊 Live score display
* ⚡ Fixed game timer and stable restart system
* 🛡️ Protected against snake array overflow

## 🛠️ Technologies Used

* **Java**
* **Java Swing**
* **Java AWT**
* **Java Event Handling**
* **Java Timer**
* **Object-Oriented Programming**

## 📋 Requirements

Before running the project, make sure you have:

* Java Development Kit (**JDK 8 or later**)
* Any Java IDE or code editor
* Terminal or Command Prompt

Recommended:

* JDK 17+
* IntelliJ IDEA
* Eclipse
* Visual Studio Code
* NetBeans

## 📁 Project Structure

```text
Snake-Game/
│
├── SnakeGame.java
├── README.md
└── .gitignore
```

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
```

### 2. Navigate to the Project

```bash
cd YOUR_REPOSITORY
```

### 3. Compile the Game

```bash
javac SnakeGame.java
```

### 4. Run the Game

```bash
java SnakeGame
```

## 🎮 How to Play

### Start Game

Press:

```text
SPACE
```

### Move the Snake

| Key | Direction |
| --- | --------- |
| ↑   | Up        |
| ↓   | Down      |
| ←   | Left      |
| →   | Right     |
| W   | Up        |
| S   | Down      |
| A   | Left      |
| D   | Right     |

### Restart

After Game Over:

```text
SPACE
```

## 🏆 Scoring System

Every time the snake eats an apple:

* Score increases by `1`
* Snake grows by one segment
* A new apple is generated
* High score is automatically updated

The high score remains available during the current application session.

## 💥 Game Over Conditions

The game ends when:

1. The snake hits the wall.
2. The snake collides with its own body.

After Game Over, press `SPACE` to start a new game.

## 🎨 User Interface

The game includes:

* Dark background
* Grid-based game board
* Green snake
* Red apples
* Live score
* High score
* Start screen
* Game Over screen
* Restart instructions

## ⚙️ Game Configuration

The main game settings can be changed directly inside `SnakeGame.java`.

### Screen Size

```java
private static final int SCREEN_WIDTH = 600;
private static final int SCREEN_HEIGHT = 600;
```

### Snake Unit Size

```java
private static final int UNIT_SIZE = 25;
```

### Game Speed

```java
private static final int DELAY = 100;
```

A lower `DELAY` value makes the snake move faster.

For example:

```java
private static final int DELAY = 75;
```

makes the game faster than:

```java
private static final int DELAY = 100;
```

## 🧠 Core Game Logic

The game uses a simple event-driven architecture.

### Game Loop

A Java Swing `Timer` repeatedly triggers the game update:

```text
Timer
  ↓
Move Snake
  ↓
Check Apple
  ↓
Check Collision
  ↓
Repaint Screen
  ↓
Repeat
```

### Snake Movement

The body follows the previous position of each segment while the head moves according to the current direction.

### Apple Generation

The apple is placed randomly on the game grid. Before accepting a new position, the game checks whether the position is already occupied by the snake.

### Collision Detection

The game checks:

* Head vs. body
* Head vs. left wall
* Head vs. right wall
* Head vs. top wall
* Head vs. bottom wall

## 🛡️ Stability Improvements

This version includes several protections for reliable gameplay:

* Prevents invalid snake array access
* Prevents multiple timers during restart
* Prevents apples from spawning inside the snake
* Prevents invalid direction reversal
* Handles maximum snake size safely
* Resets game state correctly
* Restores keyboard focus when starting the game

## 🧩 Controls Logic

The snake cannot immediately reverse direction.

For example:

```text
Moving Right → Cannot immediately move Left
Moving Left  → Cannot immediately move Right
Moving Up    → Cannot immediately move Down
Moving Down  → Cannot immediately move Up
```

This prevents accidental instant self-collision.

## 🔧 Customization

You can customize the game by changing:

* Screen dimensions
* Snake size
* Game speed
* Snake colors
* Apple colors
* Background color
* Grid color
* Fonts
* Score display
* Start screen
* Game Over screen

Example:

```java
private static final int SCREEN_WIDTH = 800;
private static final int SCREEN_HEIGHT = 600;
```

## 🖥️ Running from an IDE

### IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Create or open the project.
3. Add `SnakeGame.java`.
4. Make sure a valid JDK is configured.
5. Run the `main()` method.
6. Press `SPACE` to start.

### Visual Studio Code

1. Install the Java Extension Pack.
2. Open the project folder.
3. Open `SnakeGame.java`.
4. Select the configured JDK.
5. Run the file.
6. Press `SPACE` to start.

### Eclipse

1. Create a Java project.
2. Add `SnakeGame.java`.
3. Configure a JDK.
4. Run `SnakeGame`.
5. Press `SPACE` to start.

## 📦 Build and Run

Compile:

```bash
javac SnakeGame.java
```

Run:

```bash
java SnakeGame
```

Remove generated class files when needed:

### macOS / Linux

```bash
rm *.class
```

### Windows

```cmd
del *.class
```

## 🚫 .gitignore

Create a `.gitignore` file and add:

```gitignore
*.class
.idea/
.vscode/
*.iml
.DS_Store
```

This prevents compiled Java files and IDE-specific files from being committed to GitHub.

## 📌 Future Improvements

Possible future versions may include:

* Pause and Resume
* Multiple difficulty levels
* Increasing speed
* Sound effects
* Background music
* Persistent high score
* Start menu
* Settings menu
* Multiple themes
* Power-ups
* Special food
* Obstacles
* Levels
* Animated graphics
* Mouse support
* Leaderboard system

## 🤝 Contributing

Contributions are welcome.

To contribute:

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
```

Create a new branch:

```bash
git checkout -b feature/your-feature
```

Make your changes, commit them, and push the branch:

```bash
git add .
git commit -m "Add your feature"
git push origin feature/your-feature
```

Then open a Pull Request on GitHub.

## 📄 License

This project is available under the **MIT License**.

You may use, modify, and distribute the project according to the terms of the license.

## 👨‍💻 Author

**Angan Durjoy**

A Java-based desktop Snake Game project built with Swing and AWT.

---

⭐ If you find this project useful, consider giving the repository a star.
