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

package com.zergclan.wormhole.metadata.core.filter.complex;

import com.zergclan.wormhole.common.constant.MarkConstant;
import com.zergclan.wormhole.common.util.PropertiesExtractor;
import com.zergclan.wormhole.metadata.core.filter.FilterMetaData;
import com.zergclan.wormhole.metadata.core.filter.FilterType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Properties;

/**
 * Node value delimiter splitter implemented of {@link FilterMetaData}.
 */
@RequiredArgsConstructor
@Getter
public final class NodeValueDelimiterSplitterMetaData implements FilterMetaData {

    private static final FilterType FILTER_TYPE = FilterType.DELIMITER_SPLITTER;

    private final String taskIdentifier;

    private final int order;
    
    private final String sourceName;
    
    private final String[] targetNames;
    
    private final String delimiter;
    
    @Override
    public String getIdentifier() {
        return taskIdentifier + MarkConstant.SPACE + FILTER_TYPE.name() + MarkConstant.SPACE + order;
    }

    @Override
    public FilterType getType() {
        return FILTER_TYPE;
    }

    /**
     * Builder for {@link NodeValueDelimiterSplitterMetaData}.
     *
     * @param taskIdentifier task identifier
     * @param order order
     * @param props props
     * @return {@link NodeValueDelimiterSplitterMetaData}
     */
    public static NodeValueDelimiterSplitterMetaData builder(final String taskIdentifier, final int order, final Properties props) {
        String sourceName = PropertiesExtractor.extractRequiredString(props, "sourceName");
        String[] targetNames = PropertiesExtractor.extractRequiredArray(props, "targetNames", MarkConstant.COMMA);
        String delimiter = PropertiesExtractor.extractRequiredString(props, "delimiter", "");
        return new FilterBuilder(taskIdentifier, order, sourceName, targetNames, delimiter).build();
    }
    
    @RequiredArgsConstructor
    private static class FilterBuilder {
        
        private final String taskIdentifier;
        
        private final int order;
    
        private final String sourceName;
    
        private final String[] targetNames;
    
        private final String delimiter;
        
        private NodeValueDelimiterSplitterMetaData build() {
            return new NodeValueDelimiterSplitterMetaData(taskIdentifier, order, sourceName, targetNames, delimiter);
        }
    }
}
