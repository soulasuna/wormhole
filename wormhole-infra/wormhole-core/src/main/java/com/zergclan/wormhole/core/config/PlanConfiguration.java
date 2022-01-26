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

package com.zergclan.wormhole.core.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Plan configuration.
 */
@RequiredArgsConstructor
@Getter
public final class PlanConfiguration implements Serializable {

    private static final long serialVersionUID = 3170585157651174520L;

    private final String code;

    private final int executionMode;

    private final String executionCorn;

    private final LocalDateTime effectiveDate;

    private final boolean execute;

    private final boolean enable;

    private final Long executionCount;

    private final Map<String, TaskConfiguration> tasks = new LinkedHashMap<>();
}