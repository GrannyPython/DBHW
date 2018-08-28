package com.de.secondtask;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.ToString;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public class Seller {
    @Singular("product")
    private List<Product> productList;

    public long findProfit() {
        IntSummaryStatistics statistics = productList.stream().map(product -> product.sellPrice - product.buyPrice).collect(Collectors.summarizingInt(w -> w));
        return statistics.getSum();
    }

    @Override
    public String toString() {
        return "Seller profit = " + this.findProfit();
    }
}
