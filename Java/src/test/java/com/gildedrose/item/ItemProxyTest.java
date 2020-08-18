package com.gildedrose.item;

import com.gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemProxyTest {

    @Test
    void should_decrease_sellIn_in_one(){
        Item item = new Item("", 5,10);
        ItemProxy itemProxy = new ItemProxy(item);

        itemProxy.decreaseSellIn();

        assertEquals(4, item.sellIn);
        assertEquals(10, item.quality);
    }

    @Test
    void should_decrease_quality_in_count(){
        Item item = new Item("", 5,10);
        ItemProxy itemProxy = new ItemProxy(item);

        itemProxy.decreaseQualityIn(2);

        assertEquals(5, item.sellIn);
        assertEquals(8, item.quality);
    }

    @Test
    void should_decrease_quality_to_0_when_count_is_gt_than_quality(){
        Item item = new Item("", 5,1);
        ItemProxy itemProxy = new ItemProxy(item);

        itemProxy.decreaseQualityIn(2);

        assertEquals(5, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    void should_return_true_when_sellIn_has_expired(){
        Item item = new Item("", -2,1);
        ItemProxy itemProxy = new ItemProxy(item);

        assertTrue(itemProxy.hasExpiredSellDate());
    }

    @Test
    void should_return_false_when_sellIn_has_not_expired(){
        Item item = new Item("", 0,1);
        ItemProxy itemProxy = new ItemProxy(item);

        assertFalse(itemProxy.hasExpiredSellDate());
    }

    @Test
    void should_not_increase_quality_when_it_is_eq_to_50(){
        Item item = new Item("", 0,50);
        ItemProxy itemProxy = new ItemProxy(item);

        itemProxy.increaseQuality(1);

        assertEquals(0, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void should_not_increase_quality_when_in_more_than_50(){
        Item item = new Item("", 0,48);
        ItemProxy itemProxy = new ItemProxy(item);

        itemProxy.increaseQuality(3);

        assertEquals(0, item.sellIn);
        assertEquals(50, item.quality);
    }

    @Test
    void should_return_true_if_less_than_n_days_left_to_sell(){
        Item item = new Item("", 5,1);
        ItemProxy itemProxy = new ItemProxy(item);

        assertTrue(itemProxy.lessThanNDaysLeftToSell(6));
    }

    @Test
    void should_set_quality_to_0(){
        Item item = new Item("", -15,40);
        ItemProxy itemProxy = new ItemProxy(item);

        itemProxy.leaveWithoutQuality();

        assertEquals(0, item.quality);
    }
}
