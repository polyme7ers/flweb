//package lp3_daa;

import java.util.*;

class Item {
    int weight;
    int value;
    double ratio;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.ratio = (double) value / weight;
    }
}

public class fractionalknap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter weight and value of each item:");
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            items[i] = new Item(weight, value);
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();

        // Sort items by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        System.out.println("\nItems taken:");
        for (Item item : items) {
            if (remainingCapacity == 0)
                break;

            if (item.weight <= remainingCapacity) {
                // Take the whole item
                totalValue += item.value;
                remainingCapacity -= item.weight;
                System.out.println("Weight: " + item.weight + " | Value: " + item.value + " | Taken: 100%");
            } else {
                // Take fraction of item
                double fraction = (double) remainingCapacity / item.weight;
                totalValue += item.value * fraction;
                System.out.println(
                        "Weight: " + item.weight + " | Value: " + item.value + " | Taken: " + (fraction * 100) + "%");
                remainingCapacity = 0;
            }
        }

        System.out.println("\nMaximum total value in knapsack = " + totalValue);
        sc.close();
    }
}
