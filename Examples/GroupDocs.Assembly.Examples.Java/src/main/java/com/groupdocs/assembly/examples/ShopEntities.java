package com.groupdocs.assembly.examples;

import java.util.Calendar;
import java.util.Date;

//ExStart:ShopEntities
/**
 * Small data classes used by the template syntax and dynamic insertion examples.
 */
public class ShopEntities {

	/**
	 * A product whose description and note are HTML fragments.
	 */
	public static class ProductInfo {
		private final String name;
		private final String description;
		private final String note;

		public ProductInfo(String name, String description, String note) {
			this.name = name;
			this.description = description;
			this.note = note;
		}

		public String getName() {
			return name;
		}

		public String getDescription() {
			return description;
		}

		public String getNote() {
			return note;
		}
	}

	/**
	 * A product with the path of its photo.
	 */
	public static class ProductPhoto {
		private final String name;
		private final String photo;

		public ProductPhoto(String name, String photo) {
			this.name = name;
			this.photo = photo;
		}

		public String getName() {
			return name;
		}

		public String getPhoto() {
			return photo;
		}
	}

	/**
	 * An order status with its color as a hex string or a color name.
	 */
	public static class OrderStatus {
		private final String name;
		private final String color;

		public OrderStatus(String name, String color) {
			this.name = name;
			this.color = color;
		}

		public String getName() {
			return name;
		}

		public String getColor() {
			return color;
		}
	}

	/**
	 * An order whose values are formatted in a template.
	 */
	public static class OrderInfo {
		private final String customer;
		private final Date date;
		private final double total;
		private final int items;
		private final int visit;
		private final int code;
		private final String note;

		public OrderInfo(String customer, Date date, double total, int items, int visit, int code, String note) {
			this.customer = customer;
			this.date = date;
			this.total = total;
			this.items = items;
			this.visit = visit;
			this.code = code;
			this.note = note;
		}

		public String getCustomer() {
			return customer;
		}

		public Date getDate() {
			return date;
		}

		/**
		 * The delivery date, three days after the order date. A .NET template computes it with
		 * DateTime.AddDays; java.util.Date has no such method, so it comes from the data here.
		 */
		public Date getDeliveryDate() {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, 3);
			return calendar.getTime();
		}

		public double getTotal() {
			return total;
		}

		public int getItems() {
			return items;
		}

		public int getVisit() {
			return visit;
		}

		public int getCode() {
			return code;
		}

		public String getNote() {
			return note;
		}
	}

	/**
	 * An order line. The price is a double: the template multiplies it and compares the result, and
	 * the engine does not apply arithmetic or comparison operators to BigDecimal (see
	 * LIBRARY-BUG-REPORTS.md, bug 15).
	 */
	public static class OrderLine {
		private final int number;
		private final double price;
		private final int quantity;

		public OrderLine(int number, double price, int quantity) {
			this.number = number;
			this.price = price;
			this.quantity = quantity;
		}

		public int getNumber() {
			return number;
		}

		public double getPrice() {
			return price;
		}

		public int getQuantity() {
			return quantity;
		}
	}
}
//ExEnd:ShopEntities
