package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleQualitySulfurasTest {
    private final RuleQualitySulfuras rule = new RuleQualitySulfuras();
    private final String sulfuras = "Sulfuras, Hand of Ragnaros";

    @Test
    void should_maintain_sellIn_and_maintain_quality_when_sellIn_is_gte_0(){
        Item item = new Item(sulfuras, 0, 30);

        rule.updateQuality(item);

        assertEquals(0, item.sellIn);
        assertEquals(30, item.quality);
    }

    @Test
    void should_maintain_sellIn_and_maintain_quality_when_sellIn_is_lt_0(){
        Item item = new Item(sulfuras, -1, 30);

        rule.updateQuality(item);

        assertEquals(-1, item.sellIn);
        assertEquals(30, item.quality);
    }
}