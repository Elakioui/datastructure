package codewars;

public class OrdersSumarry {

    public static String balanceStatements(String lst) {

        if(lst.isEmpty())
            return "Buy:0 Sell 0";

        String[] orders = lst.trim().split(",");
        double buy = 0;
        double sell = 0;
        String error = "";
        int badlyFormatedCounter = 0;

        for(int i = 0; i < orders.length; i++ ){
            String[] orderDetail = orders[i].trim().split(" ");

            if (orderDetail.length != 4) {
                badlyFormatedCounter++;
                error += orders[i] + ",";
            }

            else {

                if(orderDetail[orderDetail.length -1].equals("B"))
                    buy += Double.parseDouble(orderDetail[1]) * Double.parseDouble(orderDetail[2]);

                else if(orderDetail[orderDetail.length -1].equals("S") )
                    sell += Double.parseDouble(orderDetail[1]) * Double.parseDouble(orderDetail[2]);
            }

        }

        if(badlyFormatedCounter > 0)
            error = "Badly formed " + badlyFormatedCounter + " : " + error;


        return error.isEmpty() == false ? "Buy: " + (int) buy + " Sell: " + (int) sell + "; " + error
                                          :
                                         "Buy: " + (int) buy + " Sell: " + (int) sell;
    }

    public static void main(String[] args) {
        System.out.println(balanceStatements("ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B"));

        balanceStatements("GOOG 90 160.45 B, JPMC 67 12.8 S, MYSPACE 24.0 210 B, CITI 50 450 B, CSCO 100 55.5 S");
    }
}
