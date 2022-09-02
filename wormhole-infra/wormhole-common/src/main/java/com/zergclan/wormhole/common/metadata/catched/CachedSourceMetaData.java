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

package com.zergclan.wormhole.common.metadata.catched;

import com.zergclan.wormhole.common.metadata.datasource.DataSourceMetaData;
import com.zergclan.wormhole.common.metadata.plan.SourceMetaData;
import com.zergclan.wormhole.common.metadata.plan.node.DataNodeMetaData;
import com.zergclan.wormhole.tool.constant.MarkConstant;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 * Cached {@link SourceMetaData}.
 */
@RequiredArgsConstructor
@Getter
public final class CachedSourceMetaData implements CachedMetaData {
    
    private final String identifier;
    
    private final long taskBatch;
    
    private final DataSourceMetaData dataSource;
    
    private final String table;
    
    private final Map<String, DataNodeMetaData> dataNodes;
    
    private final String actualSql;
    
    private final String conditionSql;
    
    /**
     * Builder for {@link CachedSourceMetaData}.
     *
     * @param cachedTaskIdentifier cached task identifier
     * @param taskBatch task batch
     * @param source {@link SourceMetaData}
     * @param dataSource {@link DataSourceMetaData}
     * @return {@link CachedSourceMetaData}
     */
    public static CachedSourceMetaData builder(final String cachedTaskIdentifier, final long taskBatch, final SourceMetaData source, final DataSourceMetaData dataSource) {
        return new CachedBuilder(cachedTaskIdentifier, taskBatch, source, dataSource).build();
    }
    
    @RequiredArgsConstructor
    private static class CachedBuilder {
    
        private final String cachedTaskIdentifier;
    
        private final long taskBatch;
        
        private final SourceMetaData source;
        
        private final DataSourceMetaData dataSource;
    
        private CachedSourceMetaData build() {
            return new CachedSourceMetaData(generateIdentifier(), taskBatch, dataSource, source.getTable(), source.getDataNodes(), source.getActualSql(), source.getConditionSql());
        }
        
        private String generateIdentifier() {
            return cachedTaskIdentifier + MarkConstant.SPACE + dataSource.getIdentifier();
        }
    }
}