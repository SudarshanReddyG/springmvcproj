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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

		String sql = "SELECT * FROM APPUSER WHERE ID=:id";
		AppUser appUsr = null;

		try {
			appUsr =  namedParametJdbcTmplt.query(sql, params, new UserResultSet());
		} catch (Exception exp) {
			return null;
		}

		return appUsr;
	}

	@Transactional(readOnly=true)
	@Override
	public List<AppUser> findAll() {
		String sql = "SELECT * FROM APPUSER";
		List<AppUser> userList = null;

		try {
			userList = namedParametJdbcTmplt.query(sql, new UserRowMapper());
		} catch(Exception exp) {
			return null;
		}

		return userList;
	}


	@Transactional
	@Override
	public void save(AppUser appuser) {
		String sql = "INSERT INTO APPUSER (ID, NAME, EMAIL, ADDRESS, PASSWORD, NEWSLETTER, FRAMEWORK, SEX, NUM, COUNTRY, SKILL) VALUES "
				+ "  (MY_USER_SEQ.NEXTVAL, :name, :email, :address, :password, :newsletter, :framework, :sex, :num, :country, :skill)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		namedParametJdbcTmplt.update(sql, getSqlParamterSource(appuser), keyHolder);
		appuser.setId(keyHolder.getKey().intValue());
	}


	@Transactional
	@Override
	public void update(AppUser appuser) {
		String sql = "UPDATE APPUSER SET NAME=:name, EMAIL=:email, ADDRESS=:address, PASSWORD=:password, NEWSLETTER=:newsletter, FRAMEWORK=:framework"
				+ " SEX=:sex, NUM=:num, COUNTRY=:country, SKILL=:skill WHERE ID=:id";

		namedParametJdbcTmplt.update(sql, getSqlParamterSource(appuser));
	}
	
	@Transactional
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM APPUSER WHERE id= :id";
		namedParametJdbcTmplt.update(sql, new MapSqlParameterSource("id", id));
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

	private static final class UserRowMapper implements RowMapper<AppUser> {

		@Override
		public AppUser mapRow(ResultSet rs, int arg1) throws SQLException {
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

	private SqlParameterSource getSqlParamterSource(AppUser user) {
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();

		sqlParameterSource.addValue("id", user.getId());
		sqlParameterSource.addValue("name", user.getName());
		sqlParameterSource.addValue("email", user.getEmail());
		sqlParameterSource.addValue("address", user.getAddress());
		sqlParameterSource.addValue("password", user.getPassword());
		sqlParameterSource.addValue("newsletter", user.getNewsletter());

		sqlParameterSource.addValue("framework", convertListToDelimitedString(user.getFramework()));
		sqlParameterSource.addValue("sex", user.getSex());
		sqlParameterSource.addValue("number", user.getNumber());
		sqlParameterSource.addValue("country", user.getCountry());
		sqlParameterSource.addValue("skill", convertListToDelimitedString(user.getSkill()));

		return sqlParameterSource;
	}



}
