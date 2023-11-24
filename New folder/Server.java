import java.awt.Color;
import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Server {

    int n = 5;
    int[][] mtr = setMatrix(n);

    List<Point> daDanh = new ArrayList<>();
    Vector<ClientProcessing> playerList = new Vector<>();

    public static void main(String[] args) throws Exception {
        new Server();
    }

    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);

            // Chỉ chấp nhận 4 kết nối
            while (playerList.size() < 4) {
                Socket soc = serverSocket.accept();
                ClientProcessing cp = new ClientProcessing(this, soc);
                playerList.add(cp);
                cp.start();
            }
        } catch (Exception e) {
        }
    }

    public static int[][] setMatrix(int n) {
        int[][] result = new int[n][n];
        Random rand = new Random();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = i * n + j + 1;

        for (int r = 0; r < n * n; r++) {
            int i1 = rand.nextInt(n);
            int j1 = rand.nextInt(n);
            int i2 = rand.nextInt(n);
            int j2 = rand.nextInt(n);
            int tmp = result[i1][j1];
            result[i1][j1] = result[i2][j2];
            result[i2][j2] = tmp;
        }

        return result;
    }

}

class ClientProcessing extends Thread {

    Server server;
    Socket soc;
    int color;

    public ClientProcessing(Server server, Socket soc) {
        this.server = server;
        this.soc = soc;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public void run() {

        // Đồng bộ ma trận cho các client
        if (server.playerList.size() == 4) {

            for (int i = 0; i < server.playerList.size(); i++) {

                for (int k = 0; k < server.n; k++) {

                    for (int j = 0; j < server.n; j++) {
                        try {
                            DataOutputStream dos = new DataOutputStream(server.playerList.get(i).soc.getOutputStream());
                            dos.writeInt(server.mtr[k][j]);
                        } catch (IOException e) {
                        }
                    }

                }

            }

        }

		/*
		for (int i = 0; i < server.n; i++)
			for (int j = 0; j < server.n; j++) {
				try {
					DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
					dos.writeInt(server.mtr[i][j]);
				} catch (IOException e) {
				}
			}
		*/

        /*
         * // Client mới kết nối đến sẽ được server trả ra các điểm đã chơi for (int i =
         * 0; i < server.daDanh.size(); i++) { try { DataOutputStream dos = new
         * DataOutputStream(soc.getOutputStream());
         * dos.writeInt(server.daDanh.get(i).x); dos.writeInt(server.daDanh.get(i).y); }
         * catch (IOException e) { } }
         */

        // Server nhận các điểm client chọn và kiểm tra
        while (true) {
            try {
                DataInputStream dis = new DataInputStream(soc.getInputStream());
                int x = dis.readInt();
                int y = dis.readInt();

				/*
				if (server.playerList.size() < 4)
					continue;
				*/

                boolean check = true;
                if (server.mtr[x][y] != server.daDanh.size() + 1)
                    check = false;

                // Nếu hợp lệ sẽ hiển thị điểm đó cho tất cả các client
                if (check) {
                    server.daDanh.add(new Point(x, y));

                    for (int i = 0; i < server.playerList.size(); i++)
                        if (this == server.playerList.get(i))
                            this.setColor(i);

                    for (int i = 0; i < server.playerList.size(); i++) {
                        try {
                            DataOutputStream dos = new DataOutputStream(server.playerList.get(i).soc.getOutputStream());
                            dos.writeInt(x);
                            dos.writeInt(y);
                            dos.writeInt(color);
                        } catch (Exception e) {
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Client disconnected");
                server.playerList.remove(this);
                break;
            }
        }

    }

}

