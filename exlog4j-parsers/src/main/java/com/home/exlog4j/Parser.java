package com.home.exlog4j;

import java.util.HashMap;

/**
 * Created by Константин on 21.02.2016.
 */
public interface Parser {
    HashMap<ExConfig,String> getConfigs(String classpath);
}