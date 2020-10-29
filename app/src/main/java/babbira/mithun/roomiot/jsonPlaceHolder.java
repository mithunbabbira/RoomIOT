package babbira.mithun.roomiot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface jsonPlaceHolder {

    @GET("update/D2")
    Call<Integer> lights(@Query("value") int value);

    @GET("update/D0")
    Call<Integer> fan(@Query("value") int value);


}
