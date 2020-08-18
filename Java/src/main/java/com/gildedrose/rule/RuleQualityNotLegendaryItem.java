package com.gildedrose.rule;

import com.gildedrose.item.ItemProxy;

public class RuleQualityNotLegendaryItem extends Rule{

    @Override
    protected void updateQuality(ItemProxy item) {
        item.decreaseSellIn();
    }
}
