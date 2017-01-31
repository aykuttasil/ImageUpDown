package com.aykuttasil.imageupload;

import android.graphics.Bitmap;

import com.aykuttasil.imageupload.rest.models.BaseRestResponse;
import com.aykuttasil.imageupload.seed.IBaseSeed;
import com.aykuttasil.imageupload.seed.Imgur;

import org.apache.commons.io.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.exceptions.Exceptions;
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

    private ImageUpload(T seed) {
        mSeed = seed;
        //mResp = resp;
    }

    public static <T extends IBaseSeed, R extends BaseRestResponse> ImageUpload<T, R> create(T seed, R resp) {
        return new ImageUpload<T, R>(seed, resp);
    }

    public rx.Observable<R> upload(Map<String, RequestBody> map) {
        return mSeed.upload(map);
    }

    public rx.Observable<R> upload(File file, String fileName) {

        try {
            byte[] byteContent = FileUtils.readFileToByteArray(file);
            RequestBody imageBody = RequestBody.create(MediaType.parse("image/*"), byteContent);

            Map<String, RequestBody> map = new HashMap<>();
            map.put("image\"; filename=\"" + fileName + ".jpg\"", imageBody);

            return mSeed.upload(map);

        } catch (Exception e) {
            e.printStackTrace();
            throw Exceptions.propagate(e);
        }
    }

    public rx.Observable<R> upload(Bitmap bitmap, String fileName) {

        try {
            Bitmap bmp = bitmap.copy(Bitmap.Config.ARGB_8888, false);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteContent = stream.toByteArray();

            RequestBody imageBody = RequestBody.create(MediaType.parse("image/*"), byteContent);

            Map<String, RequestBody> map = new HashMap<>();
            map.put("image\"; filename=\"" + fileName + ".jpg\"", imageBody);

            return mSeed.upload(map);

        } catch (Exception e) {
            e.printStackTrace();
            throw Exceptions.propagate(e);
        }
    }

}
