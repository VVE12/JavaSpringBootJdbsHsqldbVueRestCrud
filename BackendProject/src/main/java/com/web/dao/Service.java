package com.web.dao;

import java.util.List;

import com.web.model.EntityModel;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class Service implements IServiceDao {

	private JdbcTemplate jdbcTemplate;

	public Service(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(EntityModel entityModel) {
		String sql = "INSERT INTO entity (name, description, date, storage, reserved)" +" VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, entityModel.getName(), entityModel.getDescription(), entityModel.getDate(),
				entityModel.getStorage(), entityModel.isReserved());
	}

	@Override
	public void update(EntityModel entityModel, int id) {
		String sql = "UPDATE entity SET name=?, description=?, date=?, storage=?, reserved=?" +" WHERE id=?";
		jdbcTemplate.update(sql, entityModel.getName(), entityModel.getDescription(), entityModel.getDate(),
				entityModel.getStorage(), entityModel.isReserved(), id);
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM entity where id=?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public EntityModel get(int id) {
		String sql = "SELECT * FROM entity where id=" + id;
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(EntityModel.class));
	}

	@Override
	public List<EntityModel> getAll() {
		String sql = "SELECT * FROM entity";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(EntityModel.class));
	}
}
