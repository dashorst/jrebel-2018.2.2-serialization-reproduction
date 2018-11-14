package com.mycompany;

import org.apache.wicket.markup.html.link.Link;
import org.danekja.java.misc.serializable.SerializableRunnable;

public class LambdaLink extends Link<Void> {
	private static final long serialVersionUID = 1L;

	private SerializableRunnable click;

	public LambdaLink(String id, SerializableRunnable r) {
		super(id);
		this.click = r;
	}

	@Override
	public void onClick() {
		click.run();
	}
}
