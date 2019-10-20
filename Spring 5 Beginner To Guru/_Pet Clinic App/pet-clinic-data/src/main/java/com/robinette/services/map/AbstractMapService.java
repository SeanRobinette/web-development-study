package com.robinette.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.robinette.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<Long, T>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if(object != null) {
            if(object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void deleteByObject(T obj) {
        map.values().removeIf(value -> value.equals(obj));
    }
    
    private Long getNextId() {
        if(map.isEmpty()) {
            return 0L;
        }
        return Collections.max(map.keySet()) + 1;
    }
}