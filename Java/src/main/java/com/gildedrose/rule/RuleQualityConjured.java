package com.gildedrose.rule;

import com.gildedrose.Item;

public class RuleQualityConjured extends Rule {

    @Override
    public void updateQuality(Item item) {
        item.sellIn--;
        item.quality = decreaseQuality(item.quality, 2);
    }
}
