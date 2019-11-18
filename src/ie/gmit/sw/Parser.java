//G00351754

package ie.gmit.sw;

import java.util.*;
import java.util.Map.Entry;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;



import javax.imageio.ImageIO;

public class Parser extends Menu{
	// HASHMap
	Map<String,Integer> freq = new HashMap<>();
	public void Parse() throws Exception{
		
		// ignorefile
		String ignore = "./ignorewords.txt";
		try {
			BufferedReader br=null;
			
			// if user Prompt 1 to enter file name
			if(URLorFile==1)
			{
			 br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			}//if
			// if user Prompt 2 to enter URL
			else if(URLorFile==2)
			{
				URL url1 = new URL(URL);
				URLConnection conn = url1.openConnection();
			 br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}
			String next;
			// reading 
			// complexity is o(n^2)
			while ((next = br.readLine()) != null)   {
				String[] words = next.replace(",", "").replace("{", "").replace("}", "").replace("=", "").replaceAll("(<[^>]+>)|(&[^;]+;)", "").replace("-", "").replace(";", "").replace("*", "").replace(".", "").replace("--", "").replace("[", "").replace(":", "").replace("]", "").split(" ");
			      for(String word:words) {
			    		  if(!ignore.contains(word)) {
			    		  int prev =0;
				    	  if(freq.get(word)!=null) 
				    		  prev = freq.get(word);
				    	  freq.put(word, prev+1);
			    	  }// if ignore
			      }// for
			}// while
			br.close();
		} catch (Exception e) {
			throw new Exception("[ERROR] problem reading the file. " + e.getMessage());
		}
		//Getting all the entries of wordCountMap in the form of Set
        
		Set<Entry<String, Integer>> entrySet = freq.entrySet();
		
		//Creating a List by passing the entrySet
        
        List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(entrySet);
      //Sorting the list in the decreasing order of values 
        
        Collections.sort(list, new Comparator<Entry<String, Integer>>() 
        {
            @Override
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) 
            {
                return (e2.getValue().compareTo(e1.getValue()));
            }
        });
        
      //Printing the Prominent words in input file
        Set<String> keys=freq.keySet();
        Iterator<String> iter = keys.iterator();
        
      	 BufferedImage image = new BufferedImage(800, 450, BufferedImage.TYPE_4BYTE_ABGR);
      	Graphics2D graphics = image.createGraphics();
      	
      	
      	Random rnd = new Random();
      	
        for (int i = 1; i <= maxWordImg && iter.hasNext(); i++) {
        	int size = rnd.nextInt(37) + 11;
        	Font font = new Font(Font.SANS_SERIF, Font.PLAIN, size);
        	graphics.setFont(font);
            graphics.setColor(Color.RED);
            graphics.drawString(iter.next(), random_int(10, 1000), random_int(10, 500));
        }// for
        	graphics.dispose();
        	ImageIO.write(image, "png", new File(imgName+".png"));
	}
	// random method
	public static int random_int(int Min, int Max)
	{
	     return (int) (Math.random()*(Max-Min))+Min;
	}
}

