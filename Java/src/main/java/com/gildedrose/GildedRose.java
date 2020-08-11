package com.gildedrose;

class GildedRose {
    private Item[] items;
    private final String sulfuras = "Sulfuras, Hand of Ragnaros";
    private final String backstage = "Backstage passes to a TAFKAL80ETC concert";
    private final String agedBrie = "Aged Brie";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {


            if(items[i].name.equals(agedBrie)) {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                }
                if (items[i].sellIn < 0) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
                items[i].sellIn = items[i].sellIn - 1;
            }

            if(items[i].name.equals(backstage)){
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                }
                if (items[i].sellIn < 11) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
                if (items[i].sellIn < 6) {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
                if (items[i].sellIn < 0) {
                    items[i].quality = 0;
                }
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (!items[i].name.equals(agedBrie) && !items[i].name.equals(backstage) && !items[i].name.equals(sulfuras)) {
                if (items[i].sellIn < 0) {
                    if (items[i].quality > 0) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
                if (items[i].quality > 0) {
                    items[i].quality = items[i].quality - 1;
                }
                items[i].sellIn = items[i].sellIn - 1;
            }
        }
    }
}