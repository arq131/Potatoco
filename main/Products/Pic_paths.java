package Products;

public class Pic_paths {
    public String[] pics = new String[1000];

    public String getPicPath(int i) {
        return pics[i];
    }
    public Pic_paths(){
        pics[0] = "main\\PICS\\ball.png";
    }
}
