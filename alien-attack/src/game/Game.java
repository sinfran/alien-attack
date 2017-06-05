package game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by frances on 2016-12-25.
 */

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private static final int SHOOTER_HEIGHT = 47;

    // Width and height of the game screen
    static final int WIDTH = 400;
    static final int HEIGHT = 600;

    private BufferStrategy bs = null;
    private Graphics graphics = null;
    private Thread thread;

    private boolean running = false;
    static boolean gameOver = false;

    public enum State {
        MENU,
        HELP,
        GAME,
        WON,
        GAME_OVER
    }

    public static Game.State state;

    // Main menu
    private Menu menu;

    // Entities in game
    private Earth earth;
    private MotherShip ship;
    private UFOShooter shooter1;
    private HealthBar shooter1Health;
    private UFOShooter shooter2;
    private HealthBar shooter2Health;
    private UFOShooter shooter3;
    private HealthBar shooter3Health;
    public static Player player;
    public static List<Egg> eggs = new CopyOnWriteArrayList<>();
    public static List<Bullet> playerBullets = new CopyOnWriteArrayList<Bullet>();

    // Buffer screen after the game has been won
    private PlayButton continueButton;

    // Game Over screen
    private Instructions i;

    public Game() {
        new Cache();
        setUpGame();
    }

    public void setUpGame() {
        state = Game.state.MENU;

        this.addMouseListener(new MouseInput());
        addKeyListener(new KeyInput());

        // Menu initialization
        menu = new Menu();
        i = new Instructions();

        // Entities initialization
        earth = new Earth((WIDTH / 4) - 195, 463, 600, 600, Cache.earth);
        ship = new MotherShip((WIDTH / 4) - 100, SHOOTER_HEIGHT - 210, 400, 350, Cache.ship);
        player = new Player((WIDTH / 2) - 17, HEIGHT - 230, 120, 90);
        continueButton = new PlayButton(Game.WIDTH / 2 - 105, 250, 200, 58, Cache.cont);

        // UFOShooter initialization
        shooter1 = new UFOShooter(100, SHOOTER_HEIGHT, 90, 50, Cache.shooter);
        shooter1Health = new HealthBar();
        shooter2 = new UFOShooter(0, SHOOTER_HEIGHT, 90, 50, Cache.shooter);
        shooter2Health = new HealthBar();
        shooter3 = new UFOShooter(WIDTH - 10, SHOOTER_HEIGHT, 90, 50, Cache.shooter);
        shooter3Health = new HealthBar();

        // Setting up the frame
        JFrame frame = new JFrame("Alien Attack");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(this);
        thread = new Thread(this);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        if (bs == null) {
            createBufferStrategy(2);
            bs = getBufferStrategy();
            graphics = bs.getDrawGraphics();
            thread.start();
            running = true;
        }
    }

    private void update() {
        if (state == State.GAME) {

            checkCollisions();

            for (Bullet bullet : playerBullets) {
                if (bullet.hit)
                    playerBullets.remove(bullet);

                if (bullet.y <= -1)
                    playerBullets.remove(bullet);

                bullet.update();
            }

            shooter1.update();
            shooter2.update();
            shooter3.update();
            player.update();
            earth.update();
            ship.update();
            checkGameOver();

            for (Egg egg : eggs) {
                if (egg.y <= 0 || egg.y >= HEIGHT) {
                    eggs.remove(egg);
                }
                egg.update();
            }

        } else if (state == State.GAME_OVER) {
            earth.update();
        }
    }


    private void render() {
        graphics.clearRect(0, 0, WIDTH, HEIGHT);
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        if (state == State.GAME) {

            graphics.drawImage(Cache.background, 0, 0, getWidth(), getHeight(), null);
            earth.draw(graphics);
            ship.draw(graphics);
            player.draw(graphics);

            if (shooter1.isAlive) {
                shooter1.draw(graphics);
                shooter1Health.paint(graphics, shooter1);
            }

            if (shooter2.isAlive) {
                shooter2.draw(graphics);
                shooter2Health.paint(graphics, shooter2);
            }

            if (shooter3.isAlive) {
                shooter3.draw(graphics);
                shooter3Health.paint(graphics, shooter3);
            }

            for (Egg egg : eggs) {
                egg.draw(graphics);
            }

            for (Bullet bullet : playerBullets) {
                bullet.draw(graphics);
            }

        } else if (state == State.MENU) {
            graphics.drawImage(Cache.background, 0, 0, getWidth(), getHeight(), null);
            menu.render(graphics);

        } else if (state == State.HELP) {
            i.render(graphics);
        } else if (state == State.WON) {
            graphics.drawImage(Cache.background, 0, 0, null);
            continueButton.draw(graphics);
        } else if (state == State.GAME_OVER) {
            graphics.drawImage(Cache.background, 0, 0, null);
            earth.draw(graphics);
            earth.render(graphics);
        }
    }

    @Override
    public void run() {
        MusicPlayer.songMenu.setVolume(-10);
        MusicPlayer.songMenu.run();

        while (running) {
            update();
            render();
            bs.show();
            Thread.currentThread();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
            }
        }
    }

    private void checkCollisions() {
        for (final Egg egg : eggs) {
            if (egg.rect.intersects(player.rect)) {
                egg.setDY(-egg.getDY() - 5);
                MusicPlayer.bounce.setVolume(-38);
                MusicPlayer.bounce.run();
            } else {
                for (Bullet bullet : playerBullets) {
                    if (egg.rect.intersects(bullet.rect) && !egg.alreadyHit) {
                        MusicPlayer.hatch.setVolume(-40);
                        MusicPlayer.hatch.run();
                        bullet.hit = true;
                        egg.hit = true;
                        egg.setDY(0);
                        new java.util.Timer().schedule(
                                new java.util.TimerTask() {
                                    public void run() {
                                        egg.hatch();
                                        egg.spawn = true;
                                    }
                                },
                                5000
                        );
                    }
                }
            }
        }

        for (Bullet bullet : playerBullets) {
            MusicPlayer.hit.setVolume(-30);
            if (bullet.rect.intersects(shooter1.rect) && shooter1.isAlive) {
                shooter1.health -= 1;
                MusicPlayer.hit.run();
                if (shooter1.health == 0) {
                    shooter1.isAlive = false;
                }
            }
            if (bullet.rect.intersects(shooter2.rect) && shooter2.isAlive) {
                shooter2.health -= 1;
                MusicPlayer.hit.run();
                if (shooter2.health == 0) {
                    shooter2.isAlive = false;
                }
            }
            if (bullet.rect.intersects(shooter3.rect) && shooter3.isAlive) {
                shooter3.health -= 1;
                MusicPlayer.hit.run();
                if (shooter3.health == 0) {
                    shooter3.isAlive = false;
                }
            }
            if ((bullet.rect.intersects(shooter1.rect) ||
                    bullet.rect.intersects(shooter2.rect) ||
                    bullet.rect.intersects(shooter3.rect) && shooter3.isAlive) &&
                    state == Game.state.GAME) {
                bullet.hit = true;
            }
        }
    }

    private void checkGameOver() {
        if (!shooter1.isAlive && !shooter2.isAlive && !shooter3.isAlive && eggs.isEmpty()) {
            gameOver = true;
            state = State.WON;
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}








