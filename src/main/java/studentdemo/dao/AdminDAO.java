/**
 * 项目名：student
 * 修改历史：
 * 作者： MZ
 * 创建时间： 2016年1月6日-上午9:59:58
 */
package studentdemo.dao;

import studentdemo.base.BaseDAO;

import java.sql.SQLException;

/**
 * 模块说明： 管理员增删改查
 * 
 */
public class AdminDAO extends BaseDAO {

	private static studentdemo.dao.AdminDAO ad = null;

	public static synchronized studentdemo.dao.AdminDAO getInstance() {
		if (ad == null) {
			ad = new studentdemo.dao.AdminDAO();
		}
		return ad;
	}

	public boolean queryForLogin(String username, String password) {
		boolean result = false;
		if (username.length() == 0 || password.length() == 0) {
			return result;
		}
		String sql = "select * from admin where username=? and password=?";
		String[] param = { username, password };
		rs = db.executeQuery(sql, param);
		try {
			if (rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			destroy();
		}
		return result;
	}

}
