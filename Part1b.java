import java.util.*;
import java.io.*;
import java.lang.*;

public class Part1b {


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

        int opPeriodTime = 0;
        Scanner scanner2 = new Scanner(new File(args[1]));
        if (scanner2.hasNextLine()) {
            String opPeriodTimeStr = scanner2.nextLine();
            if (opPeriodTimeStr.compareTo("LM") == 0)
                opPeriodTime = 1;
            else if (opPeriodTimeStr.compareTo("LQ") == 0)
                opPeriodTime = 3;
            else if (opPeriodTimeStr.compareTo("LTM") == 0)
                opPeriodTime = 12;
        }

        int periodDate = 0;
        Scanner scanner3 = new Scanner(new File(args[2]));
        if (scanner3.hasNextLine()) {
            String date = scanner3.nextLine();
            StringTokenizer st2 = new StringTokenizer(date,"-");
            periodDate = Integer.parseInt(st2.nextToken())*12+Integer.parseInt(st2.nextToken());
        }


        int sum = 0;
        for (int i = 0; i < LQVisits.size(); i++) {
            int startingTime = LQVisits.get(i)[1];
            int money = LQVisits.get(i)[0];
            int endingTime = LQVisits.get(i)[2];
            if (startingTime > periodDate-opPeriodTime && endingTime<=periodDate) {
                sum += money;
            }
        }

        System.out.println(sum);

    }

}
