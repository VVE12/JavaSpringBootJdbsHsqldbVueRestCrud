package com.web.dao;

import com.web.model.EntityModel;

import java.util.List;

public interface IServiceDao {

	void save(EntityModel entityModel);
	void update(EntityModel entityModel, int id);
	void delete(int id);
	EntityModel get(int id);
	List<EntityModel> getAll();
}
