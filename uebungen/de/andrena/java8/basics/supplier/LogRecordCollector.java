package de.andrena.java8.basics.supplier;

import java.util.List;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.junit.rules.ExternalResource;

public class LogRecordCollector extends ExternalResource {

	private final Logger logger;
	private CollectingHandler handler;

	public LogRecordCollector(Logger logger) {
		this.logger = logger;
	}

	@Override
	protected void before() throws Throwable {
		handler = new CollectingHandler();
		logger.addHandler(handler);
	}

	@Override
	protected void after() {
		logger.removeHandler(handler);
	}

	public List<LogRecord> getLogRecords() {
		return handler.getLogRecords();
	}

}
