package com.home.exlog4j;

import com.home.exlog4j.config.ExConfig;

import java.util.HashMap;

/**
 * Created by Константин on 21.02.2016.
 */
public interface Parser {
    HashMap<ExConfig,String> getConfigs(String classpath);
}
