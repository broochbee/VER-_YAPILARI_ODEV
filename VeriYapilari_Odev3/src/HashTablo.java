import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class HashTablo {
	Scanner scan = new Scanner(System.in);
	int deneme=1;
	int kargoAdedi=0;
	int total = 45;
	
	Kargo dizi[] = new Kargo[10];;
	
	public HashTablo() 
	{		
		for(int i=0; i<10; i++)
		{
			dizi[i] = new Kargo();
			
		}
	}
	
	int index1(int takipno) 
	{
		return takipno % 10;
	}
	

	
	int doubleHashing(int takipno) 
	{
		int index2 = 7 - (takipno % 7);
		return (index1(takipno)+ (deneme * index2)) % 10;
	}
	
	 
	
	void kargoEkle(int takipno, String isim1, String isim2, String kargoDurumu)
	{
		if(kargoAdedi<10)
		{
			if(dizi[index1(takipno)].isEmpty) 
			{
				dizi[index1(takipno)].isEmpty = false;
				kargoAdedi++;
				
				dizi[index1(takipno)].takipNo=takipno;
				dizi[index1(takipno)].gonderici= isim1;
				dizi[index1(takipno)].alici=isim2;
				dizi[index1(takipno)].kargoDurum=kargoDurumu;
				System.out.println(dizi[index1(takipno)].takipNo+" : "+index1(takipno)+ ". indekse eklendi.i");
			}
			
			
			else 
			{
				while(!dizi[doubleHashing(takipno)].isEmpty) 
				{
					total = total - doubleHashing(takipno);
					if(total<0) {
						System.out.println("Tabloda "+ takipno +" takip nolu kargo için uygun yer yok!");
						break;
					}
					deneme++;
				}
				if(dizi[doubleHashing(takipno)].isEmpty) {
					dizi[doubleHashing(takipno)].takipNo=takipno;
					dizi[doubleHashing(takipno)].gonderici= isim1;
					dizi[doubleHashing(takipno)].alici=isim2;
					dizi[doubleHashing(takipno)].kargoDurum=kargoDurumu;
					System.out.println(dizi[doubleHashing(takipno)].takipNo+" : "+doubleHashing(takipno)+ ". indekse eklendi.");
					kargoAdedi++;
					dizi[doubleHashing(takipno)].isEmpty = false;
					dizi[doubleHashing(takipno)].deneme=deneme;
					deneme = 1;
				}
					
			}
		}
		else 
		{
			System.out.println("Liste Dolu!");
		}
		
	}
	
	public void kullaniciKargoEkle()
	{
		System.out.println("Takip Numarası Giriniz :");
		int tn = scan.nextInt();
		System.out.println("Gönderici Giriniz :");
		String isim1 = scan.next();
		System.out.println("Alıcı Giriniz :");
		String isim2 = scan.next();
		System.out.println("Teslimat Durum Bilgisi Giriniz :");
		String kargoDurum = scan.next();
		if(kargoAdedi<=10)
		{
			kargoEkle(tn, isim1, isim2, kargoDurum);
		}
		else
		{
			System.out.println("Liste Dolu!");
		}
		
	}
	public void sorgula(int takipno)
	{
		int eleman =1;
		boolean bulundu = false;
		for (Kargo kargo : dizi) {
			if(kargo.takipNo== takipno) {
				System.out.println(kargo.deneme+1 +". denemede yerleştirildi");
				System.out.println("Tablodaki "+eleman +". kargo");			
				System.out.println("Gönderici: "+kargo.gonderici+"\tAlıcı: "+ kargo.alici+"\tKargo durumu: "+kargo.kargoDurum);
				bulundu = true;
			}
			eleman++;
		}
		if(!bulundu)System.out.println("!! BULUNAMADI !!");
	}
	
	public void listele()
	{
		int eleman =1;
		for (Kargo kargo : dizi) 
		{
			System.out.println(kargo.deneme+1 +" sefer sonra yerleştirildi");
			System.out.println("Tablodaki "+eleman +". kargo");			
			System.out.println("Gönderici: "+kargo.gonderici+" - Alıcı: "+ kargo.alici+" - Kargo durumu: "+kargo.kargoDurum);
			System.out.println("--------------------------");
			eleman++;
		}
	}
	
	public void sil(int takipno) {
		if(kargoAdedi<1) {
			System.out.println("!! Liste Boş !!");
		}
		else {
			for (Kargo kargo : dizi) {
				if(kargo.takipNo== takipno) {
					System.out.println(takipno +" nolu kargo teslim edildi ");
					 kargo.takipNo = 0;
					 kargo.alici=null;
					 kargo.gonderici=null;
					 kargo.kargoDurum= null;
					 kargo.isEmpty=true;
					 kargoAdedi--;
				}
			}
		}
	}
	
	public void txtkargoEkle() throws NumberFormatException, IOException {
		File file = new File("Kargo.txt");
		if(!file.exists()) 
		{
			System.out.println("Dosya bulunamadı!");
		}
			
			FileReader freader = new FileReader(file);
			String line;

			BufferedReader breader = new BufferedReader(freader);

			while ((line = breader.readLine()) != null ) {

                String[] parts = line.split("\t");
                
                if (parts.length != 4) 
                {
                    continue;
                }
                
                int takipNo = Integer.parseInt(parts[0]);
                String isim1 = parts[1];
                String isim2 = parts[2];
                String kargoDurumu = parts[3];
                
                kargoEkle(takipNo,isim1,isim2,kargoDurumu);  
			} 
	}
}
