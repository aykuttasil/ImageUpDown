package com.aykuttasil.imageupload.seed;

import android.content.Context;
import android.util.Log;

import com.aykuttasil.imageupload.rest.ApiManager;
import com.aykuttasil.imageupload.rest.models.ImgurUploadResponse;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * Created by aykutasil on 14.11.2016.
 */

public class Imgur extends IBaseSeed<Imgur, ImgurUploadResponse> {

    private static String TAG = Imgur.class.getSimpleName();

    public static String IMGUR_API_CLIENT = "5b37683c8864f6a";
    public static String IMGUR_API_SECRET = "";

    private Context mContext;


    public Imgur(Context context) {
        Log.i(TAG, "instance");
        this.mContext = context;
    }

    public static ImgurUploadResponse resp() {
        Log.i(TAG, "resp");
        return new ImgurUploadResponse();
    }

    @Override
    public rx.Observable<ImgurUploadResponse> upload(Map<String, RequestBody> map) {
        Log.i(TAG, "upload");
        return ApiManager.getInstance(mContext).ImgurImageUpload(map);
    }


}
