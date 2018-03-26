package products;

public class Descriptions {
    public String[] names = new String[1000];
    public String[] pics = new String[1000];
    public String[] descriptions = new String[1000];

    public String getName(int i) {
        return names[i];
    }

    public String getPic(int i) {
        return pics[i];
    }

    public String getDescription(int i) {
        return descriptions[i];
    }
    public Descriptions(){
        names[0] = "Fortune 8-Potato";
        pics[0] = "main\\PICS\\ball.png";
        descriptions[0] = "If you want to know the answer to questions like: 'will I get that job as a potato farmer'\n" +
                " or 'Does she like sweet potatoes?' well the 8-potato fortune teller is here";
        names[1] = "Pugtato shirt";
        pics[1] = "main\\PICS\\pugtato_shirt.jpg";
        descriptions[1] = "When you love pugs but you also love potatoes here is a\n" +
                "shirt that expresses your love for both";
        names[2] = "Potatogram";
        pics[2] = "main\\PICS\\Potatogram.jpg";
        descriptions[2] = "Have you ever wanted to send a message to someone in a meaningful way but mail,\n" +
                " email and text messaging feels too bland and without enough potatos? well here comes the\n" +
                " Potatogram. Personalize your message and show your love for potatos at the same time";
    }
}
