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

package com.zergclan.wormhole.core.metadata.resource;

import com.zergclan.wormhole.common.constant.MarkConstant;
import com.zergclan.wormhole.core.metadata.Metadata;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Metadata table.
 */
@RequiredArgsConstructor
@Getter
public final class TableMetadata implements Metadata {

    private final String dataSourceIdentifier;

    private final String schema;

    private final String name;
    
    private final Map<String, ColumnMetadata> columns = new LinkedHashMap<>();

    private final Map<String, IndexMetadata> indexes = new LinkedHashMap<>();

    /**
     * Register {@link ColumnMetadata}.
     *
     * @param columnMetadata {@link ColumnMetadata}
     * @return is registered or not.
     */
    public boolean registerColumn(final ColumnMetadata columnMetadata) {
        columns.put(columnMetadata.getIdentifier(), columnMetadata);
        return true;
    }

    /**
     * Register {@link IndexMetadata}.
     *
     * @param indexMetadata {@link IndexMetadata}
     * @return is registered or not.
     */
    public boolean registerIndex(final IndexMetadata indexMetadata) {
        indexes.put(indexMetadata.getIdentifier(), indexMetadata);
        return true;
    }

    @Override
    public String getIdentifier() {
        return dataSourceIdentifier + MarkConstant.SPACE + schema + MarkConstant.SPACE + name;
    }
}