package base.domain.structure;

import java.util.ArrayList;

public abstract class NovelSection {
	
	private ArrayList<NovelSection> children;
	private String summary;
	private String content;
	
	public NovelSection() {
		this.children = new ArrayList<NovelSection>();
	}
	
	/*
	 * If section does not contain children an empty list must be returned.
	 */
	public ArrayList<NovelSection> getChildren() {
		return this.children;
	};
	
	public void addChild(NovelSection child) {
		this.children.add(child);
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	};

}
