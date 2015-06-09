package fsu.cimes.contacts.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonPrintLabel {

	public String getJson(List<GetPrintLabelV> labelList) {

		Gson gson = new Gson();
		String json = gson.toJson(labelList);
		System.out.println(json);
		return json;

	}

}
