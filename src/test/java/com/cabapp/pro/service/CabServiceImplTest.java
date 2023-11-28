package com.cabapp.pro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
 
import com.cabapp.pro.entity.Cab;
import com.cabapp.pro.repository.ICabRepository;
import com.cabapp.pro.service.CabServiceImpl;
 
@SpringBootTest
class CabServiceImplTest {
		@MockBean
		ICabRepository mockCabRepository ;
		@Autowired
		CabServiceImpl cabService;
		
		
		@Test
		void testViewCab() {
			Cab actualOutput = new Cab(0, null, 0, null, null, null, null);
			Cab c = new Cab(0, null, 0, null, null, null, null);
			
			Optional<Cab> thisTypeOfOutput = Optional.of(c);
			when(mockCabRepository.findById(1)).thenReturn(thisTypeOfOutput);
			
			assertEquals(actualOutput, cabService.viewCab(1));
		}
		
		
		@Test
		void testInsertCab() {
			Cab actualOutput = new Cab(0, null, 0, null, null, null, null);
			Cab cab=new Cab(0, null, 0, null, null, null, null);
			
			when(mockCabRepository.save(cab)).thenReturn(actualOutput);
			
			assertEquals(actualOutput, cabService.insertCab(cab));
		}
		
		
}
 
