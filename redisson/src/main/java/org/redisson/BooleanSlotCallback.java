/**
 * Copyright (c) 2013-2024 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author Nikita Koksharov
 *
 */
public class BooleanSlotCallback implements SlotCallback<Boolean, Boolean> {

    private final Object[] params;

    public BooleanSlotCallback() {
        this(null);
    }

    public BooleanSlotCallback(Object[] params) {
        this.params = params;
    }

    @Override
    public Boolean onResult(Collection<Boolean> res) {
        return res.contains(true);
    }

    @Override
    public Object[] createParams(List<Object> params) {
        if (this.params != null) {
            return this.params;
        }
        return SlotCallback.super.createParams(params);
    }
}
