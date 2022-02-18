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

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Util tools for collection.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CollectionUtil {
    
    /**
     * Partition collection.
     *
     * @param collection collection
     * @param size size
     * @param <T> class type of collection element
     * @return partitioned collection
     */
    public static <T> Collection<Collection<T>> partition(final Collection<T> collection, final int size) {
        Validator.notNull(collection, "Error : partition input collection can not be null");
        Validator.isTrue(size > 0, "Error : partition input size [size] less than 0");
        Collection<Collection<T>> result = new LinkedList<>();
        int collectionSize = collection.size();
        if (size >= collectionSize) {
            result.add(collection);
            return result;
        }
        Iterator<T> iterator = collection.iterator();
        Collection<T> sizedEach = new LinkedList<>();
        int count = 0;
        while (iterator.hasNext()) {
            count++;
            sizedEach.add(iterator.next());
            if (size == sizedEach.size() || count == collectionSize) {
                result.add(sizedEach);
                sizedEach = new LinkedList<>();
            }
        }
        return result;
    }
}