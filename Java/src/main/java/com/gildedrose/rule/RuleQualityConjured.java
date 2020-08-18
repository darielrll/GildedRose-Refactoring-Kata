package com.gildedrose.rule;

import com.gildedrose.item.ItemProxy;

public class RuleQualityConjured extends Rule {

    @Override
    protected void updateQuality(ItemProxy item) {
        item.decreaseSellIn();
        item.decreaseQualityIn(2);
    }
}
