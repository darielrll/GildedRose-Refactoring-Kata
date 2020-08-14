package com.gildedrose.rule;

public class RuleFactory {
    private static final String AGED_BRIE_RULE = "Aged Brie";
    private static final String BACKSTAGE_RULE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_RULE = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED_RULE = "Conjured";

    public Rule getRule(String ruleName) {
        switch (ruleName){
            case AGED_BRIE_RULE:
                return new RuleQualityAgedBrie();
            case BACKSTAGE_RULE:
                return new RuleQualityBackstage();
            case SULFURAS_RULE:
                return new RuleQualitySulfuras();
            case CONJURED_RULE:
                return new RuleQualityConjured();
            default:
                return new RuleQualityUnknown();
        }
    }
}
