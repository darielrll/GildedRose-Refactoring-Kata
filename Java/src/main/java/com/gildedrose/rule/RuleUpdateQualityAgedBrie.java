package com.gildedrose.rule;

import com.gildedrose.Item;

public class RuleUpdateQualityAgedBrie extends RuleQualityNotLegendaryItem{

    @Override
    public void updateQuality(Item item) {
        super.updateQuality(item);

        if (item.quality < 49) {
            item.quality++;
        }
        if (item.sellIn < 0) {
            item.quality++;
        }
    }
}
