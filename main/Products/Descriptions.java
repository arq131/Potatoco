package Products;

public class Descriptions {
    public String[] descriptions = new String[1000];

    public String getDescription(int i) {
        return descriptions[i];
    }
    public Descriptions(){
        descriptions[0] = "If you want to know the answer to questions like: 'will I get that job as a potato farmer'\n" +
                " or 'Does she like sweet potatoes?' well the 8-potato fortune teller is here";
    }
}
