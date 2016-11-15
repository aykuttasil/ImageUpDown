package com.aykuttasil.imageupload;

import com.aykuttasil.imageupload.rest.models.BaseRestResponse;
import com.aykuttasil.imageupload.seed.IBaseSeed;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by aykutasil on 14.11.2016.
 */

public class ImageUpload<T extends IBaseSeed, R extends BaseRestResponse> {

    private T mSeed;
    private R mResp;


    private ImageUpload(T seed, R resp) {
        mSeed = seed;
        mResp = resp;
    }

    public static <T extends IBaseSeed, R extends BaseRestResponse> ImageUpload<T, R> create(T seed, R resp) {
        return new ImageUpload<T, R>(seed, resp);
    }

    public rx.Observable<R> upload(Map<String, RequestBody> map) {
        return mSeed.upload(map);
    }

    public rx.Observable<R> upload(File file, String fileName) throws IOException {

        byte[] byteContent = FileUtils.readFileToByteArray(file);
        RequestBody imageBody = RequestBody.create(MediaType.parse("image/*"), byteContent);

        Map<String, RequestBody> map = new HashMap<>();
        map.put("image\"; filename=\"" + fileName + ".jpg\"", imageBody);

        return mSeed.upload(map);
    }
}
