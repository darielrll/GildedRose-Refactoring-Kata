package com.gildedrose.rule;

import com.gildedrose.item.ItemProxy;

public class RuleQualityBackstage extends RuleQualityNotLegendaryItem {

    @Override
    protected void updateQuality(ItemProxy item) {
        super.updateQuality(item);

        if (item.hasExpiredSellDate()) {
            item.leaveWithoutQuality();
            return;
        }
        if (item.lessThanNDaysLeftToSell(5)) {
            item.increaseQuality(3);
            return;
        }
        if (item.lessThanNDaysLeftToSell(11)) {
            item.increaseQuality(2);
        }
    }
}
