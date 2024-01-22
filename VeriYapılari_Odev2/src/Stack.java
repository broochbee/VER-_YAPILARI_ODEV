
public class Stack {

	int cnt = 0;
	Node top = null;
	
	
	void push (char data) 		//yığına ekleme fonksiyonu eğer yığın boş yap. Değilse başa ekle
	{
		Node harf = new Node(data);
		if(!isFull())
		{
			if(isEmpty())
			 {
				 top = harf;
				 cnt++;
			 }
			 else
			 {
				 harf.next = top;
				 top.prev = harf;
				 top = harf;
				 cnt++;
			 }
		} 
	}
	
	void pop()					//Yığından çıkarma fonksiyonu
	{
		if(isEmpty())
		{
			System.out.println("Çıkacak eleman yok!");
		}
		else 
		{
			top = top.next;
			top.prev = null;
			cnt--;
		}
	}
	boolean isFull()			//yıgının doluluğunu kontrol etme eleman sayısı ile
	{
		return cnt==6;
	}
	
	boolean isEmpty() 			//yıgının boş olup olmadığına bakma
	{
		return cnt == 0;
	}
	void print() 				// elemanlarda gezerek yıgını yazdırma
	{
		Node temp = top;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
