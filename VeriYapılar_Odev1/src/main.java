import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {
	static Liste liste = new Liste();

	public static void main(String[] args) throws IOException {

		File file = new File("dosya.txt");
		if(!file.exists()) {
			System.out.println("Dosya bulunamadı!");
		}
			

			FileReader freader = new FileReader(file);
			String line;

			BufferedReader breader = new BufferedReader(freader);

			while ((line = breader.readLine()) != null ) {
				int ilkIndeks = line.indexOf("#");
				int ikinciIndeks = line.indexOf("#", ilkIndeks + 1);

				int no = Integer.parseInt(line.substring(0, ilkIndeks));
				String ad = line.substring(ilkIndeks + 1, ikinciIndeks);
				String soyad = line.substring(ikinciIndeks + 1);
				liste.add(no, ad, soyad);
			} 
			
			baslangic();

	}
	public static void baslangic() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("####################\n"
					+ "1. Listeleme\r\n"
					+ "2. Ekleme\r\n"
					+ "3. Arama\r\n"
					+ "4. Silme\r\n"
					+ "5. Taşıma\r\n"
					+ "6. Çıkış");
			System.out.println("Lütfen yapmak istediğiniz işlemin numarasını yazınız:");
			int islem = input.nextInt();

			switch (islem) {
			case 1:
				liste.listeleme();
				break;
				
			case 2:
				System.out.print("Eklemek istediğiniz öğrencinin numarasını giriniz :");
				int num = input.nextInt();
				input.nextLine();
				
				System.out.println("Eklemek istediğiniz öğrencinin adını giriniz :");
				String ad = input.nextLine();
				
				System.out.print("Eklemek istediğiniz öğrencinin soyadını giriniz :");
				String soyad = input.nextLine();
				
				liste.ekleme(num,ad,soyad);
				break;
				
			case 3:
				System.out.println("Aradığınız öğrencinin soyismini giriniz :");
				String soyisim = input.next();
				liste.arama(soyisim);
				break;
				
			case 4:
				System.out.print("Silmek istediğiniz öğrencinin numarasını giriniz :");
				num = input.nextInt();
				liste.sil(num);
				break;
				
			case 5:
				System.out.println("Taşımak istediğiniz öğrencinin numarasını giriniz :");
				num = input.nextInt();
				System.out.println("Hangi sıraya taşımak istersiniz :");
				int yer = input.nextInt();
				liste.tası(num,yer);
				break;
				
			case 6:
				System.out.println("Listenin son hali txt dosyasına kaydedilmiştir");
				cikis();
				break;

			default:
				break;
			}
		}
	}
	
	
	static void cikis() 
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("dosya.txt"))) {
            Node temp = liste.head;
            while (temp != null) {
                writer.write((temp.number +"#"+ temp.name +"#"+ temp.surname));
                writer.newLine();
                temp = temp.next;
            }
            System.out.println("Bağlı liste dosyaya yazıldı.");
        } catch (IOException e) {
            System.out.println("Dosya yazma hatası: " + e.getMessage());
        }
	}

}
