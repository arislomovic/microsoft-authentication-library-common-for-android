/*
 * Azure Identity Labs API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.microsoft.identity.internal.test.labapi.api;

import com.microsoft.identity.internal.test.labapi.ApiCallback;
import com.microsoft.identity.internal.test.labapi.ApiClient;
import com.microsoft.identity.internal.test.labapi.ApiException;
import com.microsoft.identity.internal.test.labapi.ApiResponse;
import com.microsoft.identity.internal.test.labapi.Configuration;
import com.microsoft.identity.internal.test.labapi.Pair;
import com.microsoft.identity.internal.test.labapi.ProgressRequestBody;
import com.microsoft.identity.internal.test.labapi.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.microsoft.identity.internal.test.labapi.model.TempUser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateTempUserApi {
    private ApiClient apiClient;

    public CreateTempUserApi() {
        this(Configuration.getDefaultApiClient());
    }

    public CreateTempUserApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for post
     * @param usertype You can create the following type of cloud users. Basic, GLOBALMFA, MFAONSPO, MFAONEXO, MAMCA, MDMCA (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call postCall(String usertype, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/CreateTempUser";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (usertype != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("usertype", usertype));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "Access Token" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call postValidateBeforeCall(String usertype, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = postCall(usertype, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Let&#39;s you create a temp (a.k.a LOCKED USER) CLOUD User for testing purposes.   All users created by this API will be auto-deleted after 90 minutes.
     * You can create the following type of cloud users.        1. Basic : Account can be used for all manual testing including password resets, etc      2. GLOBALMFA : User with Global MFA      3. MFAONSPO : User requires MFA on a specific resource and the resource is SharePoint      4. MFAONEXO : User requires MFA on a specific resource and the resource is Exchange Online      5. MAMCA : User requires MAM on SharePoint      6. MDMCA : User requires MDM on SharePoint
     * @param usertype You can create the following type of cloud users. Basic, GLOBALMFA, MFAONSPO, MFAONEXO, MAMCA, MDMCA (optional)
     * @return TempUser
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TempUser post(String usertype) throws ApiException {
        ApiResponse<TempUser> resp = postWithHttpInfo(usertype);
        return resp.getData();
    }

    /**
     * Let&#39;s you create a temp (a.k.a LOCKED USER) CLOUD User for testing purposes.   All users created by this API will be auto-deleted after 90 minutes.
     * You can create the following type of cloud users.        1. Basic : Account can be used for all manual testing including password resets, etc      2. GLOBALMFA : User with Global MFA      3. MFAONSPO : User requires MFA on a specific resource and the resource is SharePoint      4. MFAONEXO : User requires MFA on a specific resource and the resource is Exchange Online      5. MAMCA : User requires MAM on SharePoint      6. MDMCA : User requires MDM on SharePoint
     * @param usertype You can create the following type of cloud users. Basic, GLOBALMFA, MFAONSPO, MFAONEXO, MAMCA, MDMCA (optional)
     * @return ApiResponse&lt;TempUser&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TempUser> postWithHttpInfo(String usertype) throws ApiException {
        com.squareup.okhttp.Call call = postValidateBeforeCall(usertype, null, null);
        Type localVarReturnType = new TypeToken<TempUser>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Let&#39;s you create a temp (a.k.a LOCKED USER) CLOUD User for testing purposes.   All users created by this API will be auto-deleted after 90 minutes. (asynchronously)
     * You can create the following type of cloud users.        1. Basic : Account can be used for all manual testing including password resets, etc      2. GLOBALMFA : User with Global MFA      3. MFAONSPO : User requires MFA on a specific resource and the resource is SharePoint      4. MFAONEXO : User requires MFA on a specific resource and the resource is Exchange Online      5. MAMCA : User requires MAM on SharePoint      6. MDMCA : User requires MDM on SharePoint
     * @param usertype You can create the following type of cloud users. Basic, GLOBALMFA, MFAONSPO, MFAONEXO, MAMCA, MDMCA (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postAsync(String usertype, final ApiCallback<TempUser> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = postValidateBeforeCall(usertype, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TempUser>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
