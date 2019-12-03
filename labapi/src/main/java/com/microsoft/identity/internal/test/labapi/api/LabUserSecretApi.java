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


import com.microsoft.identity.internal.test.labapi.model.SecretResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabUserSecretApi {
    private ApiClient apiClient;

    public LabUserSecretApi() {
        this(Configuration.getDefaultApiClient());
    }

    public LabUserSecretApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getLabUserSecret
     * @param secret Enter the Lab Name as the Secret Param (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getLabUserSecretCall(String secret, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/LabUserSecret";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (secret != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("secret", secret));

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
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getLabUserSecretValidateBeforeCall(String secret, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getLabUserSecretCall(secret, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Gets the Lab User Secret from Identity Labs User Secret KeyVault.   You need to provide the secret in Query String.
     * If not found it will return the KeyVault providers generic error message &#39;not found&#39;
     * @param secret Enter the Lab Name as the Secret Param (optional)
     * @return SecretResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SecretResponse getLabUserSecret(String secret) throws ApiException {
        ApiResponse<SecretResponse> resp = getLabUserSecretWithHttpInfo(secret);
        return resp.getData();
    }

    /**
     * Gets the Lab User Secret from Identity Labs User Secret KeyVault.   You need to provide the secret in Query String.
     * If not found it will return the KeyVault providers generic error message &#39;not found&#39;
     * @param secret Enter the Lab Name as the Secret Param (optional)
     * @return ApiResponse&lt;SecretResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SecretResponse> getLabUserSecretWithHttpInfo(String secret) throws ApiException {
        com.squareup.okhttp.Call call = getLabUserSecretValidateBeforeCall(secret, null, null);
        Type localVarReturnType = new TypeToken<SecretResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Gets the Lab User Secret from Identity Labs User Secret KeyVault.   You need to provide the secret in Query String. (asynchronously)
     * If not found it will return the KeyVault providers generic error message &#39;not found&#39;
     * @param secret Enter the Lab Name as the Secret Param (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getLabUserSecretAsync(String secret, final ApiCallback<SecretResponse> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getLabUserSecretValidateBeforeCall(secret, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SecretResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
