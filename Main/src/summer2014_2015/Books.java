package summer2014_2015;

public class Books {
	String Title;
	String Author;
	int  Rating;
	int Price;
	int Quantity;
	public Books(String t,String a,int r,int p,int q){
		Title = t;
		Author = a;
		Rating = r;
		Price = p;
		Quantity = q;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String toString(){
		return Title+"\n"+Author+"\n"+Rating+"\n"+Price+"\n"+Quantity;
	}
	public String dc(){
		return "Title: "+Title+"\n"+" Author: "+Author+"\n"+" Rating: "+Rating+"\n"+" Price: "+Price;
	}
}
