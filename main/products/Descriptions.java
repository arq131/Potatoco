package products;

import java.util.Random;

public class Descriptions {
	private static Descriptions single_instance=null;
	
    public String[] names = new String[1000];
    public String[] pics = new String[1000];
    public String[] descriptions = new String[1000];
    public double[] cost = new double[2];

    public String getName(int i) {
        return names[i];
    }

    public String getPic(int i) {
        return pics[i];
    }

    public String getDescription(int i) {
        return descriptions[i];
    }
    
    public double getCost(int i) {
    	return cost[i];
    }
    public Descriptions(){
        names[0] = "Fortune 8-Potato";
        pics[0] = "pictures/ball.png";
        descriptions[0] = "If you want to know the answer to questions like: 'will I get that job as a potato farmer'\n" +
                " or 'Does she like sweet potatoes?' well the 8-potato fortune teller is here";
        names[1] = "Potatogram";
        pics[1] = "pictures/Potatogram.jpg";
        descriptions[1] = "Have you ever wanted to send a message to someone in a meaningful way but mail,\n" +
                " email and text messaging feels too bland and without enough potatos? well here comes the\n" +
                " Potatogram. Personalize your message and show your love for potatos at the same time";
        names[2] = "Potato Leggins";
        pics[2] = "pictures/potato_legging.jpg";
        descriptions[2] = "Do you want to look great for your potato-locing significant other; pr dp you just want to feel confortable"
        		+ "as you let your love for potatoes hug your legs? well potato leggings are here";
        names[3] = "Potato Emoji Stickers";
        pics[3] = "pictures/potato_emojis.jpg";
        descriptions[3] = "Express your mood as you proclaim your fascination for potatoes with this adorable potato emoji stickers ";
        names[4] = "I-potato Case";
        pics[4] = "pictures/Iphone_case.jpg";
        descriptions[4] = " ";
        //Random r = new Random();
        cost[0] = 8.55;
        cost[1] = 7.35;
    }
}
