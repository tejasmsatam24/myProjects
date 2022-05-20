package z1828205.cs.niu.Assignment05;

public class Item {
    private int id;
    private String item;

    public Item(int id, String item) {
        this.id = id;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setList(String item) {
        this.item = item;
    }

    public String listToString() {
        return id + " " + item;
    }

}//end of Item Class
