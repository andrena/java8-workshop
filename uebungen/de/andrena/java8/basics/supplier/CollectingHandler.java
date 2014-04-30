package de.andrena.java8.basics.supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

class CollectingHandler extends Handler {

	private final List<LogRecord> logRecords = new ArrayList<>();

	@Override
	public void publish(LogRecord record) {
		logRecords.add(record);
	}

	public List<LogRecord> getLogRecords() {
		return logRecords;
	}

	@Override
	public void flush() {
	}

	@Override
	public void close() throws SecurityException {
	}

}