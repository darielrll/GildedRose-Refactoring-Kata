package com.gildedrose.rule;

import com.gildedrose.Item;

public class RuleQualityUnknown extends RuleQualityNotLegendaryItem{

    @Override
    public void updateQuality(Item item) {
        super.updateQuality(item);

        if (hasExpiredSellDate(item)) {
            item.quality = decreaseQuality(item.quality, 2);
        }
        else {
            item.quality = decreaseQuality(item.quality, 1);
        }
    }
}
