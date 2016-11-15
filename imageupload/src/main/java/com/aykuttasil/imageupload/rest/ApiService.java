package com.aykuttasil.imageupload.rest;

import com.aykuttasil.imageupload.rest.models.ImgurUploadResponse;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;


/**
 * Created by aykutasil on 14.11.2016.
 */

public interface ApiService {

    @Multipart
    @POST("https://api.imgur.com/3/image")
    rx.Observable<ImgurUploadResponse> ImgurUpload(@Header("Authorization") String auth,
                                                   @PartMap Map<String, RequestBody> map);


}
