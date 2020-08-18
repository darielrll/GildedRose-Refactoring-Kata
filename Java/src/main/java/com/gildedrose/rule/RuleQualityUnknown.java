package com.gildedrose.rule;

import com.gildedrose.item.ItemProxy;

public class RuleQualityUnknown extends RuleQualityNotLegendaryItem{

    @Override
    protected void updateQuality(ItemProxy item) {
        super.updateQuality(item);

        if (item.hasExpiredSellDate()) {
            item.decreaseQualityIn(2);
        }
        else {
            item.decreaseQualityIn(1);
        }
    }
}
