package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;

public class Library {

    private static final String VALID_PHONE = "[(]?[0-9]{3}[)]?[-. ]?[0-9]{3}[-. ]?[0-9]{4}"
            + "|[0-9]{3}[-][0-9]{3}[-][0-9]{4}[ a-z0-9]+";
    static Scanner sc = new Scanner(System.in);

    public ArrayList<Integer> getArrInt(String promt) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine().trim();
                arr = stringToArr(s);
                if(arr.equals(null)){
                    throw new Exception();
                }else{
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter array of numbers");
            }
        }
        return arr;
    }

    public ArrayList<Integer> stringToArr(String s) {
        ArrayList<Integer> ar = new ArrayList<>();
        String[] arrNum = s.split(" ");
        for (String a : arrNum) {
            try {
                ar.add(Integer.valueOf(a));

            } catch (NumberFormatException e) {
                return null;
            }
        }
        return ar;

    }

    public String checkInputPhone(String promt) {
        //loop until user input correct
        while (true) {
            String result = getString(promt);
            if (result.matches(VALID_PHONE)) {
                return result;
            }
            System.err.println("Please input Phone flow\n"
                    + "• 1234567890\n"
                    + "• 123-456-7890 \n"
                    + "• 123-456-7890 x1234\n"
                    + "• 123-456-7890 ext1234\n"
                    + "• (123)-456-7890\n"
                    + "• 123.456.7890\n"
                    + "• 123 456 7890");
            System.out.print("Enter again: ");
        }
    }

    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }

    public int getInt(String promt, int min) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a > min) {
                    break;
                } else {
                    System.out.println("Please enter must greate then " + min);
                }
            } catch (Exception e) {
                System.out.println("Please enter must greate then " + min);
            }
        }
        return a;
    }

    public int getInt(int max, String promt) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a < max) {
                    break;
                } else {
                    System.out.println("Please enter must less then " + max);
                }
            } catch (Exception e) {
                System.out.println("Please enter must less then " + max);
            }
        }
        return a;
    }

    public int getInt(String promt) {
        Integer a = null;

        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a != null) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        return a;
    }

    public int getId(String promt, Predicate<Integer> p, String fiterString) {
        Integer a = null;

        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a != null) {
                    if (p.test(a)) {
                        break;
                    } else {
                        System.out.println(fiterString);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        return a;
    }

    public String getString(String promt, Predicate<String> p, String fiterString) {
        String s = "";

        while (true) {
            System.out.print(promt + ": ");
            try {
                s = sc.nextLine().trim();
                if (s != null) {
                    if (p.test(s)) {
                        break;
                    } else {
                        System.out.println(fiterString);
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println("Please enter a String");
            }
        }
        return s;
    }

    public String getString(String promt) {
        String result = "";
        while (true) {
            System.out.print(promt + ": ");
            try {
                result = sc.nextLine().trim();

                if (!result.isEmpty()) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a String");
            }
        }
        return result;

    }

    public int[] createArray(int size_Array) {
        int[] array = new int[size_Array];
        Random rd = new Random();
        for (int i = 0; i < size_Array; i++) {
            array[i] = rd.nextInt(100);
        }
        return array;
    }

    public void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.println("");
    }

    public boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = getString("Do you want to continue (Y/N)? ");
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

}
