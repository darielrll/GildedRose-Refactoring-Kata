package com.gildedrose;

import com.gildedrose.rule.Rule;
import com.gildedrose.rule.RuleFactory;

class GildedRose {
    private Item[] items;
    private RuleFactory ruleFactory;

    public GildedRose(Item[] items) {
        this.items = items;
        ruleFactory = new RuleFactory();
    }

    public void updateQuality() {
        for (Item item : items) {
            Rule rule = ruleFactory.getRule(item.name);
            rule.updateQuality(item);
        }
    }
}