
public class TestBooth {

	public static void main(String[] args) {
		
		Booth newBooth = new Booth(1, "booth1", 10, false);
		
        System.out.println(newBooth.toString());//��ǰ̯λ״̬
        
        Booth.purchase(newBooth, 100);//���������
        Booth.purchase(newBooth, 10);//����������
        
        newBooth.restock(201);//�������Σ���һ�ι��࣬�ڶ�������
        newBooth.restock(100);
        
        System.out.println(newBooth.toString());//������̯λ״̬
        
        Booth closeBooth = new Booth(1, "booth2", 10, true);
        Booth openBooth = new Booth(1, "booth3", 10, false);
        //������booth���Թر�̯λ����
        Booth[] boothArray = { newBooth, openBooth, closeBooth };
        Booth.closeBooths(boothArray);
		
	}

}