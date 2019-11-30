package rest;

import com.app.androiddemo_ashishpujari.login.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {


    @POST("auth/login")
    Call<User> callLogin(@Body JsonObject loginObject);

    @GET
    Call<User> getUserDetails(@Header("Authorization") String authorization, @Url String url);

}
