package service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;
import model.Dump;

public class HouseholdWasteService {
    private int totalPay = 0;
    public void handleHouseholdWaste(ArrayList<Integer> arr) {
        arr.sort((Integer o1, Integer o2) -> o1 - o2);
        Dump dump = new Dump(10000, 0);
        boolean flat = true;
        while (flat) {
            int l = arr.size();
            for (int i = l - 1; i >= 0; i--) {
                
                if (arr.size() == 1) {
                    dump.setTotalGarbage(dump.getTotalGarbage() - arr.get(i));
                    flat = false;
                    break;
                }
                if (dump.getTotalGarbage() - arr.get(i) > 0) {
                    dump.setTotalGarbage(dump.getTotalGarbage() - arr.get(i));
                    dump.setTime(dump.getTime() + 8);
                    arr.remove(i);
                }

            }
            dump.setCostPaidToDump(dump.getCostPaidToDump() + 57000);
            dump.setTotalGarbage(10000);
            dump.setTime(dump.getTime() + 30);
        }
        totalPay = (int) ((2000 * dump.getTime()) + dump.getCostPaidToDump());
        
    }

    public void mustPay() {
        NumberFormat format = NumberFormat.getInstance(Locale.forLanguageTag("VI"));
        System.out.println("The total cost is "+ format.format(totalPay)+"VNĐ");
    }

}
