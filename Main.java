import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {


    static int[] convert(String stt)
    {
        StringTokenizer st = new StringTokenizer(stt," ");
        String money = st.nextToken();
        String date = st.nextToken();
        String typpe = st.nextToken();
        int length = typpe.compareTo("LM")==0 ? 0 : 2;
        StringTokenizer st1 = new StringTokenizer(money,",");
        String dd1 = "";
        while (st1.hasMoreTokens()) {
            dd1 = dd1 + (st1.nextToken());
        }
        int moneey = Integer.parseInt(dd1);
        StringTokenizer st2 = new StringTokenizer(date,"-");
        int timm = Integer.parseInt(st2.nextToken())*12+Integer.parseInt(st2.nextToken());
        return (new int[]{moneey,timm-length,timm});
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<int[]> LQVisits = new ArrayList<>();
        Scanner scanner = new Scanner(new File(args[0]));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int[] dataPoint = convert(line);
            LQVisits.add(dataPoint);
        }

        int maxTime = -1;
        for (int i = 0; i < LQVisits.size(); i++) {
            int temp = LQVisits.get(i)[2];
            if (temp > maxTime) {
                maxTime =temp;
            }
        }

        int sum = 0;
        for (int i = 0; i < LQVisits.size(); i++) {
            int time = LQVisits.get(i)[2];
            int money = LQVisits.get(i)[0];
            if (time > maxTime-12 && (maxTime - time)%3 == 0) {
                sum += money;
            }
        }

//        System.out.println(new DecimalFormat("##,##,##0").format(sum));
        System.out.println(sum);
    }

}
