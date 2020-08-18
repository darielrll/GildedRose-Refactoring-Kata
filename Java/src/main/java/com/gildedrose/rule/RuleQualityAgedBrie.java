package com.gildedrose.rule;

import com.gildedrose.item.ItemProxy;

public class RuleQualityAgedBrie extends RuleQualityNotLegendaryItem{

    @Override
    protected void updateQuality(ItemProxy item) {
        super.updateQuality(item);

        if (item.hasExpiredSellDate()) {
            item.increaseQuality(2);
        }
        else {
            item.increaseQuality(1 );
        }
    }
}
