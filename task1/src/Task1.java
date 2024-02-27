public class Task1 {
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        m -= 1;

        StringBuilder sb = new StringBuilder("1");

        int i = 0;

        do {
            i = (i + m) % n;
            sb.append(i + 1);
        } while (i != 0);

        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }
}