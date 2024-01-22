import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Stack list = new Stack();
		
		char [] dizi = new char [10];
		Random random = new Random();
		int sesli = 0, sessiz = 0;
		int i = 0;
		
		while (i < 10) 
		{
            int r = random.nextInt(26) + 97;
            
            if(r == 97 || r == 101 || r == 105 || r == 111 || r == 117) 
            {													//ASCII tablosuna göre a ile z arasından rastgele 
            	if(sesli<5) 									//sayılar çek ve diziye ekle. If ile konturol et 
            	{												//sesli veya sessizler 5 i geçmesin!
            		dizi[i] = (char) r;
            		sesli++;
            		i++;
            	}
            }
            else 
            {
            	if(sessiz<5) 
            	{
            		dizi[i] = (char) r;
            		i++;
            		sessiz++;
            	}
            }           
        }
		while(!list.isFull())
		{
			int randomIndex = random.nextInt(10);
			char harf = dizi[randomIndex];
		
			//System.out.println(harf);

			if(list.isEmpty())								//eğer yığın boşsa 1 tane ekle
			{
				//System.out.println("ilk eklendi");
				list.push(harf);
			}
			else
			{
				//System.out.println("ikinci eklendi");
				list.push(harf);							//değilse de 1 tane ekle en az 2 ile başla
				
				if(sesliMi(list.top.next.data))  			//eğer baştaki sesli ise ve 
				{											//sonraki de sessizse bir tane daha ekle
					//System.out.println("ilk sesli");
					if(!sesliMi(list.top.data)) 			
					{
						//System.out.println("ikinci sessiz");
					}
					else									//eğer baştaki sesli ise ve
					{										//sonraki de sesli ise bir tane çıkar
						list.pop();
						//System.out.println("ikinci sesliymiş sil");
					}
				}
				else													//baştaki sessizse sonraki de sesli ise
				{														// bir tane ekle 
					//System.out.println("ilki sessizmiş");
					if(sesliMi(list.top.data)) 
						
					{

						//System.out.println("ikinci sesli");
					}
					else										//eğer baştaki sessiz ise ve
					{											//sonraki de sessiz ise bir tane çıkar
						list.pop();
						//System.out.println("ikinci sessiz sil");
					}
				}
			}
			
			
        }
		list.print();
	}
	static boolean sesliMi(char r) {
		if(r == 97 || r == 101 || r == 105 || r == 111 || r == 117) 
		{															//sesli mi diye ascii ye göre kontrol et
			return true;
		}
		else return false;
	}
}
