package com.allure.plugin;

import io.qameta.allure.Aggregator;
import io.qameta.allure.CommonJsonAggregator;
import io.qameta.allure.CompositeAggregator;
import io.qameta.allure.Constants;
import io.qameta.allure.core.LaunchResults;

import java.util.*;

public class MyPlugin extends CompositeAggregator {

    protected static final String JSON_FILE_NAME = "myplugin.json";

    public MyPlugin() {
        super(Arrays.<Aggregator>asList(new JsonAggregator(), new WidgetAggregator()));
    }


    protected static class JsonAggregator extends CommonJsonAggregator {
        protected JsonAggregator() {
            super(JSON_FILE_NAME);
        }

        protected Object getData(List<LaunchResults> list) {
            Collection<Map> c = new ArrayList<Map>();
            Map<Object, Object> m = new HashMap<Object, Object>();

            String[] toppings = {"Cheese", "Pepperoni", "Black Olives"};
            m.put("sounds", toppings);
            m.put("name","angryCat");
            c.add(m);
            return c;
        }
    }

    protected static class WidgetAggregator extends CommonJsonAggregator {
        protected WidgetAggregator() {
            super(Constants.WIDGETS_DIR,JSON_FILE_NAME);
        }

        protected Object getData(List<LaunchResults> list) {
            Collection<Map> c = new ArrayList<Map>();
            Map<Object, Object> m = new HashMap<Object, Object>();

            String[] toppings = {"Cheese", "Pepperoni", "Black Olives"};
            m.put("sounds", toppings);
            m.put("name","angryCat");
            c.add(m);
            return c;
        }
    }
}
