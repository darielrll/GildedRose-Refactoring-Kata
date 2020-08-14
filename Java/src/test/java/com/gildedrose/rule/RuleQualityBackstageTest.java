package com.gildedrose.rule;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RuleQualityBackstageTest {
    private final RuleQualityBackstage rule = new RuleQualityBackstage();
    private final String backstage = "Backstage";

    @Test
    void should_decrease_sellIn_in_1_and_maintain_quality_when_item_quality_is_eq_50(){
        Item item = new Item(backstage, 10, 50);

        rule.updateQuality(item);

        assertEquals(9, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void should_decrease_sellIn_in_1_and_maintain_quality_when_sellIn_is_gte_11(){
        Item item = new Item(backstage, 12, 10);

        rule.updateQuality(item);

        assertEquals(11, item.sellIn);
        assertEquals(10, item.quality);
    }

    @Test
    void should_decrease_sellIn_in_1_and_maintain_quality_when_quality_is_gt_50(){
        Item item = new Item(backstage, 10, 51);

        rule.updateQuality(item);

        assertEquals(9, item.sellIn);
        assertEquals(51, item.quality);
    }

    @Test
    void should_decrease_sellIn_in_1_and_increase_quality_in_1_when_sellIn_is_gte_11_and_quality_is_lt_50(){
        Item item = new Item(backstage, 11, 49);

        rule.updateQuality(item);

        assertEquals(10, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void should_decrease_sellIn_in_1_and_increase_quality_in_2_when_sellIn_is_gt_6_and_lt_11(){
        Item item = new Item(backstage, 10, 45);

        rule.updateQuality(item);

        assertEquals(9, item.sellIn);
        assertEquals(47, item.quality);
    }

    @Test
    void should_decrease_sellIn_in_1_and_increase_quality_in_3_when_sellIn_is_lt_6(){
        Item item = new Item(backstage, 5, 40);

        rule.updateQuality(item);

        assertEquals(4, item.sellIn);
        assertEquals(43, item.quality);
    }

    @Test
    void should_decrease_sellIn_in_1_and_set_quality_to_0_when_sellIn_is_lt_0(){
        Item item = new Item(backstage, -1, 50);

        rule.updateQuality(item);

        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);
    }
}