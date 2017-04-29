package edu.uniandes.testrecommenders101;

import java.util.ArrayList;
import java.util.List;

import org.recommender101.data.DataModel;
import org.recommender101.data.DefaultDataLoader;
import org.recommender101.eval.metrics.Precision;
import org.recommender101.recommender.baseline.NearestNeighbors;



public class MainTester {
	
	public static void main(String[] args) {
		
		
		try {
			DataModel model= new DataModel();
            DefaultDataLoader loader= new DefaultDataLoader();
            loader.setFilename("data/20K/ratings.dat");
            loader.loadData(model);
            System.out.println("Data Loaded");
            NearestNeighbors recommender = new NearestNeighbors();
            recommender.setDataModel(model);
            recommender.setItemBased("true");
            recommender.setMinNeighbors("20");
            recommender.setNeighbors("50");
            recommender.init();
            System.out.println("Termino");
            List<Integer> recItems = recommender.recommendItems(1263);
            double  suma = 0;
            int ii = 1;
            double itemsWithRatings = 0;
            while(ii <= 5792){
            	float res = recommender.predictRating(ii, 2024432);
            	if(!Float.isNaN(res)){
            		suma += res;
            		itemsWithRatings++;
                	//System.out.println("item recomendado: "+ii + " " + res);
            	}
            	ii++;
            }
            System.out.println("promedio: "+suma/itemsWithRatings + " suma: "+suma + " hit ratio"+ itemsWithRatings/ii);
            for(int i = 0; i < recItems.size(); i++) {
                System.out.println("Item "+i+" "+recItems.get(i));
            }
            
            double numApear = 0.0;
            for(int j = 1; j < 5700; j++){
            	List<Integer> recItemsPerUser = new ArrayList<>();
            	if(recommender.recommendItems(j).size() < 30){
            		recItemsPerUser = recommender.recommendItems(j);
            	} else {
            		recItemsPerUser = recommender.recommendItems(j).subList(0, 30);
            	}
        		if(recItemsPerUser.contains(2024432)){
        			numApear += 1.0;
        		}
            }
			
            System.out.println("hit ratio: "+ numApear/5700+" num: "+numApear);
            
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
