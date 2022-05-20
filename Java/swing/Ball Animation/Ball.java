import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

class Ball {
        private int x, y, size;
        private Color color;

        private int dx = 5;
        private int dy = 5;

        public Ball(int x, int y, int size, Color color, int dx, int dy) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.color = color;
            this.dx = dx;
            this.dy = dy;
        }

        //code for moving of balls
        void move(Dimension dimension) {

            if (x > dimension.width || x < 0) {
                dx *= -1;
            }

            if (y > dimension.height || y < 0) {
                dy *= -1;
            }

            if (x >dimension.width) {
                x = dimension.width;
            }

            if (x < 0) {
                x = 0;
            }

            if (y > dimension.height) {
                y = dimension.height;
            }

            if (y < 0) {
                y = 0;
            }

            this.x += dx;
            this.y += dy;

        }

        void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(x, y, size, size);
        }
    }