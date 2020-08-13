package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    private final String unknown = "unknown";
    private final String agedBrie = "Aged Brie";
    private final String backStage = "Backstage passes to a TAFKAL80ETC concert";
    private final String sulfuras = "Sulfuras, Hand of Ragnaros";

    // Unknown
    @Test
    void should_decrease_sellIn_in_1_and_decrease_quality_in_1_when_item_is_unknown(){
        Item[] items = new Item[] { new Item(unknown, 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(9, items[0].quality);
    }

    // Aged Brie
    @Test
    void should_decrease_sellIn_in_1_and_increase_quality_in_1_when_items_is_brie_and_quality_is_less_50(){
        Item[] items = new Item[] { new Item(agedBrie, 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(11, items[0].quality);
    }

    // Backstage
    @Test
    void should_decrease_sellIn_in_1_and_maintain_quality_when_item_is_backstage_and_quality_is_eq_50(){
        Item[] items = new Item[] { new Item(backStage, 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    //Sulfuras
    @Test
    void should_maintain_sellIn_and_maintain_quality_when_item_is_sulfuras_and_sellIn_is_gte_0(){
        Item[] items = new Item[] { new Item(sulfuras, 0, 30) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, items[0].sellIn);
        assertEquals(30, items[0].quality);
    }
}