package com.gildedrose.rule;

import com.gildedrose.Item;

public abstract class Rule {
    public abstract void updateQuality(Item item);

    protected int decreaseQuality(int quality, int count) {
        if(quality <= 1){
            return 0;
        }
        return quality - count;
    }
}
