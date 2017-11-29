package com.cisco.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StockBuySell {
	private static List<BuySellPair> BuySellPairs = new ArrayList<BuySellPair>(); 	

	public static void main(String[] args) {
	//	int[] stockPrices = {10, 22, 5, 75, 65, 80};
		int[] stockPrices = {22,20,15,12,11,10, 11,12,13,14,15,16,17,18,19,20,21,22, 5, 75, 65, 80};
		List<BuySellPair> pairs = findBuySellPairs(stockPrices);
		Iterator<BuySellPair> itr = pairs.iterator();
		BuySellPair pair;
		while(itr.hasNext()){
			pair = itr.next();
			System.out.println(pair.buy+" "+pair.sell);
		}

	}
	
	public static List<BuySellPair> findBuySellPairs(int[] stockPrices){
		int i = 0;
		int n = stockPrices.length;
		while(i<n-1){
			
			//find local minima
			while(i<n-1 && stockPrices[i]>=stockPrices[i+1]){
				i++;
			}
			
			if( i== n-1) break;
			BuySellPair bsp = new BuySellPair();
			if(i<n-1){
			    bsp = new BuySellPair();
				bsp.buy= i++;
				BuySellPairs.add(bsp);
			}
			
			//find local maxima
			while(i<(n-1)&&stockPrices[i]<=stockPrices[i+1]){
				i++;
			}
			
			bsp.sell = i++;
			
		}
		return BuySellPairs;
	}

}

class BuySellPair{
	int buy;
	int sell;
}
