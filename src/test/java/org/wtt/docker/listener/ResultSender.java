package org.wtt.docker.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;

public class ResultSender {
	private static final ObjectMapper OM = new ObjectMapper();
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String CONTENT_TYPE_VALUE = "application/json";
	private static JestClient jestClient;

	public static void send(final TestStatus testStatus) {

		try {
			String ELASTICSEARCH_URL = PropertiesUtility.loadApplicationProperties().getProperty("es.path");
			System.out.println(ELASTICSEARCH_URL);
			System.out.println(testStatus.getStatus());

			JestClientFactory factory = new JestClientFactory();
			factory.setHttpClientConfig(
					new HttpClientConfig.Builder(ELASTICSEARCH_URL).readTimeout(10000).multiThreaded(true).build());
			jestClient = factory.getObject();
			Index index = new Index.Builder(testStatus).index(PropertiesUtility.properties.getProperty("es.index"))
					.type(PropertiesUtility.properties.getProperty("es.index")).build();
			JestResult result = jestClient.execute(index);
			System.out.println(result.getErrorMessage());
			System.out.println(result);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}