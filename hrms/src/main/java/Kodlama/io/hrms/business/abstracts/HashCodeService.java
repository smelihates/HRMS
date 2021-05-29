//https://www.tasarimkodlama.com/java-programlama/java-rastgele-sifre-olusturma/
package Kodlama.io.hrms.business.abstracts;



import org.springframework.stereotype.Service;

@Service
public class HashCodeService {
	public String generateCode() {

		//kaç karakterli kod
		int n=10;
	    // rastgele harf seç
	    String metin = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                  + "0123456789"
	                  + "abcdefghijklmnopqrstuvxyz"; 
		
	    System.out.println(metin);
	    //  StringBuffer olutşurun 
	    StringBuilder sb = new StringBuilder(n); 
	 
	    for (int i = 0; i < n; i++) { 
	 
	      // metinden rastgele bir tane değer oku
	      int index 
	          = (int)(metin.length() 
	                  * Math.random()); 
	 
	      // sb değişkenine harfleri ekle
	      sb.append(metin 
	                    .charAt(index)); 
	    } 
	    System.out.println(sb.toString());
	    return sb.toString();
	    
	}
}
