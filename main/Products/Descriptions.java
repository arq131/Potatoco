package Products;

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
    }
}
