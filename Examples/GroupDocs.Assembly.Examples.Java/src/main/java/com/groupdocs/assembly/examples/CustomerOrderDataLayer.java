package com.groupdocs.assembly.examples;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.groupdocs.assembly.examples.CustomerOrderEntities.Customer;
import com.groupdocs.assembly.examples.CustomerOrderEntities.Order;
import com.groupdocs.assembly.examples.CustomerOrderEntities.Product;
import com.groupdocs.assembly.examples.CustomerOrderEntities.Service;
import com.groupdocs.assembly.system.data.DataRow;
import com.groupdocs.assembly.system.data.DataSet;
import com.groupdocs.assembly.system.data.DataTable;

//ExStart:CustomerOrderDataLayer
/**
 * The data layer of the GroupDocs.Assembly for .NET examples, ported to back the templates that
 * use the Customer / Order / Product model.
 *
 * NOTE: several .NET examples read their customers from Customers.json with Newtonsoft.Json, which
 * resolves the $id/$ref back-references between orders and customers. This project has no JSON
 * object mapper, so those examples use the same object graph built in code by
 * {@link #populateData()} instead.
 */
public class CustomerOrderDataLayer {

	/**
	 * Initializes customer, product and order information.
	 */
	public static Customer[] populateData() {
		Customer jane = new Customer("Jane Doe", "+9211874", "Flat # 1, Kiyani Plaza ISB", "123456789qwertyu0025");
		jane.Order = new Order[] {
				new Order(jane, new Product("Lumia 525"), 170, 5, date(2015, 1, 1),
						new Service("Regular Cleaning"), new Service("Oven Cleaning")) };

		Customer john = new Customer("John Smith", "+458789", "Quette House, Park Road, ISB", "123456789qwertyu0025");
		john.Order = new Order[] {
				new Order(john, new Product("Lenovo G50"), 480, 2, date(2015, 2, 1),
						new Service("Regular Cleaning"), new Service("Oven Cleaning"), new Service("Carpet Cleaning")),
				new Order(john, new Product("Pavilion G6"), 400, 1, date(2015, 10, 1),
						new Service("Regular Cleaning"), new Service("Carpet Cleaning")),
				new Order(john, new Product("Nexus 5"), 320, 3, date(2015, 6, 1),
						new Service("Oven Cleaning")) };

		return new Customer[] { jane, john };
	}

	/**
	 * Returns the orders of all customers.
	 */
	public static Order[] getOrdersData() {
		List<Order> orders = new ArrayList<Order>();
		for (Customer customer : populateData()) {
			for (Order order : customer.Order) {
				orders.add(order);
			}
		}
		return orders.toArray(new Order[orders.size()]);
	}

	/**
	 * Returns the products of all orders.
	 */
	public static Product[] getProductsData() {
		List<Product> products = new ArrayList<Product>();
		for (Order order : getOrdersData()) {
			products.add(order.Product);
		}
		return products.toArray(new Product[products.size()]);
	}

	/**
	 * Returns a single customer (the second one, as in the .NET examples).
	 */
	public static Customer getCustomerData() {
		return populateData()[1];
	}

	/**
	 * Loads customers, orders and products from XML files into a DataSet and relates the tables.
	 */
	public static DataSet getAllDataFromXml() throws Exception {
		DataSet dataSet = new DataSet();
		for (String file : new String[] { "Customers.xml", "Orders.xml", "ProductOrders.xml", "Products.xml" }) {
			dataSet.readXml(CommonUtilities.XMLDataFile + "/" + file);
		}

		DataTable customers = dataSet.getTables().get("Customers");
		DataTable orders = dataSet.getTables().get("Orders");
		DataTable productOrders = dataSet.getTables().get("ProductOrders");
		DataTable products = dataSet.getTables().get("Products");

		// NOTE: the .NET counterpart renames the "Products" table to "Product" here. The Java template
		// engine keeps resolving a renamed table by its original name only (see
		// LIBRARY-BUG-REPORTS.md), so the table keeps the name "Products".

		// The photo paths stored in Customers.xml are relative to the .NET build output folder;
		// point them at the local images folder instead.
		String photo = CommonUtilities.getImagePath("/no-photo.jpg");
		for (int i = 0; i < customers.getRows().getCount(); i++) {
			DataRow row = customers.getRows().get(i);
			row.set("Photo", photo);
		}

		// Define relations between the tables.
		dataSet.getRelations().add("Order_ProductOrders",
				orders.getColumns().get("OrderID"), productOrders.getColumns().get("OrderID"));
		dataSet.getRelations().add("Customer_Orders",
				customers.getColumns().get("CustomerID"), orders.getColumns().get("CustomerID"));
		dataSet.getRelations().add("Product_ProductOrders",
				products.getColumns().get("ProductID"), productOrders.getColumns().get("ProductID"));

		return dataSet;
	}

	private static Date date(int year, int month, int day) {
		return new GregorianCalendar(year, month - 1, day).getTime();
	}
}
//ExEnd:CustomerOrderDataLayer
