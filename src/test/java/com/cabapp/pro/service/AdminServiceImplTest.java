package com.cabapp.pro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cabapp.pro.entity.Admin;
import com.cabapp.pro.repository.IAdminRepository;
import com.cabapp.pro.service.AdminServiceImpl;

@SpringBootTest
class AdminServiceImplTest {
	@MockBean
	IAdminRepository mockAdminRepository ;
	@Autowired
	AdminServiceImpl adminService;
	@Test
	void testInsertAdmin() {
		Admin actualOutput = new Admin(null, null, null, null, null);
		Admin admin=new Admin(null, null, null, null, null);
		
		when(mockAdminRepository.save(admin)).thenReturn(actualOutput);
		
		assertEquals(actualOutput, adminService.insertAdmin(admin));
	}
 
 
}