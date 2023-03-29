/**
 * @author Dąbrowski Mateusz S22118
 */

package zad2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomersPurchaseSortFind {
    String path;
    List<Purchase> purchaseList;

    public CustomersPurchaseSortFind() {
        this.purchaseList = new ArrayList<>();
    }


    public void readFile(String path) {
        if (this.path == null) {
            read(path);
        } else {
            this.purchaseList = new ArrayList<>();
            read(path);
        }

    }

    private void read(String path) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(path))
        ) {
            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                purchaseList.add(new Purchase(Arrays.asList(nextLine.split(";"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.path = path;
    }

    public void showSortedBy(String columnName) {
        ArrayList<Purchase> purchaseListCp = new ArrayList<>(purchaseList);
        int columnIndex = getColumnIndex(columnName);
        if (columnIndex == 1) {
            System.out.println(columnName);
            purchaseListCp.sort(Purchase::compareTo);
            for (Purchase purchase : purchaseListCp) {
                System.out.println(purchase);
            }
            System.out.println();
        } else if (columnIndex == 3) {
            List<Purchase> collect = purchaseListCp.stream()
                    .sorted((el1, el2) -> {
                        if (el1.getPrice() * el1.getQuantity() > el2.getPrice() * el2.getQuantity()) {
                            return -1;
                        } else if (el1.getPrice() * el1.getQuantity() < el2.getPrice() * el2.getQuantity()) {
                            return 1;
                        } else {
                            return el1.parsedId().compareTo(el2.parsedId());
                        }
                    })
                    .collect(Collectors.toList());
            System.out.println("Koszty:");
            for (Purchase purchase : collect) {
                System.out.println(purchase + " (koszt: " + (purchase.getPrice() * purchase.getQuantity()) + ")");
            }
            System.out.println();
        }
    }

    private int getColumnIndex(String columnName) {
        switch (columnName) {
            case "Nazwiska":
                return 1;
            case "Koszty":
                return 3;
            default:
                return -1;
        }
    }

    public void showPurchaseFor(String id) {
        System.out.println("Klient " + id);
        ArrayList<Purchase> purchases = new ArrayList<>(purchaseList);
        purchases.stream()
                .filter(el -> el.getId().equals(id))
                .iterator()
                .forEachRemaining(System.out::println);
        System.out.println();
    }
}
