import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	static Scanner scan = new Scanner(System.in);
	static HashTablo kargo = new HashTablo();
	
	public static void main(String[] args) throws NumberFormatException, IOException{

			baslangic();
	}
	
	static void baslangic() throws NumberFormatException, IOException {
		System.out.println("LÜTFEN YAPMAK İSTEDİĞİNİZ İSLEMİ SECİNİZ");
		System.out.println("0 - Txten Veri Girişi Yap\n1 - Tüm Kargoları Listele\n2 - "
				+ "Kargo Girişi\n3 - Kargo Takip\n4 - Kargoyu Teslim Et\n5 - Çıkış");
		int islem = scan.nextInt();

		switch (islem) {
		case 0:
			kargo.txtkargoEkle();
			baslangic();
			break;
		case 1:
			kargo.listele();
			baslangic();
			break;
		case 2:
			kargo.kullaniciKargoEkle();
			baslangic();
			break;
		case 3:
			System.out.println("Takip Numarasını Giriniz");
			int tn = scan.nextInt();
			kargo.sorgula(tn);
			baslangic();
			break;
		case 4:
			System.out.println("Takip Numarasını Giriniz");
			tn = scan.nextInt();
			kargo.sil(tn);
			baslangic();
			break;
		case 5:
			System.out.println("Çıkış Yaptınız");
			break;	
		default:
			System.out.println("Geçerli bir işlem giriniz");
			baslangic();
			break;
		}
		
	}
	
	
	
}
