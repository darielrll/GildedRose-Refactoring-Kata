package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleQualityUnknownTest {
    private final RuleQualityUnknown rule = new RuleQualityUnknown();
    private final String unknown = "unknown";

    @Test
    void should_decrease_sellIn_in_1_and_decrease_quality_in_1(){
        Item item = new Item(unknown, 10, 10);

        rule.updateQuality(item);

        assertEquals(9, item.sellIn);
        assertEquals(9, item.quality);
    }

    @Test
    void should_decrease_sellIn_in_1_and_maintain_quality_when_quality_is_0(){
        Item item = new Item(unknown, 10, 0);

        rule.updateQuality(item);

        assertEquals(9, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void should_decrease_sellIn_in_1_and_decrease_quality_in_2_when_sellIn_is_lt_0_and_quality_is_gt_1(){
        Item item = new Item(unknown, -1, 2);

        rule.updateQuality(item);

        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);
    }
}