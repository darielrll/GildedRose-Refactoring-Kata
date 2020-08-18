package com.gildedrose.rule;

import com.gildedrose.Item;
import com.gildedrose.item.ItemProxy;

public abstract class Rule {
    public final void updateQuality(Item item){
        updateQuality(new ItemProxy(item));
    }

    protected abstract void updateQuality(ItemProxy item);
}
