package com.home.exlog4j.parsers;

/**
 * Existing types of parsers.
 * At the moment, the framework supports 3 types of configurations;
 */
public enum ParsersType {
    /**
     * <h1>Xml configuration</h1>
     * <h2>
     *     Example:
     *     {@code
     *     <exlogger>
                <profile name="profile1">
                    <appender type="console">
                        <pattern>testPattern</pattern>
                    </appender>
                </profile>
                <profile name="profile2">
                    <appender type="console">
                        <pattern>testPattern</pattern>
                    </appender>
                </profile>
            </exlogger>
     *     }
     * </h2>
     */
    XML,
    /**
     * <h1>Xml configuration</h1>
     * <h2>
     *     Example:
     *     {@code
     *          {
     *          "profile":"profile1",
     *          "appenderList":[{
     *              "patternLayout":{
     *                  "pattern":"testPattern"
     *                  }
 *                  },{
     *              "patternLayout":{
     *                  "pattern":"testPattern"
     *                  }
     *                }]}
     *     }
     * </h2>
     */
    JSON,
    /**
     * Properties configuration will be release in a future
     */
    PROPERTIES
}
