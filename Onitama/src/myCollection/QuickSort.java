package myCollection;

import onitama.Player;

public class QuickSort {

	public static void quickSort(MyList<Player> list) {
        if (list.size() == 0) return; // Adicionando verificação para lista vazia
        quickSortHelper(list, 0, list.size() - 1);
    }
    
    private static void quickSortHelper(MyList<Player> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSortHelper(list, low, pivotIndex - 1);
            quickSortHelper(list, pivotIndex + 1, high);
        }
    }
    
    private static int partition(MyList<Player> list, int low, int high) {
		while (list.get(high) == null && high > low) {
			high--;
		}
	
		if (high == low || list.get(high) == null) {
			return high;
		}
		
        Player pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getScore() >= pivot.getScore()) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }
    
    private static void swap(MyList<Player> list, int i, int j) {
        Player temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }	    
}