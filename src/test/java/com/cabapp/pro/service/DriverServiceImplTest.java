package com.cabapp.pro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
 
import com.cabapp.pro.entity.Driver;
import com.cabapp.pro.repository.IDriverRepository;
import com.cabapp.pro.service.DriverServiceImpl;
 
@SpringBootTest
class DriverServiceImplTest {
	@MockBean
	IDriverRepository mockDriverRepository ; 
	@Autowired
	DriverServiceImpl driverService; 
	@Test
	void testInsertDriver() {
		Driver actualOutput = new Driver(null, null, null, null, null, 0, null, null, null, null, null, null, null, null);
		Driver driver = new Driver(null, null, null, null, null, 0, null, null, null, null, null, null, null, null);
		when(mockDriverRepository.save(driver)).thenReturn(actualOutput);
		assertEquals(actualOutput, driverService.InsertDriver(driver));
	}
 
	@Test
	void findByStatus() {
 
		Driver driver = new Driver(null, null, null, null, null);

		//String inputStatus = "Pending";
		String inputStatus = "Pending";
		List<Driver> actualOutput = new ArrayList<>();
		actualOutput.add(driver);
		// ---- preparing actual output using Mock ---
		when(mockDriverRepository.
				findByStatus(inputStatus)).
				thenReturn(actualOutput);
		// calling actual method and comparing expectedOutput with actual output
		assertIterableEquals(actualOutput, 
				driverService.getDriverByStatus
				(inputStatus));
	}
}
 
 
