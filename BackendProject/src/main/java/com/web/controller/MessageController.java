package com.web.controller;

import java.util.List;

import com.web.model.EntityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.web.dao.IServiceDao;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MessageController {

	@Autowired
	private IServiceDao service;

	@PostMapping(value = "save")
	public void saveEntity(@RequestBody EntityModel entityModel){
		service.save(entityModel);
	}

	@PutMapping(value = "update={id}")
	public void updateEntity(@RequestBody EntityModel entityModel, @PathVariable int id) {
		service.update(entityModel, id);
	}

	@DeleteMapping(value = "delete={id}")
	public @ResponseBody void deleteEntity(@PathVariable int id){
		service.delete(id);
	}

	@GetMapping(value = "get={id}")
	public EntityModel getEntity(@PathVariable int id){ return service.get(id); }

	@GetMapping
	public List<EntityModel> getAll(){
		return service.getAll();
	}
}
