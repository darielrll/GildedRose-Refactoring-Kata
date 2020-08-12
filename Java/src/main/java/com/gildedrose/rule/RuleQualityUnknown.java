package com.gildedrose.rule;

import com.gildedrose.Item;

public class RuleQualityUnknown extends RuleQualityNotLegendaryItem{

    @Override
    public void updateQuality(Item item) {
        super.updateQuality(item);

        if (item.sellIn < 0) {
            item.quality = decreaseQuality(item.quality);
        }
        item.quality = decreaseQuality(item.quality);
    }

    private int decreaseQuality(int quality) {
        return quality > 0 ? quality - 1 : quality;
    }
}
