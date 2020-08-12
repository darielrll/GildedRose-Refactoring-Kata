package com.gildedrose.rule;

import com.gildedrose.Item;

public class RuleQualityBackstage extends RuleQualityNotLegendaryItem{

    @Override
    public void updateQuality(Item item) {
        super.updateQuality(item);

        if(item.sellIn >= 11){
            return;
        }
        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }
        item.quality = increaseQuality(item.quality, 2);
        if (item.sellIn < 6) {
            item.quality = increaseQuality(item.quality, 2);
        }
    }

    private int increaseQuality(int quality, int count) {
        if(count == 0  ||  quality >= 50){
            return quality;
        }
        return increaseQuality(++quality, --count);
    }
}
