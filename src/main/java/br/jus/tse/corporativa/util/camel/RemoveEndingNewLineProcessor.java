package br.jus.tse.corporativa.util.camel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class RemoveEndingNewLineProcessor implements Processor {
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		if (in.getBody() instanceof ArrayList && in.getHeader("file-prefix").equals("sources")) {
			ArrayList body = (ArrayList) in.getBody();
			for (int i = 0; i < body.size(); i++) {
				LinkedHashMap map = (LinkedHashMap) body.get(i);
				for (Iterator ite = map.keySet().iterator(); ite.hasNext();) {
					String key = (String) ite.next();
					if (map.get(key) instanceof String) {
						String value = (String) map.get(key);
						if (value != null) {
							map.put(key, value.replace('\n', ' '));
						}
					}
				}
			}
		}
	}
}
