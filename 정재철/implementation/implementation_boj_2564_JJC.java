// implementation_boj_2564_JJC

import java.util.*;

public class implementation_boj_2564_JJC {
    static class Shop { // 위치를 방향과 기준에서 거리 변수를 가진 객체
        private int dir;
        private int dis;
        Shop() {}
        Shop(int dir, int dis) {
            this.dir = dir;
            this.dis = dis;
        }
        public int getDir() {
            return this.dir;
        }
        public int getDis() {
            return this.dis;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hor = sc.nextInt();
        int ver = sc.nextInt();
        int n = sc.nextInt();
        Shop[] shop = new Shop[n];

        for (int i = 0; i < n; i++) { // 상점들의 입력을 받아 객체 배열에 초기화
            shop[i] = new Shop(sc.nextInt(), sc.nextInt());
        }

        Shop x = new Shop(sc.nextInt(), sc.nextInt()); //동근이의 위치 초기화

        int result = 0;
        for (int i = 0; i < n; i++) { // 상점의 개수가 n개이으로 n번 만큼 동근이와 상점의 방향을 기준으로 조건문을 돈다.
            if (x.getDir() == 1) {
                if (shop[i].getDir() == 1) {
                    result += Math.abs(x.getDis()-shop[i].getDis());
                } else if (shop[i].getDir() == 2) {
                    result += Math.min(x.getDis()+ver+shop[i].getDis(), hor-x.getDis() + ver + hor-shop[i].getDis());
                } else if (shop[i].getDir() == 3) {
                    result += x.getDis() + shop[i].getDis();
                } else if (shop[i].getDir() == 4) {
                    result += hor-x.getDis()+shop[i].getDis();
                }
            } else if (x.getDir() == 2) {
                if (shop[i].getDir() == 1) {
                    result += Math.min(x.getDis()+ver+shop[i].getDis(), hor-x.getDis() + ver + hor-shop[i].getDis());
                } else if (shop[i].getDir() == 2) {
                    result += Math.abs(x.getDis()-shop[i].getDis());
                } else if (shop[i].getDir() == 3) {
                    result += x.getDis()+ver-shop[i].getDis();
                } else if (shop[i].getDir() == 4) {
                    result += hor - x.getDis() + ver - shop[i].getDis();
                }
            } else if (x.getDir() == 3) {
                if (shop[i].getDir() == 1) {
                    result += x.getDis()+shop[i].getDis();
                } else if (shop[i].getDir() == 2) {
                    result += x.getDis()+ver-shop[i].getDis();
                } else if (shop[i].getDir() == 3) {
                    result += Math.abs(x.getDis()-shop[i].getDis());
                } else if (shop[i].getDir() == 4) {
                    result += Math.min(x.getDis()+hor+shop[i].getDis(), ver-x.getDis() + hor + ver-shop[i].getDis());
                }
            } else if (x.getDir() == 4) {
                if (shop[i].getDir() == 1) {
                    result += x.getDis()+ver-shop[i].getDis();
                } else if (shop[i].getDir() == 2) {
                    result += hor-x.getDis()+ver-shop[i].getDis();
                } else if (shop[i].getDir() == 3) {
                    result += Math.min(x.getDis()+hor+shop[i].getDis(), ver-x.getDis() + hor + ver-shop[i].getDis());
                } else if (shop[i].getDir() == 4) {
                    result += Math.abs(x.getDis()-shop[i].getDis());
                }
            }
        }
        System.out.println(result);
        
        sc.close();
    }

}