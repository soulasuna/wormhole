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

package com.zergclan.wormhole.test.integration.framework.data;

import com.zergclan.wormhole.test.integration.framework.data.config.DatasetConfiguration;
import com.zergclan.wormhole.test.integration.framework.data.node.DataSourceNode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class Dataset {
    
    private final DataSourceNode source;
    
    private final DataSourceNode target;
    
    public Dataset(final DatasetConfiguration datasetConfiguration) {
        source = new DataSourceNode(datasetConfiguration.getSource());
        target = new DataSourceNode(datasetConfiguration.getTarget());
    }
}
