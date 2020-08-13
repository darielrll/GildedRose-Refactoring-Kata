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
            item.quality = increaseQuality(item.quality, 1);
        }
    }

    private boolean hasExpiredSellDate(Item item) {
        return item.sellIn < 0;
    }

    private int increaseQuality(int quality, int count) {
        if(count == 0  ||  quality >= 50){
            return quality;
        }
        return increaseQuality(++quality, --count);
    }
}
