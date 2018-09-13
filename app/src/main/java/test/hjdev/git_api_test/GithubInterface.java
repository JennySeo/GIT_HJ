package test.hjdev.git_api_test;

import retrofit2.http.GET;
import retrofit2.http.Query;

interface GithubInterface {


    @GET("/search/users?")
    void searchUser(
            @Query(value = "q", encoded = true) String userKeyword,
            @Query("page") int page);
           // Single<GithubResponse> getPages(@Query("per_page") int perPage));
}
