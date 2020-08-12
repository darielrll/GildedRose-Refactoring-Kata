package com.gildedrose.rule;

public class RuleFactory {
    private final String agedBrieRule = "Aged Brie";
    private final String backstageRule = "Backstage passes to a TAFKAL80ETC concert";
    private final String sulfuras = "Sulfuras, Hand of Ragnaros";

    public Rule getRule(String ruleName) {
        if(agedBrieRule.equals(ruleName)){
            return new RuleUpdateQualityAgedBrie();
        }
        if(backstageRule.equals(ruleName)){
            return new RuleQualityBackstage();
        }
        if(sulfuras.equals(ruleName)){
            return new RuleQualitySulfuras();
        }
        return new RuleQualityUnknown();
    }
}
