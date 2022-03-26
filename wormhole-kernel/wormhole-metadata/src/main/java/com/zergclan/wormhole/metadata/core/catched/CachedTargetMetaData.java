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

package com.zergclan.wormhole.metadata.core.catched;

import com.zergclan.wormhole.common.constant.MarkConstant;
import com.zergclan.wormhole.metadata.api.DataSourceMetaData;
import com.zergclan.wormhole.metadata.api.MetaData;
import com.zergclan.wormhole.metadata.core.node.DataNodeMetaData;
import com.zergclan.wormhole.metadata.core.task.TargetMetaData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Map;

/**
 * Cached {@link TargetMetaData}.
 */
@RequiredArgsConstructor
@Getter
public final class CachedTargetMetaData implements MetaData {
    
    private final String identifier;

    private final DataSourceMetaData dataSource;

    private final String table;

    private final boolean transaction;

    private final Collection<String> uniqueNodes;

    private final Collection<String> compareNodes;

    private final Map<String, DataNodeMetaData> dataNodes;
    
    /**
     * Builder for {@link CachedTargetMetaData}.
     *
     * @param cachedTaskIdentifier cached task identifier
     * @param target {@link TargetMetaData}
     * @param dataSource {@link DataSourceMetaData}
     * @return {@link CachedTargetMetaData}
     */
    public static CachedTargetMetaData builder(final String cachedTaskIdentifier, final TargetMetaData target, final DataSourceMetaData dataSource) {
        return new CachedBuilder(cachedTaskIdentifier, target, dataSource).build();
    }
    
    @RequiredArgsConstructor
    private static class CachedBuilder {
        
        private final String cachedTaskIdentifier;
        
        private final TargetMetaData target;
        
        private final DataSourceMetaData dataSource;
        
        private CachedTargetMetaData build() {
            return new CachedTargetMetaData(generateIdentifier(), dataSource, target.getTable(), target.isTransaction(), target.getUniqueNodes(), target.getCompareNodes(), target.getDataNodes());
        }
        
        private String generateIdentifier() {
            return cachedTaskIdentifier + MarkConstant.SPACE + dataSource.getIdentifier();
        }
    }
}
