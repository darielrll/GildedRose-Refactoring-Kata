package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RuleQualityConjuredTest {
    private final RuleQualityConjured rule = new RuleQualityConjured();
    private final String conjured = "Conjured";

    @Test
    void should_decrease_sellIn_in_1_and_decrease_quality_in_2(){
        Item item = new Item(conjured, 10, 10);

        rule.updateQuality(item);

        assertEquals(9, item.sellIn);
        assertEquals(8, item.quality);
    }

    @Test
    void should_decrease_sell_in_in_1_decrease_quality_in_2_and_quality_is_gte_0(){
        Item item = new Item(conjured, 10, 1);

        rule.updateQuality(item);

        assertEquals(9, item.sellIn);
        assertEquals(0, item.quality);
    }
}
