package com.claim.model.service.impl;

import com.generic.model.service.impl.GenericServiceImpl;

import com.claim.model.dao.StatusDao;

import com.claim.model.service.StatusService;

import com.claim.model.entity.Status;

public class StatusServiceImpl extends
		GenericServiceImpl<Status, StatusDao, Short> implements   StatusService {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

}
