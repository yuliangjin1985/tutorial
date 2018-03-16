package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob8;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
	List<Optional<OrderItem>> orderItems = new ArrayList<>();
	public static void main(String[] args) {
		Main m = new Main();
		m.loadOrderItemData();
		System.out.println("Do any of these Order Items have an order of flowers? " + 
		   m.findProduct("Flowers"));
	}
	
	private boolean findProduct(String prodName) {


//		for(OrderItem item : orderItems) {
//			if(item != null) {
//				Product p=item.getProduct();
//				if(p != null) {
//					String name = p.getProductName();
//					if(name != null) {
//						if(name.equals(prodName)) return true;
//					}
//				}
//			}
//		}
//		return false;

		for (Optional<OrderItem> item : orderItems) {
			if (item.flatMap(i-> Optional.ofNullable(i.getProduct()))
                    .flatMap(product -> product.get().getProductName())
					.orElse("")
					.equals(prodName)
					) {
				return true;
			}
		}
		return false;
	}
	
	private void loadOrderItemData() {
		orderItems.add(Optional.empty());
//		orderItems.add(Optional.of(new OrderItem(null, 3)));//This will still throw NPI.
		orderItems.add(Optional.of(new OrderItem(new Product("1015", "", 131.00), 3)));
		orderItems.add(Optional.of(new OrderItem(new Product("1016", "Tools", 131.00), 3)));
		orderItems.add(Optional.of(new OrderItem(new Product("1017", "Fishing Rod", 111.00), 1)));
		orderItems.add(Optional.of(new OrderItem(new Product("1018", "Game of Go",66.00), 2)));
		orderItems.add(Optional.of(new OrderItem(new Product("1019", "Flowers", 221.00), 5)));
	}
}
