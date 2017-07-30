package jp.es.slangrepository;

// DBから取得される用語セットの定義。
public class SlangBean {

	// 用語そのもの
	private String name;
	// 用語の説明
	private String description;
	// 用語に関連する別の用語
	private String relational;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRelational() {
	 	return relational;
	}
	public void setRelational(String relational) {
		this.relational = relational;
	}


	public SlangBean(String name, String description, String relational) {
		super();
		this.name = name;
		this.description = description;
		this.relational = relational;
	}

	public SlangBean() {
		super();
		this.name = "";
		this.description = "";
		// this.relational = "";
	}
}