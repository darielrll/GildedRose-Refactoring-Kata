package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleQualityAgedBrieTest {
    private final RuleQualityAgedBrie rule = new RuleQualityAgedBrie();
    private final String agedBrie = "Aged Brie";

    @Test
    void should_decrease_sellIn_in_1_and_increase_quality_in_1_when_quality_is_less_50(){
        Item item = new Item(agedBrie, 10, 10);

        rule.updateQuality(item);

        assertEquals(9, item.sellIn);
        assertEquals(11, item.quality);
    }

    @Test
    void should_decrease_sellIn_in_1_and_increase_quality_in_2_when_sellIn_is_lt_0_and_quality_is_lt_49(){
        Item item = new Item(agedBrie, -1, 48);

        rule.updateQuality(item);

        assertEquals(-2, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void should_decrease_sellIn_in_1_and_maintain_quality_when_quality_is_gte_50(){
        Item item = new Item(agedBrie, 10, 50);

        rule.updateQuality(item);

        assertEquals(9, item.sellIn);
        assertEquals(50, item.quality);
    }
}
