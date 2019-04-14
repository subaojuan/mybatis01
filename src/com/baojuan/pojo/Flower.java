package com.baojuan.pojo;

public class Flower {
private int id;
private String name;
private String price;
private int num;
public Flower() {
	super();
}
public Flower(int id, String name, String price, int num) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.num = num;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
@Override
public String toString() {
	return "Flower [id=" + id + ", name=" + name + ", price=" + price + ", num=" + num + "]";
}

}
