package com.claim.model.service.impl;

import com.generic.model.service.impl.GenericServiceImpl;

import com.claim.model.dao.ClaimDao;

import com.claim.model.service.ClaimService;

import com.claim.model.entity.Claim;

public class ClaimServiceImpl extends
		GenericServiceImpl<Claim, ClaimDao, Integer> implements   ClaimService {

	/**
	*
	*/
	private static final long serialVersionUID = 1L;

}
