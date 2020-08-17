package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private final String unknown = "unknown";

    // Unknown
    @Test
    void should_decrease_sellIn_in_1_and_decrease_quality_in_1_when_item_is_unknown(){
        Item[] items = new Item[] { new Item(unknown, 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(9, items[0].quality);
    }
}