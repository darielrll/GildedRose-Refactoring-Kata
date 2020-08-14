package com.gildedrose.rule;

import com.gildedrose.Item;

public abstract class Rule {
    public abstract void updateQuality(Item item);

    protected int decreaseQuality(int quality, int count) {
        if(count == 0  ||  quality == 0){
            return quality;
        }
        return decreaseQuality(--quality, --count);
    }
}
