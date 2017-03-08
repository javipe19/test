import java.util.ArrayList;
import java.util.TreeMap;

public class lz78 {
	
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    TreeMap<String, Integer> dictionary = new TreeMap<String, Integer>();
	    ArrayList<String> order = new ArrayList<String>();

		String[] chain=args[0].split("");
		
		
		int index=0;
		
		String current="";
			
		
		while(index<chain.length){
			current = chain[index];
	
			if(dictionary.containsKey(current)){
				
				//Actualizar el current
				for(int i=index; i<chain.length;i++){
		            if(dictionary.containsKey(current)){
		            	current = current+chain[i+1];
		            }
		        }
				
				String p = updatePreviouses(current, dictionary, index, chain);
				while(p!=""){
					p = updatePreviouses(p, dictionary, index, chain);
				}
				
				
				dictionary.put(current, 1);
				order.add(current);
					
				index = index+current.length();	
				
				
			}
			else{
				dictionary.put(current, 1);
				order.add(current);
				index++;
			}
			
//			System.out.println(dictionary);
			
		}

//		System.out.println(dictionary);
//		System.out.println(order);
		System.out.println("Trie:");
		System.out.println("root");
		

		
		//Printing
		for (int k=0;k<dictionary.size();k++){
			String key = (String) dictionary.keySet().toArray()[k];
			int value = dictionary.get(key);
			System.out.println(key+": ("+value+")");
		}
		
		
		

	}
	
	public static String updatePreviouses(String c, TreeMap<String, Integer> d, int index, String[] in){

			String previous="";
			int aux = index;
			for(int j=0; j<c.length()-1;j++){
				previous += in[aux];
                aux++;
			}
			//Actualizando el anterior
			if (d.containsKey(previous)){
				int old = d.get(previous);
				int nuevo =old+1;
				d.replace(previous, nuevo);
			}
			
			//new comment
			//another comment
			return previous;
		
	}

}
