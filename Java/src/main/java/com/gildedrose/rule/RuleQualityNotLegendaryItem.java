package com.gildedrose.rule;

import com.gildedrose.Item;

public class RuleQualityNotLegendaryItem extends Rule{

    @Override
    public void updateQuality(Item item) {
        item.sellIn--;
    }
}
