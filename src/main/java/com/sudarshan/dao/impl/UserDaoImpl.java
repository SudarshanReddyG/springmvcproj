package com.sudarshan.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.sudarshan.dao.UserDao;
import com.sudarshan.model.AppUser;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	NamedParameterJdbcTemplate namedParametJdbcTmplt;

	@Transactional(readOnly=true)
	@Override
	public AppUser findById(Integer id) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);

		String sql = "SELECT * FROM AppUser WHERE ID=:id";
		AppUser appUsr = null;

		try {
			appUsr =  namedParametJdbcTmplt.query(sql, params, new UserResultSet());
		} catch (Exception exp) {
			return null;
		}

		return appUsr;
	}

	@Override
	public List<AppUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void save(AppUser appuser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AppUser appuser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(AppUser appuser) {
		// TODO Auto-generated method stub

	}

	private static final class UserResultSet implements ResultSetExtractor<AppUser> {

		@Override
		public AppUser extractData(ResultSet rs) throws SQLException, DataAccessException {
			AppUser user = new AppUser();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setFramework(convertDelimitedStringToList(rs.getString("framework")));
			user.setAddress(rs.getString("address"));
			user.setCountry(rs.getString("country"));
			user.setNewsletter(rs.getInt("newsletter"));
			user.setNumber(rs.getInt("number"));
			user.setPassword(rs.getString("password"));
			user.setSex(rs.getString("sex"));
			user.setSkill(convertDelimitedStringToList(rs.getString("skill")));
			return user;
		}

	}

	private static List<String> convertDelimitedStringToList(String delimitedString) {

		List<String> result = new ArrayList<String>();

		if (!StringUtils.isEmpty(delimitedString)) {
			result = Arrays.asList(StringUtils.delimitedListToStringArray(delimitedString, ","));
		}
		return result;

	}

	private String convertListToDelimitedString(List<String> list) {

		String result = "";
		if (list != null) {
			result = StringUtils.arrayToCommaDelimitedString(list.toArray());
		}
		return result;

	}

}
