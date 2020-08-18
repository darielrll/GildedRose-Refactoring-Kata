package com.gildedrose.item;

import com.gildedrose.Item;

public class ItemProxy {
    private Item item;

    public ItemProxy(Item item) {
        this.item = item;
    }

    public void decreaseSellIn() {
        item.sellIn--;
    }

    public void decreaseQualityIn(int count) {
        if(item.quality < count){
            item.quality = 0;
        }
        else {
            item.quality -= count;
        }
    }

    public boolean hasExpiredSellDate() {
        return item.sellIn < 0;
    }

    public void increaseQuality(int count) {
        item.quality += count;
        if(item.quality > 50){
            item.quality = 50;
        }
    }

    public boolean lessThanNDaysLeftToSell(int days) {
        return item.sellIn < days;
    }
}
