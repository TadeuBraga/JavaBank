package br.com.tadeu.javabank.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ValidationException extends GenericApplicationException {
	private static final long serialVersionUID = -5032908131990384567L;

	private final List<String> messages = new ArrayList<>();
	private final List<String> fields = new ArrayList<>();

	public ValidationException(int errorCode, List<String> messages, List<String> fields) {
		super(errorCode, null);
		if (messages != null)
			this.messages.addAll(messages);
		if (fields != null)
			this.fields.addAll(fields);
	}
	
	public ValidationException(int errorCode) {
		super(errorCode, null);
	}
	
	@Override
	public String getMessage() {
		if (!messages.isEmpty()) {
			if (messages.size() == fields.size()) {
				return IntStream.range(0, messages.size()).mapToObj(i -> fields.get(i) + ": " + messages.get(i))
						.collect(Collectors.joining(", "));
			} else {
				return this.messages.get(0);
			}
		}
		return null;
	}
	
	public void addMessage(String message) {
		this.messages.add(message);
	}
	
	public void addField(String field) {
		this.fields.add(field);
	}
}