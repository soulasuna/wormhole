/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zergclan.wormhole.common.util;

import com.zergclan.wormhole.common.constant.MarkConstant;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class PropertiesExtractorTest {
    
    @Test
    public void assertExtractRequiredString() {
        Properties properties = new Properties();
        properties.put("name", "expectedValue");
        assertEquals("expectedValue", PropertiesExtractor.extractRequiredString(properties, "name"));
        assertEquals("defaultValue", PropertiesExtractor.extractRequiredString(properties, "default", "defaultValue"));
    }
    
    @Test
    public void assertExtractRequiredInt() {
        Properties properties = new Properties();
        properties.put("name", 1);
        assertEquals(1, PropertiesExtractor.extractRequiredInt(properties, "name"));
        assertEquals(0, PropertiesExtractor.extractRequiredInt(properties, "default", 0));
    }
    
    @Test
    public void assertExtractRequiredBoolean() {
        Properties properties = new Properties();
        properties.put("name", true);
        assertTrue(PropertiesExtractor.extractRequiredBoolean(properties, "name"));
        assertFalse(PropertiesExtractor.extractRequiredBoolean(properties, "default", false));
    }
    
    @Test
    public void assertExtractRequiredArray() {
        Properties properties = new Properties();
        properties.put("name", "aa,bb,cc");
        String[] values = PropertiesExtractor.extractRequiredArray(properties, "name", MarkConstant.COMMA);
        assertEquals(3, values.length);
        assertEquals("aa", values[0]);
        assertEquals("bb", values[1]);
        assertEquals("cc", values[2]);
    }
    
    @Test
    public void assertExtractRequiredMap() {
        Properties properties = new Properties();
        properties.put("name1", "aa");
        properties.put("name2", "bb");
        properties.put("key1", "value1");
        properties.put("key2", "value2");
        Map<String, String> map = PropertiesExtractor.extractRequiredMap(properties, "name1", "name2");
        assertEquals(2, map.size());
        assertEquals("value1", map.get("key1"));
        assertEquals("value2", map.get("key2"));
    }
}
