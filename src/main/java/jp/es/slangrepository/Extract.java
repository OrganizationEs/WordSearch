package jp.es.slangrepository;

import java.util.ArrayList;

// ResultServletが、DBに接続してkeyWordから用語セット（SlangBean）を抽出し、Arraylistにして返す為のクラス
public class Extract {

	private ArrayList<SlangBean> extractSlangs;

	//DBに接続してkeyWordから用語セット（SlangBean）を抽出し、Arraylistにして返す
	public ArrayList<SlangBean> exacExtract(String keyWord){

		//検索した結果の用語セット群
		ArrayList<SlangBean> result = new ArrayList<SlangBean>();

		// ========ここから下では、動作確認のために仮の値を与えている========

		//検索した結果の用語セット数
		int resultCount = 0;

		//仮の値
		resultCount = 3;

		String bufName;
		String bufDisc;
		String bufRela;

		for (int i = 0; i < resultCount; i++) {
			bufName = "name_" + i;
			bufDisc = "discrption_" + i;
			bufRela = "relation_" + i;
			result.add(new SlangBean(bufName,bufDisc,bufRela));
		}

		return result;
	}

	public ArrayList<SlangBean> getExtractSlangs() {
		return extractSlangs;
	}

	public void setExtractSlangs(ArrayList<SlangBean> extractSlangs) {
		this.extractSlangs = extractSlangs;
	}

}
