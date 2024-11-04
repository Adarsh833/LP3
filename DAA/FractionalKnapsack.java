import java.util.Arrays;
import java.util.Comparator;

// Class representing an item with weight and value
class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

// Main class to solve the Fractional Knapsack problem
public class FractionalKnapsack {

    // Method to get the maximum value of items in the knapsack
    public static double getMaxValue(Item[] items, int capacity) {
        // Sort items by value-to-weight ratio in descending order
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> (double) item.value / item.weight).reversed());

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity > 0 && item.weight <= capacity) {
                // If the item can fully fit in the knapsack
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                // If only a fraction of the item can fit
                double fraction = (double) capacity / item.weight;
                totalValue += item.value * fraction;
                break; // No more items can be added after this
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        // Example items with weight and value
        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };
        int capacity = 50; // Knapsack capacity

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
