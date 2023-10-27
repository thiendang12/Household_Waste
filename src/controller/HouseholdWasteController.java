package controller;

import java.util.ArrayList;
import service.HouseholdWasteService;
import util.Library;
import view.Menu;

public class HouseholdWasteController extends Menu<String>{

    static String[] menuChoice = {"Enter Input", "Exit"};

    protected Library library;
    protected HouseholdWasteService service;

    public HouseholdWasteController() {
        super("Household Waste Program", menuChoice);
        library = new Library();
        service = new HouseholdWasteService();
    }

    @Override
    public boolean execute(int n) {
        switch (n) {
            case 1:
               handleInput();
                break;
            case 2:  
               return false;
            default:
                break;
        }
        return true;
    }
    private void handleInput(){
        ArrayList<Integer> arr = library.getArrInt("Enter Number garbage ");
        service.handleHouseholdWaste(arr);
        service.mustPay();
    }
}
