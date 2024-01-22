import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Liste {
	Scanner input = new Scanner(System.in);

	Node head = null;
	Node tail = null;		

	void add ( int x, String y, String z ) {

		Node student = new Node();

		student.number = x;
		student.name = y;
		student.surname = z;
		student.next = null;

		if(head == null)	
		{
			head = student;
			tail = student;
		}
		else	
		{
			tail.next = student;
			tail = student;
		}	
	}



	void listeleme() 
	{
		if(head == null) 
		{
			System.out.println("Listeniz boş!!");
		}
		else 
		{
			Node temp = head;
			while (temp != null) 
			{
				System.out.println(temp.number +" - "+ temp.name +" "+temp.surname);
				temp = temp.next;
			}
		}
		main.baslangic();
	}




	void ekleme( int x, String y, String z)
	{
		Node student = new Node();
		student.number = x;
		student.name = y;
		student.surname = z;

		Node temp = head;


		while(temp.next != null) 
		{
			temp = temp.next;
			if(temp.number == x) 
			{
				System.out.println("Eklemek istediğiniz numarada bir öğrenci kayıtlı!");
				break;
			}	
		}
		
		student.next = null;
		tail.next = student;
		tail = student;
		System.out.println("Başarı ile eklendi");
		main.baslangic();
	}



	void arama(String z) 
	{

		Node temp = head;

		while(temp != null) 
		{

			if(temp.surname.equals(z)) 
			{
				System.out.println(temp.number +"-"+ temp.name + temp.surname);
				System.out.println("Aradığınız öğrenciyi buldunuz mu? (e/h)");
				String arama = input.nextLine();
				if(arama.equals("e")) 
				{
					System.out.println("Öğrenci bulundu");
					main.baslangic();
					return;
				}
				else if(!arama.equals("h"))
				{
					System.out.println("Hatalı ifade girişi !!");
					break;
				}
					
				
			}
			
			temp = temp.next;
		}
		System.out.println("Öğrenci bulunamadı");
		
		main.baslangic();
	}

	
	
	void sil(int x) 
	{
		Node temp = head;
		Node temp2;
		boolean sil=false;

			if(head == null) 
			{
				System.out.println("Liste boş silinecek öğrenci yok !!");
				sil=true;
			}
			else
			{
				if(x==head.number && head.next== null)//Tek eleman ise
				{
					head = null;
					tail = null;
					sil=true;
				}
				else if(x == head.number && head.next != null)//İlk eleman silme
				{
					head = head.next;
					sil=true;
				}
				else
				{
					temp = head;
					temp2 = head;
					while(temp.next != null) {//aradan silme
						if(x == temp.number)
						{
							temp2.next = temp.next;
							sil=true;
						}
						temp2 = temp;
						temp = temp.next;
					}
					if(x == temp.number)//son eleman silme
					{
						temp2.next = null;
						tail = temp2;
						sil=true;
					}
			}
			}
		if(sil==false) 
		{
			System.out.println("Silmek istediğiniz numara listede yok");
		}else
		{
			System.out.println("Öğrenci başarı ile silindi");
		}
		main.baslangic();
		}
	
	
	
	
	void tası( int x, int y) 
	{
		
		Node temp = head;
		Node temp2;
		Node ogr = new Node();
		int boyut=0;
		
		
		if(head == null) 
		{
			System.out.println("Liste boş taşınacak öğrenci yok !!");
			
		}
		else
		{
			if(x==head.number && head.next== null)
			{
				listeleme();
				return;
				
			}
			else if(x == head.number && head.next != null)//baştaki elemanı silme
			{
				ogr = head;
				head = head.next;
				
			}
			else
			{
				temp = head;
				temp2 = head;
				while(temp.next != null) {
					boyut++;
					if(x == temp.number)
					{
						ogr = temp;
						temp2.next = temp.next;
						
					}
					temp2 = temp;
					temp = temp.next;
				}
				if(x == temp.number)
				{
					ogr = tail;
					temp2.next = null;
					tail = temp2;	
				}
		}
		
		if(y<=boyut+1) {
		/////////////////////////////////

			ogr = temp;
			temp = head;
			Node back = null;
			int i = 1;
			
			if(y==boyut) {
				tail.next = ogr;
				tail = ogr;
				tail.next = null;
				
			} else 
			{
				while(temp!=null) 
				{
					if(i == y) 
					{
						if(back==null) 
						{
							ogr.next = head;
							head = ogr;
						} 
						else 
						{
							ogr.next = temp;
							back.next = ogr;
						}
						if(y == boyut)
						{
							tail = ogr;
						}
						break;
					}
					back = temp;
					temp = temp.next;
					i++;
				}
			}
			listeleme();
		}
		else {
			System.out.println("Listeden büyük değer girdiniz!");
		}
		
		main.baslangic();
	}}}	
	

