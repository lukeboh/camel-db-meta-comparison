package br.jus.tse.corporativa.util.camel;

import java.util.StringTokenizer;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class DiffExtractorInfoProcessor implements Processor {
	public void process(Exchange exchange) throws Exception {
		Message in = exchange.getIn();
		String payload = in.getBody(String.class);
		in.setBody(payload.replaceAll("\n", ""));
		
		StringTokenizer tokenizer = new StringTokenizer(payload, "\t");
		String insertions = tokenizer.nextToken();
		String deletions = tokenizer.nextToken();
		
		String filePrefix = (String) in.getHeader("file-prefix");
		String branchIni = (String) in.getHeader("branch-ini");
		String branchFin = (String) in.getHeader("branch-fin");
		
		in.setHeader(filePrefix + "-metadata." + branchIni +"." + branchFin + ".insertions", insertions);
		in.setHeader(filePrefix + "-metadata." + branchIni +"." + branchFin + ".deletions", deletions);
	}
}
