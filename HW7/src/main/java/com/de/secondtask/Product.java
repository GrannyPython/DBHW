package com.de.secondtask;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Product {
    int sellPrice;
    int buyPrice;
}
