package Model;

public class FlowerManager {
	private Flower[] flowers = new Flower[20];

    public FlowerManager() {
        Flower rose = new Flower();
        rose.setName("Rose");
        rose.setPrice(10.0);
        rose.setStock(100);

        Flower lily = new Flower();
        lily.setName("Lily");
        lily.setPrice(8.0);
        lily.setStock(96);

        Flower tulip = new Flower();
        tulip.setName("Tulip");
        tulip.setPrice(13.5);
        tulip.setStock(70);

        Flower daisy = new Flower();
        daisy.setName("Daisy");
        daisy.setPrice(1.0);
        daisy.setStock(600);
        
        Flower Daffodil = new Flower();
        Daffodil.setName("Daffodil");
        Daffodil.setPrice(1.0);
        Daffodil.setStock(600);
        
        Flower Poppy = new Flower();
        Poppy.setName("Poppy");
        Poppy.setPrice(10.0);
        Poppy.setStock(100);

        Flower Sunflower = new Flower();
        Sunflower.setName("Sunflower");
        Sunflower.setPrice(8.0);
        Sunflower.setStock(96);

        Flower Bluebell = new Flower();
        Bluebell.setName("Bluebell");
        Bluebell.setPrice(13.5);
        Bluebell.setStock(70);

        Flower Snowdrop = new Flower();
        Snowdrop.setName("Snowdrop");
        Snowdrop.setPrice(1.0);
        Snowdrop.setStock(600);
        
        Flower Cherryblossom = new Flower();
        Cherryblossom.setName("Cherry Blossom");
        Cherryblossom.setPrice(1.0);
        Cherryblossom.setStock(600);
        
        Flower Orchid = new Flower();
        Orchid.setName("Orchid");
        Orchid.setPrice(10.0);
        Orchid.setStock(100);

        Flower Iris = new Flower();
        Iris.setName("Iris");
        Iris.setPrice(8.0);
        Iris.setStock(96);

        Flower Peony = new Flower();
        Peony.setName("Peony");
        Peony.setPrice(13.5);
        Peony.setStock(70);

        Flower Chrysanthemum = new Flower();
        Chrysanthemum.setName("Chrysanthemum");
        Chrysanthemum.setPrice(1.0);
        Chrysanthemum.setStock(600);
        
        Flower Geranium = new Flower();
        Geranium.setName("Geranium");
        Geranium.setPrice(1.0);
        Geranium.setStock(600);
        
        Flower Lotus = new Flower();
        Lotus.setName("Lotus");
        Lotus.setPrice(10.0);
        Lotus.setStock(100);

        Flower Dandelion = new Flower();
        Dandelion.setName("Dandelion");
        Dandelion.setPrice(8.0);
        Dandelion.setStock(96);

        Flower Hyacinth = new Flower();
        Hyacinth.setName("Hyacinth");
        Hyacinth.setPrice(13.5);
        Hyacinth.setStock(70);

        Flower Crocus = new Flower();
        Crocus.setName("Crocus");
        Crocus.setPrice(1.0);
        Crocus.setStock(600);
        
        Flower Waterlily = new Flower();
        Waterlily.setName("Water Lily");
        Waterlily.setPrice(1.0);
        Waterlily.setStock(600);

        this.flowers[0] = rose;
        this.flowers[1] = lily;
        this.flowers[2] = tulip;
        this.flowers[3] = daisy;
        this.flowers[4] = Daffodil;
        this.flowers[5] = Poppy;
        this.flowers[6] = Sunflower;
        this.flowers[7] = Bluebell;
        this.flowers[8] = Snowdrop;
        this.flowers[9] = Cherryblossom;
        this.flowers[10] = Orchid;
        this.flowers[11] = Iris;
        this.flowers[12] = Peony;
        this.flowers[13] = Chrysanthemum;
        this.flowers[14] = Geranium;
        this.flowers[15] = Lotus;
        this.flowers[16] = Dandelion;
        this.flowers[17] = Hyacinth;
        this.flowers[18] = Crocus;
        this.flowers[19] = Waterlily;
    }

    public Flower getFlower(String name) {
        switch (name) {
            case "Rose":
                return this.flowers[0];
            case "lily":
                return this.flowers[1];
            case "Tulip":
                return this.flowers[2];
            case "daisy":
                return this.flowers[3];
            case "Daffodil":
                return this.flowers[4];
            case "Poppy":
                return this.flowers[5];
            case "Sunflower":
                return this.flowers[6];
            case "Bluebell":
                return this.flowers[7];
            case "Snowdrop":
                return this.flowers[8];
            case "Cherryblossom":
                return this.flowers[9];
            case "Orchid":
                return this.flowers[10];
            case "Iris":
                return this.flowers[11];
            case "Peony":
                return this.flowers[12];
            case "Chrysanthemum":
                return this.flowers[13];
            case "Geranium":
                return this.flowers[14];
            case "Lotus":
                return this.flowers[15];
            case "Dandelion":
                return this.flowers[16];
            case "Hyacinth":
                return this.flowers[17];
            case "Crocus":
                return this.flowers[18];
            case "Waterlily":
                return this.flowers[19];
            default:
                return this.flowers[0];
        }
    }

    public Flower[] getFlowers() {
        return this.flowers;
    }
}
