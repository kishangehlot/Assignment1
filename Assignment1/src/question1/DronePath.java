package question1;

import java.util.Scanner;

public class DronePath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter grid size (rows columns): ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] grid = new int[rows][columns];

        System.out.print("Enter target position (row column): ");
        int Row = scanner.nextInt();
        int Column = scanner.nextInt();
        grid[Row][Column] = 1;

        int[][] drones = {
                {0, 0}, 
                {0, columns - 1}, 
                {rows - 1, 0},
                {rows - 1, columns - 1} 
        };

        for (int drone = 0; drone < drones.length; drone++) {
            int[] dronePosition = drones[drone];
            System.out.println("Searching with Drone " + (drone + 1) + "...");
            if (searchTarget(grid, dronePosition, Row, Column)) {
                System.out.println("Target found by Drone " + (drone + 1) + "!");
                break;
            }
        }
        scanner.close();
    }
    
    
    private static boolean searchTarget(int[][] grid, int[] dronePosition, int targetRow, int targetColumn) {
        int currentRow = dronePosition[0];
        int currentColumn = dronePosition[1];
        while (currentRow != targetRow || currentColumn != targetColumn) {

            if (currentRow < targetRow) {
                currentRow++;
            } else if (currentRow > targetRow) {
                currentRow--;
            }
            if (currentColumn < targetColumn) {
                currentColumn++;
            } else if (currentColumn > targetColumn) {
                currentColumn--;
            }

            System.out.println("Drone at position: (" + currentRow + ", " + currentColumn + ")");
        }
        return true;
    }
}