package com.aykuttasil.imageupload.rest;

import android.content.Context;

import com.aykuttasil.imageupload.rest.models.ImgurUploadResponse;
import com.aykuttasil.imageupload.seed.Imgur;

import java.util.Map;

import okhttp3.RequestBody;
import rx.schedulers.Schedulers;

/**
 * Created by aykutasil on 14.11.2016.
 */

public class ApiManager {

    private static ApiManager mInstance;
    private Context mContext;
    private static RestClient mRestClient;


    private ApiManager(Context context) {
        mContext = context;
        mRestClient = RestClient.getInstance();
    }

    public static ApiManager getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new ApiManager(context);
        }
        return mInstance;
    }

    public rx.Observable<ImgurUploadResponse> ImgurImageUpload(Map<String, RequestBody> image) {

        String imgurAuth = "Client-ID " + Imgur.IMGUR_API_CLIENT_KEY;

        return mRestClient.getmApiService()
                .ImgurUpload(imgurAuth, image)
                .subscribeOn(Schedulers.io());
    }
}
