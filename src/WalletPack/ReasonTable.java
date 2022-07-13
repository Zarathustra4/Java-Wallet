package WalletPack;

import java.io.*;
import java.util.*;

public class ReasonTable {

    ArrayList<String> reasons = new ArrayList<String>();
    ArrayList<String> valuts = new ArrayList<String>();
    ArrayList<Double> prices = new ArrayList<Double>();

    private String Filepath;

    private int size = 0;

    public int getSize(){
        return size;
    }

    public String[] getReasons(){
        return reasons.toArray(new String[0]);
    }

    public boolean changePrice(int index, double delta) throws IOException {
        if(index>size || index<0){
            return false;
        }
        prices.set(index, prices.get(index) + delta);
        //TODO changing file
        return true;
    }

    ReasonTable(String Filepath) throws IOException {
        this.Filepath = Filepath;
        File file = new File(Filepath);
        if(!file.exists()){
            try {
                boolean newFile = file.createNewFile();
                if(!newFile){
                    System.out.println("File was not created!!!");
                }

                System.out.println("**File was created\n");
                FileWriter fileWriter = new FileWriter(Filepath);
                fileWriter.close();
            }
            catch(Exception e) {
                System.out.println(e.toString());
                throw e;
            }
        }
        else{
            try (BufferedReader br = new BufferedReader(new FileReader(Filepath))) {
                String line;
                System.out.println("Reading file...");
                while ((line = br.readLine()) != null) {
                    String[] sep = line.split(" ");
                    for(int i = 0; i < 3; i++){
                        System.out.println(sep[i]);
                    }

                    reasons.add(sep[0]);
                    prices.add(Double.parseDouble(sep[1]));
                    valuts.add(sep[2]);
                    size++;
                }
            }
        }
    }

    public void addReason(String reason, double price, String valute){
        //TODO adding new reason in arrays and changing file
    }

    public static void main(String[] args) {
        try {
            ReasonTable t = new ReasonTable("C:\\WalletSource\\SpendReasons.txt");
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
