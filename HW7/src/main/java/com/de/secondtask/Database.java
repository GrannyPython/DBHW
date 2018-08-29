package com.de.secondtask;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Database {
    private static List<Seller> sellers = new LinkedList<>();

    static void init() {
        Product product0 = new Product(5, 1);
        Product product1 = new Product(2, 1);
        Product product2 = new Product(3, 1);
        Product product3 = new Product(4, 1);
        Product product4 = new Product(6, 1);
        Stream<Seller> sellerStream = Stream.of(Seller.builder().product(product0).product(product1).product(product2).build(), Seller.builder().product(product0).product(product1).product(product2).product(product3).product(product4).build(), Seller.builder().product(product0).product(product1).product(product2).product(product2).product(product2).build(), Seller.builder().product(product0).build());

        sellers = sellerStream.sorted(Comparator.comparing(Seller::findProfit)).collect(Collectors.toCollection(LinkedList::new));
    }

    public static List<Seller> findAllSellersFromBestToWorse() {
        if (sellers.isEmpty()) {
            init();
        }
        return sellers;
    }

}
