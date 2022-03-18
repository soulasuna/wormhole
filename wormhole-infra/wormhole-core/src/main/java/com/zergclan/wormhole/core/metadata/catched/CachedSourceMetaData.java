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

package com.zergclan.wormhole.core.metadata.catched;

import com.zergclan.wormhole.core.api.metadata.DataSourceMetaData;
import com.zergclan.wormhole.core.metadata.resource.ColumnMetaData;
import com.zergclan.wormhole.core.metadata.task.SourceMetaData;
import lombok.RequiredArgsConstructor;

import java.util.Map;

public final class CachedSourceMetaData {
    
    private final String query;
    
    private final Map<String, ColumnMetaData> columnMetadata;
    
    public CachedSourceMetaData(final String query, final Map<String, ColumnMetaData> columnMetadata) {
        this.query = query;
        this.columnMetadata = columnMetadata;
    }
    
    /**
     * Builder for {@link CachedSourceMetaData}.
     *
     * @param source {@link SourceMetaData}
     * @param dataSource {@link DataSourceMetaData}
     * @return {@link CachedSourceMetaData}
     */
    public static CachedSourceMetaData builder(final SourceMetaData source, final DataSourceMetaData dataSource) {
        return new CachedBuilder(source, dataSource).build();
    }
    
    @RequiredArgsConstructor
    private static class CachedBuilder {
        
        private final SourceMetaData source;
        
        private final DataSourceMetaData dataSource;
    
        private CachedSourceMetaData build() {
            String querySql;
            Map<String, ColumnMetaData> columnMetadata;
            return null;
        }
    }
}