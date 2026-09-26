package com.groupdocs.assembly.examples;

import java.util.Date;

//ExStart:CustomerOrderEntities
/**
 * The Customer / Order / Product data model of the GroupDocs.Assembly for .NET examples, ported so
 * that the templates of those examples can be reused.
 *
 * The .NET templates address this model through member access, e.g. {@code Customer.CustomerName}.
 * The Java template engine resolves such an expression against a public field, so the members are
 * exposed as public fields named exactly like the .NET properties. Collections are arrays rather
 * than generic lists, because an array keeps its element type at run time and a generic list does
 * not, and the engine needs the element type to resolve members of the items.
 */
public class CustomerOrderEntities {

	public static class Customer {
		public String CustomerName;
		public String ShippingAddress;
		public String CustomerContactNumber;
		public Order[] Order;
		public String Barcode;
		public String Photo;
		public String Document;
		public String Color;

		public Customer(String customerName, String customerContactNumber, String shippingAddress, String barcode) {
			CustomerName = customerName;
			CustomerContactNumber = customerContactNumber;
			ShippingAddress = shippingAddress;
			Barcode = barcode;

			// Computed properties in .NET; resolved once here.
			try {
				Photo = CommonUtilities.getImagePath("/no-photo.jpg");
				Document = CommonUtilities.getOuterDoc("/OuterDoc.docx");
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
	}

	public static class Order {
		public Customer Customer;
		public Product Product;
		public int ProductQuantity;
		public int Price;
		public String Barcode;
		public Date OrderDate;
		public int OrderNumber;
		public Date ShippingDate;
		public Service[] Services;

		public Order(Customer customer, Product product, int price, int productQuantity, Date orderDate,
				Service... services) {
			Customer = customer;
			Product = product;
			Price = price;
			ProductQuantity = productQuantity;
			OrderDate = orderDate;
			Services = services;
		}
	}

	public static class Product {
		public String ProductName;
		public int UnitInStock;
		public int Discount;
		public String ProductPrice;

		public Product(String productName) {
			ProductName = productName;
		}
	}

	public static class Service {
		public String ServiceName;

		public Service(String serviceName) {
			ServiceName = serviceName;
		}
	}
}
//ExEnd:CustomerOrderEntities
