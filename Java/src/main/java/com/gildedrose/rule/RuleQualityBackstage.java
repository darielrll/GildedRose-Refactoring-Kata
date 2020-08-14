package com.gildedrose.rule;

import com.gildedrose.Item;

public class RuleQualityBackstage extends RuleQualityNotLegendaryItem {

    @Override
    public void updateQuality(Item item) {
        super.updateQuality(item);

        if (hasExpiredSellDate(item)) {
            item.quality = 0;
            return;
        }
        if (lessThan5DaysLeft(item)) {
            item.quality = increaseQuality(item.quality, 3);
            return;
        }
        if (lessThan11DaysLeft(item)) {
            item.quality = increaseQuality(item.quality, 2);
        }
    }

    private boolean lessThan11DaysLeft(Item item) {
        return item.sellIn < 11;
    }

    private boolean lessThan5DaysLeft(Item item) {
        return item.sellIn < 6;
    }
}
