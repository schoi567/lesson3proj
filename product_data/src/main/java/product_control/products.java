package product_control;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="Product") 

public class products {
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;	
private String productname;
private String companyname;
 
public products() {super();}
public products(int id, String productname, String companyname) {super(); 
this.id = id;
this.productname = productname;
this.companyname = companyname;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
@Override
public String toString() {
	return "products [id=" + id + ", productname=" + productname + ", companyname=" + companyname + "]";
}




}
	

