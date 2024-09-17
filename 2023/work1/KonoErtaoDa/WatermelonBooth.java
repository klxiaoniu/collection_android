package Practice;

public class WatermelonBooth {
    private long id; // ̯��
    private String name; // ̯������
    private int total; // ����������
    private boolean isClosed; // �Ƿ���̯����

    // ���췽��
    public WatermelonBooth(long id, String name, int total, boolean isClosed) {
        this.id = id;
        this.name = name;
        this.total = total;
        this.isClosed = isClosed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    // ��д�� toString() ����
    @Override
    public String toString() {
        return String.format("̯��: %d, ̯������: %s, ����������: %d, �Ƿ���̯����: %b", id, name, total, isClosed);
    }

    // ��̬���� purchase
    public static void purchase(WatermelonBooth seller, int buyAmount) {
        if (buyAmount <= 0) {
            System.out.println("����ʧ�ܣ����������������Ϊ������");
        }
        else if (seller.getIsClosed()) {
            System.out.println("����ʧ�ܣ��̼Ҵ�����̯����״̬��");
        }
        else if (buyAmount > seller.getTotal()) {
            System.out.println("����ʧ�ܣ���������������������������");
        }
        else {
            seller.setTotal(seller.getTotal() - buyAmount);
            System.out.println("����ɹ����ѹ�����������" + buyAmount);
        }
    }

    // ʵ������ restock
    public void restock(int stockAmount) {
        if (stockAmount > 200) {
            System.out.println("����ʧ�ܣ����ν��������ܳ���200��");
            return;
        }
        this.total += stockAmount;
        System.out.println("�����ɹ�����ǰ������������" + this.total);
    }

    // ��̬���� closeBooths
    public static void closeBooths(WatermelonBooth[] booths) {
        for (WatermelonBooth booth : booths) {
            if (!booth.getIsClosed()) {
                booth.setIsClosed(true);
                System.out.println("�ѽ�̯λ��ҵ���ģ�" + booth);
            }
        }
    }
}


class test {
    public static void main(String[] args) {
        // �������� WatermelonBooth ʵ��
        WatermelonBooth booth1 = new WatermelonBooth(101, "����", 50, false);
        WatermelonBooth booth2 = new WatermelonBooth(102, "����", 80, false);
        WatermelonBooth booth3 = new WatermelonBooth(103, "����", 30, true);

        // ���� getter �� setter
        System.out.println("booth1̯�ţ�ԭʼ): " + booth1.getId());
        booth1.setId(100);
        System.out.println("booth1̯�ţ����º�): " + booth1.getId());

        System.out.println("booth1̯��������ԭʼ): " + booth1.getName());
        booth1.setName("����");
        System.out.println("booth1̯�����������º�): " + booth1.getName());

        System.out.println("booth1������������ԭʼ): " + booth1.getTotal());
        booth1.setTotal(60);
        System.out.println("booth1���������������º�): " + booth1.getTotal());

        System.out.println("booth1�Ƿ���̯���ģ�ԭʼ): " + booth1.getIsClosed());
        booth1.setIsClosed(true);
        System.out.println("booth1�Ƿ���̯���ģ����º�): " + booth1.getIsClosed());
        booth1.setIsClosed(false);

        // ���� toString ����
        System.out.println("booth1��Ϣ: " + booth1);

        // ���� purchase ����
        WatermelonBooth.purchase(booth1, 10);
        WatermelonBooth.purchase(booth3, 5);
        WatermelonBooth.purchase(booth1, -5);
        WatermelonBooth.purchase(booth1, 100);
        WatermelonBooth.purchase(booth1, 40);

        // ���� restock ����
        booth2.restock(150);
        booth2.restock(250);

        // �������̯λ��Ϣ
        System.out.println("����̯λ��Ϣ��");
        System.out.println(booth1);
        System.out.println(booth2);
        System.out.println(booth3);

        // ���� closeBooths ����
        WatermelonBooth.closeBooths(new WatermelonBooth[]{booth1, booth2, booth3});

        // �ٴ��������̯λ��Ϣ��ȷ�Ϲرղ���
        System.out.println("̯λ�رպ����Ϣ��");
        System.out.println(booth1);
        System.out.println(booth2);
        System.out.println(booth3);
    }
}