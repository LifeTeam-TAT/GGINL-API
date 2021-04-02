package org.tat.gginl.api.domains.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tat.gginl.api.domains.Customer;
import org.tat.gginl.api.domains.repository.CustomerRepository;
import org.tat.gginl.api.exception.DAOException;
import org.tat.gginl.api.exception.ErrorCode;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public List<Object[]> findAllNativeObject(Date createdDate, Date updatedDate) {
		return customerRepository.findAllNativeObject(createdDate, updatedDate, createdDate, updatedDate);
	}

	public List<Object> findAllColumnName() {
		return customerRepository.findAllColumnName();
	}

	public Customer findCustomerByIdNoAndIdType(String idNo, String idType) {
		return customerRepository.findCustomerByIdNoAndIdType(idNo, idType);
	}

	@Transactional
	public Optional<Customer> findById(String id) throws DAOException {
		if (!StringUtils.isBlank(id)) {
			if (customerRepository.findById(id).isPresent()) {
				return customerRepository.findById(id);
			} else {
				throw new DAOException(ErrorCode.SYSTEM_ERROR_RESOURCE_NOT_FOUND, id + " not found in Customer");
			}
		} else {
			return Optional.empty();
		}

	}

}
