package com.example.core.network;

import android.support.annotation.Nullable;

import com.squareup.moshi.Json;


public final class BaseContactResponse<DataType> {

    @Json(name = "code")
    @Nullable
    private final Long code;

    @Json(name = "status")
    @Nullable
    private final String status;

    @Json(name = "data")
    @Nullable
    private final DataType dataType;

    @Json(name = "timestamp")
    @Nullable
    private final Long timestamp;

    public BaseContactResponse(@Nullable Long code, @Nullable String status, @Nullable DataType dataType, @Nullable Long timestamp) {
        this.code = code;
        this.status = status;
        this.dataType = dataType;
        this.timestamp = timestamp;
    }

    @Nullable
    public Long getCode() {
        return code;
    }

    @Nullable
    public String getStatus() {
        return status;
    }

    @Nullable
    public DataType getDataType() {
        return dataType;
    }

    @Nullable
    public Long getTimestamp() {
        return timestamp;
    }
}