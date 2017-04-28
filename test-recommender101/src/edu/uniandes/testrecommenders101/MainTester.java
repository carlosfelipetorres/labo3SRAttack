package edu.uniandes.testrecommenders101;

import java.util.List;

import org.recommender101.data.DataModel;
import org.recommender101.data.DefaultDataLoader;
import org.recommender101.recommender.baseline.NearestNeighbors;



public class MainTester {
	
	public static void main(String[] args) {
		
		
		try {
			DataModel model= new DataModel();
            DefaultDataLoader loader= new DefaultDataLoader();
            loader.setFilename("data/movieTweetings/ratings.dat");
            loader.loadData(model);
            System.out.println("Data Loaded");
            NearestNeighbors recommender = new NearestNeighbors();
            recommender.setDataModel(model);
            recommender.setItemBased("true");
            recommender.setMinNeighbors("20");
            recommender.setNeighbors("50");
            recommender.init();
            System.out.println("Termino");
            //List<Integer> recItems = recommender.recommendItems(2).subList(0, 20);
            for(int ii = 0; ii < 10; ii++){
            	float res = recommender.predictRating(2, 119707);
            	System.out.println(res);
            }
            
            //for(int i = 0; i < recItems.size(); i++) {
            //    System.out.println("Item "+i+" "+recItems.get(i));
            //}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
