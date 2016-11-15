package com.aykuttasil.imageupload.rest.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by aykutasil on 14.11.2016.
 */

public class ImgurUploadResponse extends BaseRestResponse {

    /*
    {
      "data": {
        "id": "9OSxlPB",
        "title": null,
        "description": null,
        "datetime": 1479216915,
        "type": "image/jpeg",
        "animated": false,
        "width": 640,
        "height": 360,
        "size": 48354,
        "views": 0,
        "bandwidth": 0,
        "vote": null,
        "favorite": false,
        "nsfw": null,
        "section": null,
        "account_url": null,
        "account_id": 0,
        "is_ad": false,
        "in_gallery": false,
        "deletehash": "GaRKUOEmpMUt4RE",
        "name": "",
        "link": "http://i.imgur.com/9OSxlPB.jpg"
      },
      "success": true,
      "status": 200
    }
     */


    @Expose
    @SerializedName("data")
    private ModelImgurResponse Data;

    public ModelImgurResponse getData() {
        return Data;
    }

    public void setData(ModelImgurResponse data) {
        Data = data;
    }


    public class ModelImgurResponse {

        @Expose
        @SerializedName("id")
        private String Id;

        @Expose
        @SerializedName("title")
        private String Title;

        @Expose
        @SerializedName("description")
        private String Description;

        @Expose
        @SerializedName("link")
        private String Link;

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public String getLink() {
            return Link;
        }

        public void setLink(String link) {
            Link = link;
        }
    }
}

