package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleQualityNotLegendaryItemTest {
    private final RuleQualityNotLegendaryItem rule = new RuleQualityNotLegendaryItem();
    private final String not_legendary_item = "not_legendary_item";

    @Test
    void should_decrease_sell_in_in_1(){
        Item item = new Item(not_legendary_item, 6, 5);

        rule.updateQuality(item);

        assertEquals(5, item.sellIn);
    }
}