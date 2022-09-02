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

package com.zergclan.wormhole.common.metadata.datasource;

import com.zergclan.wormhole.tool.spi.WormholeServiceLoader;
import com.zergclan.wormhole.tool.spi.scene.typed.TypedSPIRegistry;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Simple factory for create {@link DataSourceType}.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataSourceTypeFactory {
    
    static {
        WormholeServiceLoader.register(DataSourceType.class);
    }
    
    /**
     * Get instance.
     *
     * @param dataSourceType data source type
     * @return {@link DataSourceType}
     */
    public static DataSourceType getInstance(final String dataSourceType) {
        return TypedSPIRegistry.getRegisteredService(DataSourceType.class, dataSourceType);
    }
}