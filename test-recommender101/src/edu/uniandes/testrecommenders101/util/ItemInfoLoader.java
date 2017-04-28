package edu.uniandes.testrecommenders101.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.recommender101.data.DataModel;
import org.recommender101.data.DefaultDataLoader;
import org.recommender101.data.Rating;
import org.recommender101.data.extensions.dataloader.DefaultDataLoaderWithTimeStamp;
import org.recommender101.tools.Utilities101;


/**
 * Loads the information about items from the Movietweetings dataset
 * @author AndresM
 *
 */
public class ItemInfoLoader {
	
	private final static Logger LOG = Logger.getLogger(ItemInfoLoader.class
		      .getName());
	


	
	/**
	 * Returns a map of ItemInformation, where the key is the itemId
	 * @param fileName - The file to be loaded
	 * @param m - The loaded DataModel to obtain the item popularity and average.
	 * @throws FileNotFoundException  if the file is not found
	 */
	public static HashMap<Integer, ItemInformation> load(DataModel m,String fileName) throws FileNotFoundException {
		HashMap<Integer, ItemInformation> itemInformationMap= new HashMap<>();
		Map<Integer, Float> itemAverages=Utilities101.getItemAverageRatings(m.getRatings());
		Map<Integer, Integer> itemPopularity=getItemCount(m.getRatings());
		
		BufferedReader reader = null;
		String line=null;
		String[] tokens =null;
		try {
			reader=new BufferedReader(new FileReader(fileName));
			while((line=reader.readLine())!=null){
				if (line.trim().startsWith("//")) {
					continue;
				}
				tokens = line.split(":{2,2}");
				String itemId=tokens[0];
				String itemName=(tokens[1]);
				
			
				LinkedList<String> itemGenres= new LinkedList<>();
				if(tokens.length>2){
				String[] tokens2=tokens[2].trim().split("\\|");
				
				//String itemURL=(tokens[4]);
			
				for(int i=0;i<tokens2.length;i++){
					
						itemGenres.add(tokens2[i].trim());
					
				}
				}
				int idNum = Integer.parseInt(itemId);
			
				ItemInformation itemInformation = new ItemInformation(idNum,itemName,"",itemGenres,itemPopularity.get(idNum)==null?0:itemPopularity.get(idNum),itemAverages.get(idNum)==null?0:itemAverages.get(idNum));
				itemInformationMap.put(idNum, itemInformation);
				
				
			}
		} catch (FileNotFoundException e) {

			throw e;
		} catch (IOException e) {
			
			LOG.severe("Error reading file "+fileName);
			
		}
		finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {}
			}
			
		}
		return itemInformationMap;
		
	}
	
	private static Map<Integer, Integer> getItemCount(Set<Rating> ratings) {
		Map<Integer, Integer> counters = new HashMap<Integer, Integer>();

		for (Rating r : ratings) {
			Integer count = counters.get(r.item);
			if (count == null) {
			
				counters.put(r.item, 1);
			} else {
				counters.put(r.item, counters.get(r.item) + 1);
				
			}
		}
		return counters;
	}

	public static void main(String[] args) {
		try {
			
			DataModel model= new DataModel();
			DefaultDataLoader loader= new DefaultDataLoader();
			loader.setFilename("data/movieTweetings/ratings.dat");
			loader.loadData(model);
			String itemFileName = "data/movieTweetings/movies.dat";
			
			System.out.println("The dataset has numUsers:"+model.getUsers().size()+" numItems:"+model.getItems().size());
			ItemInformation[] array= getItemsSortedByPopularity(model,itemFileName);
			System.out.println("Most popular items sorted by number of ratings are: ");
			int count = 30;
			for(int i =0; i< count ;i++){
				System.out.println(array[i]);
			}
			System.out.println();
			System.out.println("Least popular items sorted by number of ratings are: ");
			for(int i =array.length-1; i> array.length-1-count;i--){
				System.out.println(array[i]);
			}
			
			ItemInformation[] arrayBest= getItemsSortedByRating(model,itemFileName);
			System.out.println();
			System.out.println("Items with at least 15 ratings with best average are: ");
			count = 30;
			for(int i =0; i< count ;i++){
				System.out.println(arrayBest[i]);
			}
			System.out.println();
			System.out.println("Items with worst average rating are: ");
			for(int i =arrayBest.length-1; i> arrayBest.length-1-count;i--){
				System.out.println(arrayBest[i]);
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ItemInformation[]  getItemsSortedByPopularity(DataModel model,String itemFileName)
			throws FileNotFoundException {
		
		HashMap<Integer, ItemInformation> itemInfo=ItemInfoLoader.load(model,itemFileName);
		ItemInformation[] array= null;
		
		array=new ItemInformation[itemInfo.keySet().size()];
		int index=0;
		for (Integer itemId : itemInfo.keySet()) {
			array[index++]=itemInfo.get(itemId);
		}
		
		Arrays.sort(array,new Comparator<ItemInformation>() {

			@Override
			public int compare(ItemInformation o1, ItemInformation o2) {
				// * -1 for reverse order
				return Long.compare(o1.getNumRatings(), o2.getNumRatings())*-1;
			}
		});
		return array;
	}
	
	public static ItemInformation[]  getItemsSortedByRating(DataModel model,String itemFileName)
			throws FileNotFoundException {
		
		HashMap<Integer, ItemInformation> itemInfo=ItemInfoLoader.load(model,itemFileName);
		LinkedList<ItemInformation> list= new LinkedList<ItemInformation>();
		
		
		int index=0;
		for (Integer itemId : itemInfo.keySet()) {
			ItemInformation itemInformation = itemInfo.get(itemId);
			if(itemInformation.getNumRatings()>=15)
				list.add(itemInformation);
		}
		
		ItemInformation[] array = list.toArray(new ItemInformation[list.size()]);
		Arrays.sort(array,new Comparator<ItemInformation>() {

			@Override
			public int compare(ItemInformation o1, ItemInformation o2) {
				// * -1 for reverse order
				return Double.compare(o1.getItemAverage(), o2.getItemAverage())*-1;
			}
		});
		return array;
	}

}
