public class ArticleGael {
    String name = "undefined";
    int quantity = 0;
    float unit_price = 0;
    float total_price = 0;
    public ArticleGael(String name, int quantity, float unit_price) {
        this.name = name;
        this.quantity = quantity;
        this.unit_price = unit_price;
        this.total_price = this.quantity*this.unit_price;
    }
}
