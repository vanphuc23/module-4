import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

public class Client extends JFrame implements Runnable, MouseListener {

    int n = 5;
    int[][] mtr = new int[n][n];
    int s = 100;
    int os = 50;

    Socket client;
    Map<Point, Integer> daDanh = new HashMap<>();

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        this.setSize(n * s + 2 * os, n * s + 2 * os);
        this.setTitle("Tim so");
        this.setDefaultCloseOperation(3);
        this.addMouseListener(this);
        this.setVisible(true);

        try {
            this.client = new Socket("localhost", 1234);
            Thread t = new Thread(this);
            t.start();
        } catch (Exception e) {
            System.out.println("Chưa kết nối đến server");
        }
    }

    @Override
    public void run() {

        // Đồng bộ ma trận
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                try {
                    DataInputStream dis = new DataInputStream(client.getInputStream());
                    mtr[i][j] = dis.readInt();
                } catch (IOException e) {
                }
            }

        while (true) {
            try {
                DataInputStream dis = new DataInputStream(client.getInputStream());
                daDanh.put(new Point(dis.readInt(), dis.readInt()), dis.readInt());
                this.repaint();
            } catch (Exception e) {
            }
        }

    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (var entry : daDanh.entrySet()) {
            if(entry.getValue() == 0) {
                g.setColor(Color.GREEN);
                int ix = entry.getKey().x;
                int iy = entry.getKey().y;
                int x = os + ix * s;
                int y = os + iy * s;
                g.fillRect(x, y, s, s);
            }
            if(entry.getValue() == 1) {
                g.setColor(Color.RED);
                int ix = entry.getKey().x;
                int iy = entry.getKey().y;
                int x = os + ix * s;
                int y = os + iy * s;
                g.fillRect(x, y, s, s);
            }
            if(entry.getValue() == 2) {
                g.setColor(Color.MAGENTA);
                int ix = entry.getKey().x;
                int iy = entry.getKey().y;
                int x = os + ix * s;
                int y = os + iy * s;
                g.fillRect(x, y, s, s);
            }
            if(entry.getValue() == 3) {
                g.setColor(Color.YELLOW);
                int ix = entry.getKey().x;
                int iy = entry.getKey().y;
                int x = os + ix * s;
                int y = os + iy * s;
                g.fillRect(x, y, s, s);
            }
        }

		/*
		g.setColor(Color.YELLOW);
		for (int i = 0; i < daDanh.size(); i++) {
			int ix = daDanh.get(i).x;
			int iy = daDanh.get(i).y;
			int x = os + ix * s;
			int y = os + iy * s;
			g.fillRect(x, y, s, s);
		}
		*/

        g.setColor(Color.BLACK);
        for (int i = 0; i <= n; i++) {
            g.drawLine(os, os + i * s, os + n * s, os + i * s);
            g.drawLine(os + i * s, os, os + i * s, os + n * s);
        }
        g.setFont(new Font("arial", Font.BOLD, s / 3));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String str = mtr[i][j] + "";
                if (mtr[i][j] < 10)
                    str = "00" + str;
                else if (mtr[i][j] < 100)
                    str = "0" + str;
                int x = os + i * s + s / 2 - s / 4;
                int y = os + j * s + s / 2 + s / 4 - s / 8;
                g.drawString(str, x, y);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (x < os || x >= os + n * s)
            return;
        if (y < os || y >= os + n * s)
            return;

        int ix = (x - os) / s;
        int iy = (y - os) / s;

        try {
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeInt(ix);
            dos.writeInt(iy);
        } catch (Exception e1) {
            System.out.println("Không gửi được!");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}

