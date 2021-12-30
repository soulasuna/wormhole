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

package com.zergclan.wormhole.pipeline.impl;

import com.zergclan.wormhole.core.data.DataNode;
import com.zergclan.wormhole.core.data.PatternDate;
import com.zergclan.wormhole.pipeline.DataNodeFilter;
import com.zergclan.wormhole.pipeline.DataNodePipeline;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Implemented {@link DataNodePipeline} for {@link com.zergclan.wormhole.core.data.PatternDateDataNode}.
 */
public final class PatternDateDataNodePipeline implements DataNodePipeline<PatternDate> {
    
    private final Collection<DataNodeFilter<PatternDate>> filterChains = new LinkedList<>();
    
    @Override
    public void handle(final DataNode<PatternDate> dataNode) {
        DataNode<PatternDate> temp = dataNode;
        for (DataNodeFilter<PatternDate> each : filterChains) {
            temp = each.doFilter(temp);
        }
        dataNode.refresh(temp.getValue());
    }
    
    @Override
    public void append(final DataNodeFilter<PatternDate> dataNodeFilter) {
        filterChains.add(dataNodeFilter);
    }
}