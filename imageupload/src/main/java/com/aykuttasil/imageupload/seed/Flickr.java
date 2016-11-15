package com.aykuttasil.imageupload.seed;

import com.aykuttasil.imageupload.rest.models.FlickrUploadResponse;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by aykutasil on 14.11.2016.
 */

public class Flickr extends IBaseSeed<Flickr, FlickrUploadResponse> {

    @Override
    public Observable<FlickrUploadResponse> upload(Map<String, RequestBody> map) {
        return null;
    }
}
