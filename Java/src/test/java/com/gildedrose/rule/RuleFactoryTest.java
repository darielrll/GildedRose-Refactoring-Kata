package com.gildedrose.rule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RuleFactoryTest {
    private RuleFactory ruleFactory = new RuleFactory();

    @Test
    void should_return_aged_brie_quality_rule(){
        String ruleAgedBrie = "Aged Brie";
        Rule rule = ruleFactory.getRule(ruleAgedBrie);

        assertTrue(rule instanceof RuleUpdateQualityAgedBrie);
    }

    @Test
    void should_return_backstage_quality_rule(){
        String ruleBackstage = "Backstage passes to a TAFKAL80ETC concert";
        Rule rule = ruleFactory.getRule(ruleBackstage);

        assertTrue(rule instanceof RuleQualityBackstage);
    }

    @Test
    void should_return_unknown_quality_rule(){
        String unknown = "unknown";
        Rule rule = ruleFactory.getRule(unknown);

        assertTrue(rule instanceof RuleQualityUnknown);
    }

    @Test
    void should_return_sulfuras_quality_rule(){
        String sulfuras = "Sulfuras, Hand of Ragnaros";
        Rule rule = ruleFactory.getRule(sulfuras);

        assertTrue(rule instanceof RuleQualitySulfuras);
    }
}
