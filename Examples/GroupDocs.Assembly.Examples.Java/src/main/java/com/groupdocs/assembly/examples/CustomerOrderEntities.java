package com.groupdocs.assembly.examples;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

//ExStart:CustomerOrderEntities
/**
 * The Customer / Order / Product data model of the GroupDocs.Assembly for .NET examples, ported so
 * that the templates of those examples can be reused.
 *
 * The .NET templates address this model through member access, e.g. {@code Customer.CustomerName}.
 * The Java template engine resolves such an expression against the JavaBean getter, here
 * {@code getCustomer().getCustomerName()}, so the model is a set of plain beans.
 * Feature is supported by version 26.10.1 or greater
 */
public class CustomerOrderEntities {

	public static class Customer {
		private String customerName;
		private String shippingAddress;
		private String customerContactNumber;
		private List<Order> order;
		private String barcode;
		private String color;

		public Customer(String customerName, String customerContactNumber, String shippingAddress, String barcode) {
			this.customerName = customerName;
			this.customerContactNumber = customerContactNumber;
			this.shippingAddress = shippingAddress;
			this.barcode = barcode;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getShippingAddress() {
			return shippingAddress;
		}

		public void setShippingAddress(String shippingAddress) {
			this.shippingAddress = shippingAddress;
		}

		public String getCustomerContactNumber() {
			return customerContactNumber;
		}

		public void setCustomerContactNumber(String customerContactNumber) {
			this.customerContactNumber = customerContactNumber;
		}

		public List<Order> getOrder() {
			return order;
		}

		public void setOrder(List<Order> order) {
			this.order = order;
		}

		public String getBarcode() {
			return barcode;
		}

		public void setBarcode(String barcode) {
			this.barcode = barcode;
		}

		public String getPhoto() throws Exception {
			return CommonUtilities.getImagePath("/no-photo.jpg");
		}

		public String getDocument() throws Exception {
			return CommonUtilities.getOuterDoc("/OuterDoc.docx");
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
	}

	public static class Order {
		private Customer customer;
		private Product product;
		private int productQuantity;
		private int price;
		private String barcode;
		private Date orderDate;
		private int orderNumber;
		private Date shippingDate;
		private List<Service> services;

		public Order(Customer customer, Product product, int price, int productQuantity, Date orderDate,
				Service... services) {
			this.customer = customer;
			this.product = product;
			this.price = price;
			this.productQuantity = productQuantity;
			this.orderDate = orderDate;
			this.services = Arrays.asList(services);
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public int getProductQuantity() {
			return productQuantity;
		}

		public void setProductQuantity(int productQuantity) {
			this.productQuantity = productQuantity;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getBarcode() {
			return barcode;
		}

		public void setBarcode(String barcode) {
			this.barcode = barcode;
		}

		public Date getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}

		public int getOrderNumber() {
			return orderNumber;
		}

		public void setOrderNumber(int orderNumber) {
			this.orderNumber = orderNumber;
		}

		public Date getShippingDate() {
			return shippingDate;
		}

		public void setShippingDate(Date shippingDate) {
			this.shippingDate = shippingDate;
		}

		public List<Service> getServices() {
			return services;
		}

		public void setServices(List<Service> services) {
			this.services = services;
		}
	}

	public static class Product {
		private String productName;
		private int unitInStock;
		private int discount;
		private String productPrice;

		public Product(String productName) {
			this.productName = productName;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public int getUnitInStock() {
			return unitInStock;
		}

		public void setUnitInStock(int unitInStock) {
			this.unitInStock = unitInStock;
		}

		public int getDiscount() {
			return discount;
		}

		public void setDiscount(int discount) {
			this.discount = discount;
		}

		public String getProductPrice() {
			return productPrice;
		}

		public void setProductPrice(String productPrice) {
			this.productPrice = productPrice;
		}
	}

	public static class Service {
		private String serviceName;

		public Service(String serviceName) {
			this.serviceName = serviceName;
		}

		public String getServiceName() {
			return serviceName;
		}

		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}
	}
}
//ExEnd:CustomerOrderEntities
