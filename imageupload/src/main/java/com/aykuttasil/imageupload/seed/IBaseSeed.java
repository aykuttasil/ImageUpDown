package com.aykuttasil.imageupload.seed;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * Created by aykutasil on 14.11.2016.
 */

public abstract class IBaseSeed<T, R> {

    public abstract rx.Observable<R> upload(Map<String, RequestBody> map);

    // public abstract R resp();

}
