# 🐍 Snake Game

A classic Snake Game built with **Java Swing** featuring a clean dark interface, keyboard controls, score tracking, high score management, collision detection, and reliable restart functionality.

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
* 👀 Directional snake eyes
* 📊 Live score display
* ⚡ Stable game timer
* 🛡️ Safe snake array handling

## 🛠️ Technologies Used

* **Java**
* **Java Swing**
* **Java AWT**
* **Java Event Handling**
* **Java Timer**
* **Object-Oriented Programming**

## 📋 Requirements

* **JDK 8 or later**
* Git
* Any Java IDE or code editor

Recommended:

* JDK 17+
* IntelliJ IDEA
* Visual Studio Code
* Eclipse
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

### Clone the Repository

Replace `YOUR_REPOSITORY` with your actual GitHub repository name.

```bash
git clone https://github.com/sourav-108/YOUR_REPOSITORY.git
```

Navigate into the project:

```bash
cd YOUR_REPOSITORY
```

### Compile

```bash
javac SnakeGame.java
```

### Run

```bash
java SnakeGame
```

The game window will open. Press **SPACE** to start playing.

## 🎮 How to Play

### Start Game

Press:

```text
SPACE
```

### Movement Controls

| Key | Direction |
| --- | --------- |
| ↑   | Up        |
| ↓   | Down      |
| ←   | Left      |
| →   | Right     |
| W   | Up        |
| A   | Left      |
| S   | Down      |
| D   | Right     |

### Restart

When the game is over, press:

```text
SPACE
```

to restart.

## 🏆 Scoring System

Every time the snake eats an apple:

* Score increases by `1`
* Snake grows by one segment
* A new apple is generated
* High score is updated automatically

The high score is maintained during the current application session.

## 💥 Game Over Conditions

The game ends when:

* The snake hits any wall.
* The snake collides with its own body.

After Game Over, press **SPACE** to restart.

## 🎨 User Interface

The game features:

* Dark gaming background
* Grid-based game board
* Green snake
* Red apples
* Live score
* High score
* Start screen
* Game Over screen
* Restart instructions
* Anti-aliased graphics

## ⚙️ Game Configuration

Game settings can be customized directly inside `SnakeGame.java`.

### Screen Size

```java
private static final int SCREEN_WIDTH = 600;
private static final int SCREEN_HEIGHT = 600;
```

### Unit Size

```java
private static final int UNIT_SIZE = 25;
```

### Game Speed

```java
private static final int DELAY = 100;
```

Lower values make the snake move faster.

For example:

```java
private static final int DELAY = 75;
```

will make the game faster than:

```java
private static final int DELAY = 100;
```

## 🧠 Game Architecture

The game follows a simple event-driven architecture using Java Swing.

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

Each body segment follows the position of the segment in front of it, while the head moves according to the current direction.

### Apple Generation

Apples are generated at random grid positions. The game checks the snake's body before placing an apple to prevent it from spawning inside the snake.

### Collision Detection

The game detects:

* Snake head vs. body
* Snake head vs. left wall
* Snake head vs. right wall
* Snake head vs. top wall
* Snake head vs. bottom wall

## 🛡️ Stability

The implementation includes protections for reliable gameplay:

* Prevents array index overflow
* Prevents multiple active timers during restart
* Prevents apples from spawning inside the snake
* Prevents instant reverse movement
* Handles maximum snake size safely
* Properly resets the game state
* Maintains keyboard focus

## 🔄 Direction System

The snake cannot instantly reverse direction.

```text
Right → Left  ❌
Left  → Right ❌
Up    → Down  ❌
Down  → Up    ❌
```

This prevents immediate self-collision.

## 🖥️ Running with an IDE

### IntelliJ IDEA

1. Open the project.
2. Add `SnakeGame.java`.
3. Configure a valid JDK.
4. Run the `main()` method.
5. Press `SPACE` to start.

### Visual Studio Code

1. Install the Java Extension Pack.
2. Open the project folder.
3. Open `SnakeGame.java`.
4. Configure the JDK.
5. Run the Java file.
6. Press `SPACE` to start.

### Eclipse

1. Create a Java project.
2. Add `SnakeGame.java`.
3. Configure a JDK.
4. Run `SnakeGame`.
5. Press `SPACE` to start.

## 📦 Build and Run from Terminal

Compile:

```bash
javac SnakeGame.java
```

Run:

```bash
java SnakeGame
```

### Clean Compiled Files

#### macOS / Linux

```bash
rm *.class
```

#### Windows

```cmd
del *.class
```

## 🚫 Git Ignore

Create a `.gitignore` file:

```gitignore
*.class
.idea/
.vscode/
*.iml
.DS_Store
```

This prevents compiled files and IDE-specific files from being uploaded to GitHub.

## 🔮 Future Improvements

Potential future features include:

* ⏸️ Pause and Resume
* ⚡ Increasing difficulty
* 🎚️ Multiple difficulty levels
* 🔊 Sound effects
* 🎵 Background music
* 💾 Persistent high score
* 🎨 Multiple themes
* 🍓 Special food
* ⚡ Power-ups
* 🧱 Obstacles
* 🏁 Multiple levels
* 🏆 Leaderboard
* ✨ Advanced animations

## 🤝 Contributing

Contributions, suggestions, and improvements are welcome.

### Fork the Repository

Fork the project from:

```text
https://github.com/sourav-108
```

### Clone Your Fork

```bash
git clone https://github.com/sourav-108/YOUR_REPOSITORY.git
```

### Create a Feature Branch

```bash
git checkout -b feature/your-feature
```

### Commit Your Changes

```bash
git add .
git commit -m "Add your feature"
```

### Push Your Branch

```bash
git push origin feature/your-feature
```

Then create a Pull Request on GitHub.

## 📄 License

This project is licensed under the **MIT License**.

You are free to use, modify, and distribute this project according to the terms of the license.

## 👨‍💻 Author

**Sourav**

GitHub: `https://github.com/sourav-108`

This project was developed as a Java desktop application using **Swing** and **AWT**, focusing on clean gameplay logic, object-oriented programming, and a professional user interface.

---

⭐ **If you find this project useful, consider giving the repository a star.**
