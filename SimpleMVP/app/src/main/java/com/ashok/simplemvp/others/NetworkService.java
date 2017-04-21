package com.ashok.simplemvp.others;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Ashok on 20/04/17.
 */

public interface NetworkService {
    public static final long READ_TIMEOUT_MILLIS = TimeUnit.SECONDS.toSeconds(20);

    @GET("repos/{owner}/{repo}/contributors")
    Call<List<Model>> getRepoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

    OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .connectTimeout(READ_TIMEOUT_MILLIS, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT_MILLIS, TimeUnit.SECONDS)
            .writeTimeout(READ_TIMEOUT_MILLIS, TimeUnit.SECONDS)
            .build();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();
}
