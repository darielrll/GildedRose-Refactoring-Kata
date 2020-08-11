package com.gildedrose;

class GildedRose {
    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isLegendaryItem(item)) {
                continue;
            }
            notLegendaryApplyUpdateQuality(item);
        }
    }

    private void notLegendaryApplyUpdateQuality(Item item) {
        item.sellIn--;

        switch (item.name){
            case "Aged Brie":
                brieItemApplyQualityRules(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                backstageItemApplyQualityRules(item);
                break;
            default:
                unknownItemApplyQualityRules(item);
        }
    }

    private void brieItemApplyQualityRules(Item item) {
        if (item.quality < 49) {
            item.quality++;
        }
        if (item.sellIn < 0) {
            item.quality++;
        }
    }

    private void backstageItemApplyQualityRules(Item item) {
        if(item.sellIn >= 11){
            return;
        }
        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }
        item.quality = increaseQuality(item.quality, 2);
        if (item.sellIn < 6) {
            item.quality = increaseQuality(item.quality, 2);
        }
    }

    private void unknownItemApplyQualityRules(Item item) {
        if (item.sellIn < 0) {
            item.quality = decreaseQuality(item.quality);
        }
        item.quality = decreaseQuality(item.quality);
    }

    private boolean isLegendaryItem(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.name);
    }

    private int increaseQuality(int quality, int count) {
        if(count == 0  ||  quality >= 50){
            return quality;
        }
        return increaseQuality(++quality, --count);
    }

    private int decreaseQuality(int quality) {
        return quality > 0 ? quality - 1 : quality;
    }
}