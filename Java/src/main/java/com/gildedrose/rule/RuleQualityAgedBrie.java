package com.gildedrose.rule;

import com.gildedrose.Item;

public class RuleQualityAgedBrie extends RuleQualityNotLegendaryItem{

    @Override
    public void updateQuality(Item item) {
        super.updateQuality(item);

        if (hasExpiredSellDate(item)) {
            item.quality = increaseQuality(item.quality, 2);
        }
        else {
            item.quality = increaseQuality(item.quality, 1  );
        }
    }
}
