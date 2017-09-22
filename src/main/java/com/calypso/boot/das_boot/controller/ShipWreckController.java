package com.calypso.boot.das_boot.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.calypso.boot.das_boot.model.ShipWreck;
import com.calypso.boot.das_boot.repository.ShipWreckRepository;

@RestController
@RequestMapping("api/v1/")
public class ShipWreckController {

	@Autowired
	private ShipWreckRepository shipwreckrepository;
	@RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
	public List<ShipWreck> list() {
		return shipwreckrepository.findAll();
	}

	@RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
	public ShipWreck create(@RequestBody ShipWreck shipWreck) {
		return shipwreckrepository.saveAndFlush(shipWreck);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
	public ShipWreck get(@PathVariable long id) {
		return shipwreckrepository.findOne(id);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
	public ShipWreck update(@PathVariable long id, @RequestBody ShipWreck shipWreck) {
		ShipWreck existingShipwreck =shipwreckrepository.findOne(id);
		BeanUtils.copyProperties(shipWreck, existingShipwreck);
		return shipwreckrepository.saveAndFlush(existingShipwreck);
	}

	@RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
	public ShipWreck delete(@PathVariable long id) {
		ShipWreck existingShipwreck =shipwreckrepository.findOne(id);
		shipwreckrepository.delete(existingShipwreck);
		return existingShipwreck;
	}

}
