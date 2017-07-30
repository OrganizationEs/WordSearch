package jp.es.slangrepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// ResultServletが、DBに接続してkeyWordから用語セット（SlangBean）を抽出し、Arraylistにして返す為のクラス
public class Extract {

	private ArrayList<SlangBean> extractSlangs = new ArrayList<SlangBean>();

	//DBに接続してkeyWordから用語セット（SlangBean）を抽出し、Arraylistにして返す
	public ArrayList<SlangBean> exacExtract(String keyWord){

	    Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // MySQLに接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordsearch_db", "es3_developer", "es3developer");
            System.out.println("MySQLに接続できました。");

            Statement stm = con.createStatement();

    		String regex = "category_id_[1-5]$";
    		Pattern p = Pattern.compile(regex);
    		Matcher m = p.matcher(keyWord);

    		if(m.find()){
    			keyWord = keyWord.replaceAll("category_id_", "");
    			String sql = "select word_name,word_desc from search_word where category_id="+keyWord;
                ResultSet rs = stm.executeQuery(sql);
                while(rs.next()){
                	extractSlangs.add(new SlangBean(rs.getString("word_name"),rs.getString("word_desc"),"未実装"));
                }
    		}else{
    			keyWord = keyWord.replaceAll("　", " ");
    			//if(keyWord.indexOf(" ") > -1){
    				//複数キーワード

    			//}else{
    				//単一キーワード
        			PreparedStatement ps =  con.prepareStatement("select word_name,word_desc from search_word where word_desc like ?");
        			ps.setString(1, "%"+keyWord+"%");
        			ResultSet rs = ps.executeQuery();
        			while(rs.next()){
        				System.out.println(rs.getString("word_name"));
        				extractSlangs.add(new SlangBean(rs.getString("word_name"),rs.getString("word_desc"),"未実装"));
        			}
    			//}
    		}
        } catch (SQLException e1) {
    		System.out.println("SQLException: " + e1.getMessage());
    		System.out.println("SQLState: " + e1.getSQLState());
    		System.out.println(" VendorError: " + e1.getErrorCode());
    	} catch (Exception e2) {
    		System.out.println("Exception: " + e2.getMessage());
    		e2.printStackTrace();
    	} finally {
        	if (con != null) {
            	try {
                	con.close();
            	} catch (SQLException e) {
                	System.out.println("MySQLのクローズに失敗しました。");
            	}
        	}
    	}
		return extractSlangs;
	}

	public ArrayList<SlangBean> getExtractSlangs() {
		return extractSlangs;
	}

	public void setExtractSlangs(ArrayList<SlangBean> extractSlangs) {
		this.extractSlangs = extractSlangs;
	}

}
