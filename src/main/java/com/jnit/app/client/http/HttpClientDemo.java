package com.jnit.app.client.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClientDemo {

	public static void performGet() throws ClientProtocolException, IOException{
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet get = new HttpGet("http://localhost:8080/courseApp/users");
		HttpResponse response = client.execute(get);
		HttpEntity entity = response.getEntity();
		String responseJSON = EntityUtils.toString(entity);
		System.out.println(responseJSON);
		client.close();
	}
	
	public static void performPost() throws ClientProtocolException, IOException{
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost("http://localhost:8080/courseApp/users");
		post.addHeader("content-type", ContentType.APPLICATION_JSON.getMimeType());
		String json = "{\"userName\":\"annner.bh@gmail.com\",\"fName\":\"Annne\",\"lName\":\"Bhimavarapu\",\"password\":\"Appi123$\"}";
		StringEntity se = new StringEntity(json);
		post.setEntity(se);
		HttpResponse response = client.execute(post);
		HttpEntity entity = response.getEntity();
		String responseJSON = EntityUtils.toString(entity);
		System.out.println(responseJSON);
		client.close();
	}
	
	public static void performPut() throws ClientProtocolException, IOException{
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPut put = new HttpPut("http://localhost:8080/courseApp/users");
		put.addHeader("content-type", ContentType.APPLICATION_JSON.getMimeType());
		String json = "{\"userId\":7,\"userName\":\"annner.bh1@gmail.com\",\"password\":\"Appi123$\",\"createdDateTime\":[ 2017, 1, 2, 12, 0, 24 ], \"updatedDateTime\":[ 2017, 1, 2, 12, 0, 24 ], \"versionId\":0, \"courses\":[ ], \"fname\":\"Annne\", \"mname\":null, \"lname\":\"Bhimavarapu\" }";
		StringEntity se = new StringEntity(json);
		put.setEntity(se);
		HttpResponse response = client.execute(put);
		HttpEntity entity = response.getEntity();
		String responseJSON = EntityUtils.toString(entity);
		System.out.println(responseJSON);
		client.close();
	}



	public static void performDelete() throws ClientProtocolException, IOException{
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpDelete delete = new HttpDelete("http://localhost:8080/courseApp/users/6");
		HttpResponse response = client.execute(delete);
		HttpEntity entity = response.getEntity();
		String responseJSON = EntityUtils.toString(entity);
		System.out.println(responseJSON);
		client.close();
	}

	public static void main(String[] args) throws ClientProtocolException, IOException {
		//performPost();
		//performDelete();
		//performPut();
		performGet();
	}

}
