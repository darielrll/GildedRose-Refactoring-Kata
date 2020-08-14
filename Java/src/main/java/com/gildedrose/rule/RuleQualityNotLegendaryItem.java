package com.gildedrose.rule;

import com.gildedrose.Item;

public class RuleQualityNotLegendaryItem extends Rule{

    @Override
    public void updateQuality(Item item) {
        item.sellIn--;
    }

    protected boolean hasExpiredSellDate(Item item) {
        return item.sellIn < 0;
    }

    protected int increaseQuality(int quality, int count) {
        if(count == 0  ||  quality >= 50){
            return quality;
        }
        return increaseQuality(++quality, --count);
    }
}
