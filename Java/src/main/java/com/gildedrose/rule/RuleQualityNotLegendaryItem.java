package com.gildedrose.rule;

import com.gildedrose.Item;

public class RuleQualityNotLegendaryItem extends Rule{

    @Override
    public void updateQuality(Item item) {
        item.sellIn--;
    }

    protected int decreaseQuality(int quality) {
        return quality > 0 ? quality - 1 : quality;
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
