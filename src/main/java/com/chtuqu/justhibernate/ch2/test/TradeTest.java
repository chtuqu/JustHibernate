package com.chtuqu.justhibernate.ch2.test;

import com.chtuqu.justhibernate.ch1.hibernate.HibernateConnectionManager;
import com.chtuqu.justhibernate.ch1.hibernate.HibernatePersistor;
import com.chtuqu.justhibernate.ch2.dto.Trade;

public class TradeTest {
    public static void main(String[] args) {
        HibernatePersistor persistor = new HibernatePersistor();

        Trade trade = createTrade("IBM", 15.02);

        persistor.persist(trade);
        trade = persistor.query(Trade.class, trade.getId());
        System.out.println(trade);
        HibernateConnectionManager.getSessionFactory().close();
    }

    private static Trade createTrade(String security, double quantity) {
        Trade trade = new Trade();
        trade.setSecurity(security);
        trade.setQuantity(quantity);
        return trade;
    }
}
