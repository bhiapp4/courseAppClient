package com.jnit.app.client.jersey;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JaxRSClientDemo {

	public static void performGet(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/courseApp/users");
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		String output = response.readEntity(String.class);
		System.out.println(output);
		client.close();
	}

	public static void performPost(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/courseApp/users");
		String json = "{\"userName\":\"banner.bh@gmail.com\",\"fName\":\"Annne\",\"lName\":\"Bhimavarapu\",\"password\":\"Appi123$\"}";
		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(json, MediaType.APPLICATION_JSON));
		String output = response.readEntity(String.class);
		System.out.println(output);
		client.close();
	}

	public static void performDelete(){
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/courseApp/users/8");
		Response response = target.request(MediaType.APPLICATION_JSON).delete();
		System.out.println(response.getStatus());
		client.close();
	}

	public static void main(String[] args) {
		//performGet();
		//performPost();
		performDelete();
	}

}
