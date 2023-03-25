package com.kusitms.together.api.domain.post;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Type {
    WATCH_OUT, RECOMMEND, ETC;

    @JsonCreator
    public static Type of(String type) {
        for (Type t : Type.values()) {
            if (t.name().equals(type)) {
                return t;
            }
        }
        return null;
    }
}
